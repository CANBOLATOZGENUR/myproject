package ozgenurc.com.myproject;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import ozgenurc.com.myproject.data.myprojectContract;

public class MainActivity extends AppCompatActivity {
    ListView donemListesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donemListesi=(ListView)findViewById(R.id.listView);
        //Donemlere işlevsellik kazandıracak metot

        Cursor cursor=donemleriGoster();
        DonemlerCursorAdapter adapter=new DonemlerCursorAdapter(this,cursor,false);
        donemListesi.setAdapter(adapter);

        donemListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DonemActivity.class);
                String tiklanilanDonem = (String) donemListesi.getItemAtPosition(position);
                intent.putExtra("ad", tiklanilanDonem);
                startActivity(intent);
            }
        });
    }
    private void mahsulEkle(){
        ContentValues values=new ContentValues();
        values.put(myprojectContract.MahsulEntry.COLUMN_AD,"DOMATES");
        Uri _uri=getContentResolver().insert(myprojectContract.MahsulEntry.CONTENT_URI,values);
        Toast.makeText(this, "Eklendi:"+_uri,Toast.LENGTH_LONG).show();
    }
    private void donemEkle(){
        ContentValues values=new ContentValues();
        values.put(myprojectContract.DonemEntry.COLUMN_AD,"Fideler toprağa şaşırtıldıktan sonra");
        Uri _uri=getContentResolver().insert(myprojectContract.DonemEntry.CONTENT_URI,values);
        Toast.makeText(this, "Eklendi:"+_uri,Toast.LENGTH_LONG).show();
    }
    private Cursor donemleriGoster(){
        String[] projection={"donem._id","mahsul._id","donem.ad"};
        Cursor cursor= getContentResolver().query(myprojectContract.DonemEntry.CONTENT_URI, projection,null,null,null);
       /* String tumNotlar="";
        while(cursor.moveToNext()){
            for(int i=0; i<=3; i++){
                tumNotlar=tumNotlar+cursor.getString(i)+" - "; }
            tumNotlar += "\n"; }
        Toast.makeText(this, tumNotlar, Toast.LENGTH_LONG).show();
        Log.d("VERI", tumNotlar); */
        return cursor; } }
