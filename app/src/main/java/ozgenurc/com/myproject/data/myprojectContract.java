package ozgenurc.com.myproject.data;
import android.net.Uri;
import android.provider.BaseColumns;

public class myprojectContract {

    public static final String CONTENT_AUTHORITY="ozgenurc.com.myproject.myprojectprovider";
    public static final String PATH_MAHSUL="mahsul";
    public static final String PATH_DONEM="donem";
    public static final String PATH_GRUP="grup";
    public static final String PATH_URUN="urun";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://" +CONTENT_AUTHORITY);

    public static final class MahsulEntry implements BaseColumns {
        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_MAHSUL);
        public static final String TABLE_NAME="mahsul";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";}

    public static final class DonemEntry implements BaseColumns{
        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DONEM);
        public static final String TABLE_NAME= "donem";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_MKOD="mkod";}

    public static final class GrupEntry implements BaseColumns{
        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_GRUP);
        public static final String TABLE_NAME= "grup";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_MKOD="mkod";
        public static final String COLUMN_DKOD="dkod";}

    public  static final class UrunEntry implements BaseColumns {
        public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_URUN);
        public static final String TABLE_NAME = "urun";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_DAMLADEKARA="damla_dekara";
        public static final String COLUMN_YAPRAKTANLT="yapraktan_1000lt";
        public static final String COLUMN_UYGULAMASEKLI="uygulama_sekli";
        public static final String COLUMN_DOZDA="doz_da";
        public static final String COLUMN_MKOD="mkod";
        public static final String COLUMN_DKOD="dkod";
        public static final String COLUMN_GKOD="gkod";}}
