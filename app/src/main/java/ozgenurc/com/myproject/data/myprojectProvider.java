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

public class myprojectProvider extends ContentProvider {

    SQLiteDatabase db;

    //CONTENT PROVIDER ILE ILGILI KISIM
    static final String CONTENT_AUTHORITY="ozgenurc.com.myproject.myprojectprovider";
    static final String PATH_MAHSUL="mahsul";
    static final String PATH_DONEM="donem";

    static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_MAHSUL);
    static final Uri CONTENT_URI2=Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DONEM);

    static final UriMatcher matcher,matcher2;

    static {

        matcher=new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(CONTENT_AUTHORITY, PATH_MAHSUL, 1);
    }

    static {

        matcher2=new UriMatcher(UriMatcher.NO_MATCH);
        matcher2.addURI(CONTENT_AUTHORITY, PATH_DONEM, 1);
    }



    @Override
    public boolean onCreate() {
        DatabaseHelper helper=new DatabaseHelper(getContext());
        db=helper.getWritableDatabase();

        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        switch (matcher.match(uri)){

            case 1:
                Cursor cursor=db.query(DatabaseHelper.TABLE_MAHSUL_CREATE, projection, selection,selectionArgs,null,null,null);
                return cursor;

            default:
                throw new IllegalArgumentException("Bilinmeyen URI"+uri);
        }

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        switch (matcher.match(uri)){

            case 1:
                long eklenenSatirID= db.insert(DatabaseHelper.TABLE_MAHSUL_CREATE, null, values);
                if(eklenenSatirID>0){

                    Uri _uri= ContentUris.withAppendedId(CONTENT_URI, eklenenSatirID);
                    return _uri;
                }
        }
        return null;
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
