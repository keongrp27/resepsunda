package com.example.keong.resepsunda.Resep;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.keong.resepsunda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keong on 23/07/2016.
 */
public class ResepBaseAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<TabelResep> mDataset;

    public ResepBaseAdapter(Activity activity, ArrayList<TabelResep> mDataset) {
        this.activity = activity;
        this.mDataset = mDataset;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder = null;

        if(vi == null) {
            vi = inflater.inflate(R.layout.item_resep, parent, false);
            holder = new ViewHolder();
            holder.itemResepGambar = (ImageView) vi.findViewById(R.id.item_resep_gambar);
            holder.itemResepNama = (TextView) vi.findViewById(R.id.item_resep_nama);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }

        TabelResep item = mDataset.get(position);
        holder.itemResepNama.setText(item.nama_resep);
        Glide.with(activity)
                .load(Uri.parse("file:///android_asset/gambar/"+item.foto))
                .into(holder.itemResepGambar);
        return vi;
    }

    static class ViewHolder {
        ImageView itemResepGambar;
        TextView itemResepNama;
    }
}
