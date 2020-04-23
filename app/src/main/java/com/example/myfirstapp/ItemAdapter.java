package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] options;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context c, String[] o, String[] p, String[] d)
    {
        options = o;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return options.length;
    }

    @Override
    public Object getItem(int position) {
        return options[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionText);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceView);

        String name = options[position];
        String price = prices[position];
        String desc = descriptions[position];



        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(price);

        return v;
    }
}
