package bbcag.ch.dime.dal;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.List;

import bbcag.ch.dime.db.ImageSqlTable;
import bbcag.ch.dime.model.Gallery;

public class GalleryDao extends BaseDao {
    private static GalleryDao instance;

    private GalleryDao(Context context) {
        super(context);
    }

    public static synchronized GalleryDao getInstance(Context context) {
        if (instance == null) {
            instance = new GalleryDao(context.getApplicationContext());
        }

        if (instance != null && !instance.db.isOpen()) {
            instance.open();
        }
        return instance;
    }

    public List<Gallery> getAll() {
        String[] projection = {
                ImageSqlTable.image_ID,
                ImageSqlTable.image_IMAGE,
                ImageSqlTable.image_NAME,
                ImageSqlTable.image_DATE,
        };

        String sortOrder = String.format("%s ASC, %s ASC", ImageSqlTable.image_DATE, ImageSqlTable.image_NAME);

        Cursor cursor = db.query(
                ImageSqlTable.tableImage,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<Gallery> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            Gallery gallery = new Gallery();
            gallery.setId(cursor.getInt(0));
            gallery.setImage(cursor.getBlob(1));
            gallery.setName(cursor.getString(2));
            gallery.setDate(cursor.getString(3));
            result.add(gallery);
        }

        cursor.close();
        return result;
    }

    public long add(Gallery gallery) throws SQLException {
        ContentValues values = new ContentValues();
        values.put(ImageSqlTable.image_ID, gallery.getId());
        values.put(ImageSqlTable.image_NAME, gallery.getName());
        values.put(ImageSqlTable.image_IMAGE, gallery.getImage());
        values.put(ImageSqlTable.image_DATE, gallery.getDate());
        long newId = db.insertOrThrow(ImageSqlTable.tableImage, null, values);
        return newId;
    }

    public void update(Gallery gallery) {
        ContentValues values = new ContentValues();
        values.put(ImageSqlTable.image_NAME, gallery.getName());
        values.put(ImageSqlTable.image_IMAGE, gallery.getImage());
        values.put(ImageSqlTable.image_DATE, gallery.getDate());
        String where = ImageSqlTable.image_ID + " = ?";
        String[] args = {Integer.toString(gallery.getId())};
        db.update(ImageSqlTable.tableImage, values, where, args);
    }


    public Gallery getByIdOrNull(int id) {
        String[] projection = {
                ImageSqlTable.image_ID,
                ImageSqlTable.image_NAME,
                ImageSqlTable.image_DATE,
                ImageSqlTable.image_IMAGE,
        };

        String where = ImageSqlTable.image_ID + " = ?";
        String[] args = {Integer.toString(id)};

        Cursor cursor = db.query(
                ImageSqlTable.tableImage,
                projection,
                where,
                args,
                null,
                null,
                null
        );

        if (cursor.getCount() == 0) {
            return null;
        }

        cursor.moveToFirst();
        Gallery gallery = new Gallery();
        gallery.setId(cursor.getInt(0));
        gallery.setImage(cursor.getBlob(1));
        gallery.setName(cursor.getString(2));
        gallery.setDate(cursor.getString(3));
        cursor.close();
        return gallery;
    }
}