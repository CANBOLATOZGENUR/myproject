package ozgenurc.com.myproject.data;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class myprojectProvider extends ContentProvider {
    private static final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int URICODE_MAHSUL = 1;
    private static final int URICODE_DONEM = 2;
    private static final int URICODE_GRUP = 3;
    private static final int URICODE_URUN = 4;

    static {
        matcher.addURI(myprojectContract.CONTENT_AUTHORITY, myprojectContract.PATH_MAHSUL, URICODE_MAHSUL);
        matcher.addURI(myprojectContract.CONTENT_AUTHORITY, myprojectContract.PATH_DONEM, URICODE_DONEM);
        matcher.addURI(myprojectContract.CONTENT_AUTHORITY, myprojectContract.PATH_GRUP, URICODE_GRUP);
        matcher.addURI(myprojectContract.CONTENT_AUTHORITY, myprojectContract.PATH_URUN, URICODE_URUN);
    }

    private SQLiteDatabase db;
    private DatabaseHelper helper;

    @Override
    public boolean onCreate() {
        helper = new DatabaseHelper(getContext());
        db = helper.getWritableDatabase();
        return true;
    }
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (matcher.match(uri)) {

            case URICODE_MAHSUL:
                return kayitEkle(uri, values, myprojectContract.MahsulEntry.TABLE_NAME);

            case URICODE_DONEM:
                return kayitEkle(uri, values, myprojectContract.DonemEntry.TABLE_NAME);

            case URICODE_GRUP:
                return kayitEkle(uri, values, myprojectContract.GrupEntry.TABLE_NAME);

            case URICODE_URUN:
                return kayitEkle(uri, values, myprojectContract.UrunEntry.TABLE_NAME);

            default:
                throw new IllegalArgumentException("INSERT BILINMEYEN URI:" + uri);
        }
    }
    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
    private Uri kayitEkle(Uri uri, ContentValues values, String tabloAdi){

        long id= db.insert(tabloAdi, null, values);
        if(id==-1){
            Log.e("myprojectProvider", "INSERT HATA"+uri);
            return null;
        }
        return ContentUris.withAppendedId(uri, id);
    }
}
