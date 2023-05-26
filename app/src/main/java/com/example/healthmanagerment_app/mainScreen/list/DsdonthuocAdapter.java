package com.example.healthmanagerment_app.mainScreen.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.donthuoc.DonThuocAdapter;

import java.util.ArrayList;

public class DsdonthuocAdapter extends RecyclerView.Adapter<DonThuocAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<donthuoc> mHeros;

    public DsdonthuocAdapter(Context mContext, ArrayList<donthuoc> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public DonThuocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_danhsachdonthuoc, parent, false);
        DonThuocAdapter.ViewHolder viewHolder = new DonThuocAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DonThuocAdapter.ViewHolder holder, int position) {
        donthuoc hero = mHeros.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(hero.getTendonthuoc());
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.txttendonthuoc);
        }
    }
}
