package ozgenurc.com.myproject.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="asgenveritabani.db";
    public static final int DATABASE_VERSION=1;
    public static final String MAHSUL_TABLE_NAME="mahsul";
    public static final String DONEM_TABLE_NAME="donem";
    public static final String GRUP_TABLE_NAME="grup";
    public static final String URUN_TABLE_NAME="urun";

    public static final String TABLE_MAHSUL_CREATE= " CREATE TABLE "+MAHSUL_TABLE_NAME
            + " (kod INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " ad TEXT);";
    public static final String TABLE_DONEM_CREATE= " CREATE TABLE "+DONEM_TABLE_NAME
            + " (kod INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " mkod INTEGER, "
            + " ad TEXT);";
    public static final String TABLE_GRUP_CREATE= " CREATE TABLE "+GRUP_TABLE_NAME
            + " (kod INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " mkod INTEGER, "
            + " dkod INTEGER, "
            + " ad TEXT);";
    public static final String TABLE_URUN_CREATE= " CREATE TABLE "+URUN_TABLE_NAME
            + " (kod INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " mkod INTEGER, "
            + " dkod INTEGER, "
            + " gkod INTEGER, "
            + " ad TEXT, "
            + " damla_dekara TEXT, "
            + " yapraktan_binlt TEXT, "
            + " doz_da, TEXT);";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_MAHSUL_CREATE);
        db.execSQL(TABLE_DONEM_CREATE);
        db.execSQL(TABLE_GRUP_CREATE);
        db.execSQL(TABLE_URUN_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " +MAHSUL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +DONEM_TABLE_NAME);
        db.execSQL("drop TABLE IF EXISTS " +GRUP_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +URUN_TABLE_NAME);
        onCreate(db);
    }
}
