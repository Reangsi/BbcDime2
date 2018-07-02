package bbcag.ch.dime.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import bbcag.ch.dime.db.ImageDatabaseHelper;

public abstract class BaseDao {
    private ImageDatabaseHelper dbHelper;
    SQLiteDatabase db;

    BaseDao(Context context) {
        dbHelper = ImageDatabaseHelper.getInstance(context);
        open();
    }


    void open() throws SQLiteException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
}
