package ozgenurc.com.myproject.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ozgenurc.com.myproject.data.myprojectContract.MahsulEntry;
import ozgenurc.com.myproject.data.myprojectContract.DonemEntry;
import ozgenurc.com.myproject.data.myprojectContract.GrupEntry;
import ozgenurc.com.myproject.data.myprojectContract.UrunEntry;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="asgendatabase.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_MAHSUL_CREATE=
            " CREATE TABLE " + MahsulEntry.TABLE_NAME + " ("+
                    MahsulEntry.KOD + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    MahsulEntry.COLUMN_AD + " TEXT)";

    public static final String TABLE_DONEM_CREATE=
            " CREATE TABLE " + DonemEntry.TABLE_NAME + " ("+
                    DonemEntry.KOD + " INTEGER PRIMARY KEY, "+
                    DonemEntry.COLUMN_MKOD + " INTEGER, "+
                    DonemEntry.COLUMN_AD + " TEXT)";

    public static final String TABLE_GRUP_CREATE=
            " CREATE TABLE " + GrupEntry.TABLE_NAME + " ("+
                    GrupEntry.KOD + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    GrupEntry.COLUMN_MKOD + " INTEGER, "+
                    GrupEntry.COLUMN_DKOD + " INTEGER, "+
                    GrupEntry.COLUMN_AD + " TEXT)";

    public static final String TABLE_URUN_CREATE=
            " CREATE TABLE " + UrunEntry.TABLE_NAME + " ("+
                    UrunEntry.KOD + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    UrunEntry.COLUMN_MKOD + " INTEGER, "+
                    UrunEntry.COLUMN_DKOD + " INTEGER, "+
                    UrunEntry.COLUMN_GKOD + " INTEGER, "+
                    UrunEntry.COLUMN_AD + " TEXT, "+
                    UrunEntry.COLUMN_DAMLADEKARA + " TEXT, "+
                    UrunEntry.COLUMN_YAPRAKTANLT + " TEXT, "+
                    UrunEntry.COLUMN_DOZDA + " TEXT, "+
                    UrunEntry.COLUMN_UYGULAMASEKLI + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); }

        @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_MAHSUL_CREATE);
        db.execSQL(TABLE_DONEM_CREATE);
        db.execSQL(TABLE_GRUP_CREATE);
        db.execSQL(TABLE_URUN_CREATE); }

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + MahsulEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DonemEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GrupEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UrunEntry.TABLE_NAME);
        onCreate(db); }}

