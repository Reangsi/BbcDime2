package bbcag.ch.dime.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper{
    private static final String db_Name = "DimeDb";
    private static final int db_Version = 1;

    private static final String tableImage = "Image";

    private static final String image_ID= "id";
    private static final String image_IMAGE= "image";
    private static final String image_NAME= "name";
    private static final String image_DATE= "date";

    public DbHandler(Context context){
        super(context,db_Name, null, db_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE" + tableImage + "(" +
                image_ID + "INT NOT NULL AUTO_INCREMENT," +
                image_IMAGE + "VARCHAR(45) NOT NULL," +
                image_NAME + "VARCHAR(45) NOT NULL AUTO_INCREMENT," +
                image_DATE + "DATETIME NOT NULL," +
                "PRIMARY KEY (" + image_ID + "));";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Create tables again
        onCreate(db);
    }

    void insertImage(String name, byte[] image, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(image_NAME, name);
        values.put(image_IMAGE, image);
        values.put(image_DATE, date);
        long newRowId = db.insert(tableImage,null, values);
        db.close();
    }
}
