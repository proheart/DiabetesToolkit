package edu.auburn.app.diabetestoolkit.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;

/**
 * Created by liguorui on 2/2/16.
 */
public class MoreFragment extends BaseFragment{
    private static String TAG = "MoreFragment";
    private ViewGroup mFragMainLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_more,null);
        return mFragMainLayout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
