package com.softdesign.school.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.MainActivity;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.UserAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsFragment extends Fragment {

    @Bind(R.id.contacts_layout) RecyclerView mRecyclerView;
    private UserAdapter userAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    View convertView;
    ArrayList<User> mUsers = new ArrayList<User>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_contacts, container, false);
            ButterKnife.bind(this, convertView);
        }
        getActivity().setTitle(R.string.drawer_contacts);

        generateUsersData();

        Activity activity = getActivity();
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);
        userAdapter = new UserAdapter(mUsers);
        mRecyclerView.setAdapter(userAdapter);
        int itemHeight = (int) getResources().getDimension(R.dimen.fragment_contacts_item_height);
        int size = mUsers.size();
        // без установки высоты не отображаются вообще элементы, если установить мало часть элементов скроется
        mRecyclerView.setMinimumHeight(size * itemHeight);
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((MainActivity) getActivity()).lockAppBar(true);
    }


    /** имитация БД пользователей: генерация данных*/
    private void generateUsersData() {
        mUsers.add((new User(getResources().getDrawable(R.drawable.contact_icon), "Серега", "Волчек")));
        mUsers.add((new User(getResources().getDrawable(R.drawable.contact_icon), "Ваня", "Печенег")));
        mUsers.add((new User(getResources().getDrawable(R.drawable.contact_icon), "Валя", "Сигизмунд")));
        mUsers.add((new User(getResources().getDrawable(R.drawable.contact_icon), "Таня", "Лисичка")));
        mUsers.add((new User(getResources().getDrawable(R.drawable.contact_icon), "Алла", "Румяная")));
    }
}