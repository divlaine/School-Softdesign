package com.softdesign.school;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.HomeFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.RoundImage;

import butterknife.ButterKnife;
import butterknife.Bind;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.frame_layout) FrameLayout mFrameLayout;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation_view) NavigationView mNavigationView;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.app_bar) AppBarLayout mAppBar;
    @Nullable @Bind(R.id.drawer_image) ImageView mImageView;
    private Fragment mFragment;
    private View mHeaderLayout;

    AppBarLayout.LayoutParams params = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new HomeFragment()).commit();
        }

        ButterKnife.bind(this);

        setupToolbar();

        mHeaderLayout = (View) mNavigationView.getHeaderView(0);
        mImageView = (ImageView) mHeaderLayout.findViewById(R.id.drawer_image);
        setupDrawer();
    }

    /** Сброс активного статуса дроуера*/
    private void drawerMenuClear(){
        mNavigationView.getMenu().findItem(R.id.drawer_menu_profile).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_menu_contacts).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_menu_settings).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_menu_tasks).setChecked(false);
        mNavigationView.getMenu().findItem(R.id.drawer_menu_team).setChecked(false);
    }

    /** настройка дровера*/
    private void setupDrawer(){
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.drawer_header_profile);
        bm = RoundImage.getCirle(bm, (int) getResources().getDimension(R.dimen.drawer_header_profile_image_size));
        mImageView.setImageBitmap(bm);
        /** установка клик листенера*/
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerMenuClear();
                switch (item.getItemId()) {
                    case R.id.drawer_menu_profile:
                        mFragment = new ProfileFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_menu_profile).setChecked(true);
                        setToolbarTitle(getResources().getString(R.string.drawer_profile));
                        break;
                    case R.id.drawer_menu_contacts:
                        mFragment = new ContactsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_menu_contacts).setChecked(true);
                        setToolbarTitle(getResources().getString(R.string.drawer_contacts));
                        break;
                    case R.id.drawer_menu_settings:
                        mFragment = new SettingsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_menu_settings).setChecked(true);
                        setToolbarTitle(getResources().getString(R.string.drawer_settings));
                        break;
                    case R.id.drawer_menu_tasks:
                        mFragment = new TasksFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_menu_tasks).setChecked(true);
                        setToolbarTitle(getResources().getString(R.string.drawer_tasks));
                        break;
                    case R.id.drawer_menu_team:
                        mFragment = new TeamFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_menu_team).setChecked(true);
                        setToolbarTitle(getResources().getString(R.string.drawer_team));
                        break;
                }

                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, mFragment).addToBackStack(mFragment.getClass().getName()).commit();
                }

                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /** настройка тулбара*/
    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            setToolbarTitle(getResources().getString(R.string.hometask));
            actionBar.setHomeAsUpIndicator(R.drawable.toolbar_options);
        }
        mCollapsingToolbar.setTitle(getResources().getString(R.string.drawer_profile_fio));
        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.actionbar_title_text));
        mCollapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.actionbar_title_text));
    }

    public void lockAppBar(boolean collaps){
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();

        if (collaps) {
            mAppBar.setExpanded(false);
            mAppBar.addOnOffsetChangedListener(this);
        //    params.setScrollFlags(0);
         //   mCollapsingToolbar.setLayoutParams(params);
        }
        else{
            mAppBar.setExpanded(true);
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
            mCollapsingToolbar.setLayoutParams(params);
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mCollapsingToolbar.getHeight() + verticalOffset <= ViewCompat.getMinimumHeight(mCollapsingToolbar) + getResources().getDimension(R.dimen.status_bar_height)) {
            params.setScrollFlags(0);
            mCollapsingToolbar.setLayoutParams(params);
            mAppBar.removeOnOffsetChangedListener(this);
        }
    }

    private void setToolbarTitle(String str){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(str);
        }
    }

    /** настройка клика "Меню"*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mDrawerLayout.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    /** настройка клика "Назад"*/
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            finish();
        } else {
            if (count == 1){
                drawerMenuClear();
            }
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.popBackStack();
            mFragment = fragmentManager.findFragmentById(R.id.frame_layout);
        }
    }
}
