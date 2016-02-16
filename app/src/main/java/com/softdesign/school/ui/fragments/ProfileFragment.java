package com.softdesign.school.ui.fragments;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.design.widget.CoordinatorLayout;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v4.app.Fragment;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.softdesign.school.MainActivity;
        import com.softdesign.school.R;

        import static android.view.Gravity.*;

/**
 * Created by bit on 04.02.2016.
 */

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle(R.string.drawer_contacts);
        return convertView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((MainActivity) getActivity()).lockAppBar(true);
        FloatingActionButton mFloationgActionButton = (FloatingActionButton) getActivity().findViewById(R.id.floationg_action_button);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloationgActionButton.getLayoutParams();
        params.setAnchorId(R.id.app_bar);
        params.anchorGravity = BOTTOM | END;
        mFloationgActionButton.setLayoutParams(params);
        mFloationgActionButton.setImageResource(R.drawable.action_button_edit);
    }
}