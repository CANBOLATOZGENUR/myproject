package ozgenurc.com.myproject.data;

import android.provider.BaseColumns;

public class myprojectContract {

    public static final class MahsulEntry implements BaseColumns{

        public static final String TABLE_NAME="mahsul";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
    }

    public static final class DonemEntry implements BaseColumns{

        public static final String TABLE_NAME= "donem";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_MKOD="mkod";

    }

    public static final class GrupEntry implements BaseColumns{

        public static final String TABLE_NAME= "grup";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_MKOD="mkod";
        public static final String COLUMN_DKOD="dkod";
    }


    public  static final class UrunEntry implements BaseColumns {
        public static final String TABLE_NAME = "urun";
        public static final String KOD=BaseColumns._ID;
        public static final String COLUMN_AD="ad";
        public static final String COLUMN_DAMLADEKARA="damla_dekara";
        public static final String COLUMN_YAPRAKTANLT="yapraktan_1000lt";
        public static final String COLUMN_UYGULAMASEKLI="uygulama_sekli";
        public static final String COLUMN_DOZDA="doz_da";
        public static final String COLUMN_MKOD="mkod";
        public static final String COLUMN_DKOD="dkod";
        public static final String COLUMN_GKOD="gkod";
    }
}
