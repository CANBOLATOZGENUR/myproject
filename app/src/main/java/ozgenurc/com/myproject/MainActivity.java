package ozgenurc.com.myproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ozgenurc.com.myproject.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper helper=new DatabaseHelper(this);
        SQLiteDatabase db=helper.getReadableDatabase();
    }

    public void TumMahsulleriListele(View view) {

        tumMahsulleriGosterenMethod();
    }
    public void tumMahsulleriGosterenMethod(){


    }

}
