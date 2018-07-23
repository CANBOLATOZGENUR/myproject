package ozgenurc.com.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class DonemActivity extends AppCompatActivity {
    ListView urunListesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donem);
        urunListesi=(ListView)findViewById(R.id.urunlerID);
        String[] urunler = getResources().getStringArray(R.array.urunListesi);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DonemActivity.this, android.R.layout.simple_list_item_1,urunler);
        urunListesi.setAdapter(adapter);
        urunListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DonemActivity.this, UrunActivity.class);
                String tiklanilanDonem = (String) urunListesi.getItemAtPosition(position);
                intent.putExtra("ad", tiklanilanDonem);
                startActivity(intent);
            }
        });
    }
}
