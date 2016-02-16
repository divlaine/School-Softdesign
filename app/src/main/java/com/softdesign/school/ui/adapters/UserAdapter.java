package com.softdesign.school.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.R;

import com.softdesign.school.data.storage.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> mUsers;

    public UserAdapter(ArrayList<User> users) {
        this.mUsers = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View converView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_contacts_item, parent, false);
        return new UserViewHolder(converView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User user = mUsers.get(position);
        holder.name.setText(user.getmFirstName() + " " + user.getmLastName());
        holder.image.setImageDrawable(user.getmImage());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
