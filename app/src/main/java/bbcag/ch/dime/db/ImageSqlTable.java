package bbcag.ch.dime.db;

public class ImageSqlTable extends BaseSqlTable {
    public static final String tableImage = "Image";

    public static final String image_ID = "id";
    public static final String image_IMAGE = "image";
    public static final String image_NAME = "name";
    public static final String image_DATE = "date";


    static String getSqlQueryForCreateTable() {
        String sql = "CREATE TABLE " + tableImage + "(" +
                image_ID + type_INT + type_PRIMARY_KEY + type_AUTOINCREMENT + sep_COMMA +
                image_IMAGE + type_BLOB + sep_COMMA +
                image_NAME + type_VARCHAR45 + sep_COMMA +
                image_DATE + type_DATETIME + " );";

        return sql;
    }

    static String getSqlQueryForDropTable() {
        return "DROP TABLE IF EXISTS " + tableImage;
    }
}
