package DataLayer;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model_Packages.udm_database_conf;

public class data_lyr_DB_Initialize extends SQLiteOpenHelper {

    private static final udm_database_conf udo_dbconf = new udm_database_conf();

    // Database Version
    private static final int DATABASE_VERSION = udo_dbconf.udjf_Get_DBVersion();

    // Database Name
    private static final String DATABASE_NAME = udo_dbconf.udjf_Get_DBName();

    public data_lyr_DB_Initialize(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE eb_login ( name TEXT NOT NULL" +
                " , email TEXT PRIMARY KEY" +
                " , phone TEXT" +
                " , password TEXT" +
                " , oldpassword TEXT" +
                " , pin TEXT )");

        db.execSQL("CREATE TABLE eb_dailytrantype ( id TEXT PRIMARY KEY NOT NULL" +
                " , name TEXT NOT NULL " +
                " , typecode TEXT" +
                " , trantype TEXT" +
                " , ddcreate TEXT" +
                " , ddmodify TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS eb_login" );
        db.execSQL("DROP TABLE IF EXISTS eb_dailytrantype" );

        // Create tables again
        onCreate(db);
    }

    public void udf_initializedb(){
        try {
            SQLiteDatabase db= this.getReadableDatabase();
            //using simple select query for any table
            db.rawQuery("SELECT * FROM eb_login",null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
