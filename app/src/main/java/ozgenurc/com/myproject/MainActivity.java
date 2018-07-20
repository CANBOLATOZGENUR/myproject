package ozgenurc.com.myproject;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import ozgenurc.com.myproject.data.myprojectContract;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mahsulEkle();
    }
    private void mahsulEkle(){
        ContentValues values=new ContentValues();
        values.put(myprojectContract.MahsulEntry.COLUMN_AD,"DOMATES");
        values.put(myprojectContract.MahsulEntry.COLUMN_AD,"ANTEP FISTIĞI");
        values.put(myprojectContract.MahsulEntry.COLUMN_AD,"MISIR");
        values.put(myprojectContract.MahsulEntry.COLUMN_AD,"PAMUK");
        Uri _uri=getContentResolver().insert(myprojectContract.MahsulEntry.CONTENT_URI,values);
        Toast.makeText(this, "Eklendi:"+_uri,Toast.LENGTH_LONG).show();
    }
}
