package com.example.healthmanagerment_app.donthuoc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.mainScreen.list.donthuoc;
import com.example.healthmanagerment_app.model.ResponePrescription;

import java.util.ArrayList;

public class DonThuocAdapter extends RecyclerView.Adapter<DonThuocAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ResponePrescription.Prescription> mHeros;

    public DonThuocAdapter(Context mContext, ArrayList<ResponePrescription.Prescription> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_danhsachdonthuoc, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponePrescription.Prescription hero = mHeros.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(hero.namePres);
        holder.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, viewThuoc.class);
                intent.putExtra("idPres",hero.getIdPres());
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
            mTextName = itemView.findViewById(R.id.txttendonthuoc);
        }
    }
}
