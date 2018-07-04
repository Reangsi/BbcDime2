package bbcag.ch.dime.db;

import android.provider.BaseColumns;

class BaseSqlTable implements BaseColumns {
    static final String sep_COMMA = ",";
    static final String type_VARCHAR45 = " VARCHAR(255)";
    static final String type_INT = " INTEGER";
    static final String type_DATETIME = " DATETIME";
    static final String type_BLOB = " BLOB";
    static final String type_AUTOINCREMENT = " AUTOINCREMENT";
    static final String type_PRIMARY_KEY = " PRIMARY KEY";
}
