package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    protected TextView name;
    protected ImageView image;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.fragment_contacts_name);
        image = (ImageView) itemView.findViewById(R.id.fragment_contacts_icon);
    }
}