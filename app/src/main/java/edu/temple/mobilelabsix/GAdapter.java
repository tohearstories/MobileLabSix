package edu.temple.mobilelabsix;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by george on 9/22/16.
 */
public class GAdapter extends ArrayAdapter {

    String[] colors = {"red","green","blue","yellow","magenta"};

    public GAdapter(Context context, int resource, Object[] objects) {

        super(context, resource, objects);

       // this.colors = (String[]) objects;

     //   Resources gRes = context.getResources();
      //  this.colors = gRes.getStringArray(R.array.gColors);

    }


    public View getView(int position, View convertView, ViewGroup parent){

        View v = super.getView(position, convertView, parent);

        v.setBackgroundColor( Color.parseColor(colors[position]) );

        return v;

    }


}
