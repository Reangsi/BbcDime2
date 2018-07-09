package bbcag.ch.dime.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDatabaseHelper extends SQLiteOpenHelper {
    private static ImageDatabaseHelper instance;

    private static final String DATABASE_NAME = "DimeDatabase3";
    private static final int DATABASE_VERSION = 2;

    private ImageDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public static synchronized ImageDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ImageDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ImageSqlTable.getSqlQueryForCreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
