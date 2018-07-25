package ozgenurc.com.myproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import ozgenurc.com.myproject.data.myprojectContract;

public class DonemlerCursorAdapter extends CursorAdapter {
    public DonemlerCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.tek_satir,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView donem =(TextView) view.findViewById(R.id.tvID);
        int notColumnIndex=cursor.getColumnIndex(myprojectContract.DonemEntry.COLUMN_AD);
        String donemIcerigi=cursor.getString(notColumnIndex);
        donem.setText(donemIcerigi);
    }
}
