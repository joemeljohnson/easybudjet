package DataLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model_Packages.udm_database_conf;
import Model_Packages.udm_login;

public class data_lyr_login extends SQLiteOpenHelper {

    private static final udm_database_conf udo_dbconf = new udm_database_conf();
    // Database Version
    private static final int DATABASE_VERSION = udo_dbconf.udjf_Get_DBVersion();

    // Database Name
    private static final String DATABASE_NAME = udo_dbconf.udjf_Get_DBName();

    public data_lyr_login(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean udf_InsertData(udm_login entity_login){
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", entity_login.getUdmo_name());
            values.put("email", entity_login.getUdmo_email());
            values.put("phone",entity_login.getUdmo_phone());
            values.put("password", entity_login.getUdmo_password());
            values.put("oldpassword", entity_login.getUdmo_oldpassword());
            values.put("pin",entity_login.getUdmo_pin());

            // Inserting Row

            db.insert("eb_login",null,values);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            db.close();
            return false;
        }
    }
}
