package com.example.healthmanagerment_app.mainScreen.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.donthuoc.DonThuocAdapter;
import com.example.healthmanagerment_app.mainScreen.list.donthuoc;
import com.example.healthmanagerment_app.model.ResponeNotification;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ResponeNotification.Notification> mHeros;

    public NotificationAdapter(Context mContext, ArrayList<ResponeNotification.Notification> mHeros) {
        this.mContext = mContext;
        this.mHeros = mHeros;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_notification, parent, false);
        NotificationAdapter.ViewHolder viewHolder = new NotificationAdapter.ViewHolder(heroView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponeNotification.Notification hero = mHeros.get(position);
//        Glide.with(mContext)
//                .load(hero.getImage())
//                .into(holder.mImageHero);
        holder.mTextName.setText(hero.name);
    }

    @Override
    public int getItemCount() {
        return mHeros.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.notification);
        }
    }
}
