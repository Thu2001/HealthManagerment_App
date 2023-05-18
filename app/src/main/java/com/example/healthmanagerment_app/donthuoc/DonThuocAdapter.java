package com.example.healthmanagerment_app.donthuoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmanagerment_app.R;

import java.util.ArrayList;

public class DonThuocAdapter extends RecyclerView.Adapter<DonThuocAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<thuoc> mHeros;

    public DonThuocAdapter(Context mContext, ArrayList<thuoc> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_donthuoc, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        thuoc hero = mHeros.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(hero.getTenthuoc());
    }

    @Override
    public int getItemCount() {

        return mHeros.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.txttenthuoc);
        }
    }
}
