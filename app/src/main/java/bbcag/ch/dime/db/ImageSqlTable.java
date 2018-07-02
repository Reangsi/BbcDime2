package bbcag.ch.dime.db;

public class ImageSqlTable extends BaseSqlTable {
    public static final String tableImage = " Image";

    public static final String image_ID= "id";
    public static final String image_IMAGE= "image";
    public static final String image_NAME= "name";
    public static final String image_DATE= "date";


    static String getSqlQueryForCreateTable()
    {
        return "CREATE TABLE" + tableImage + "(" +
                image_ID + type_INT + type_NOTNULL + sep_COMMA  +
                image_IMAGE + type_VARCHAR45 + type_NOTNULL + sep_COMMA +
                image_NAME + type_VARCHAR45 + type_NOTNULL + sep_COMMA +
                image_DATE + type_DATETIME + type_NOTNULL + " );";
    }

    static String getSqlQueryForDropTable()
    {
        return "DROP TABLE IF EXISTS " + tableImage;
    }
}
