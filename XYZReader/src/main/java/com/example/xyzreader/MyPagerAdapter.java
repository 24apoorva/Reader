package com.example.xyzreader;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.ui.ArticleDetailFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    Cursor cursor;
    public void setCursor(Cursor zcursor) {
        cursor = zcursor;
    }
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        cursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(cursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (cursor != null) ? cursor.getCount() : 0;
    }
}
