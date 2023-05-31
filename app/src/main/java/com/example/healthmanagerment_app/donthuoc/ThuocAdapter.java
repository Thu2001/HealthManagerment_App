package com.example.healthmanagerment_app.donthuoc;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.chitietthuoc.chitietthuoc;
import com.example.healthmanagerment_app.mainScreen.info.uploadinfo.uploadinfo1;
import com.example.healthmanagerment_app.mainScreen.mainScreen;

import java.util.ArrayList;

public class ThuocAdapter extends RecyclerView.Adapter<ThuocAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<thuoc> mHeros;

    public ThuocAdapter(Context mContext, ArrayList<thuoc> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_donthuoc, parent, false);
        ThuocAdapter.ViewHolder viewHolder = new ThuocAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        thuoc hero = mHeros.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(hero.getTenthuoc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, chitietthuoc.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.txttenthuoc);
        }
    }
}
