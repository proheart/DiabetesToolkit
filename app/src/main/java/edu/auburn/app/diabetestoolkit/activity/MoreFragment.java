package edu.auburn.app.diabetestoolkit.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;

/**
 * Created by liguorui on 2/2/16.
 */
public class MoreFragment extends BaseFragment implements View.OnClickListener{
    private static String TAG = "MoreFragment";
    private ViewGroup mFragMainLayout;
    private LinearLayout llSettings;
    private RelativeLayout rlPolicy, rlAbout, rlAck;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_more,null);
        initView();
        return mFragMainLayout;
    }

    private void initView() {
        llSettings = (LinearLayout) mFragMainLayout.findViewById(R.id.llSetting);
        rlAbout = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlAbout);
        rlAck = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlAck);
        rlPolicy = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlPolicy);
        llSettings.setOnClickListener(this);
        rlAbout.setOnClickListener(this);
        rlAck.setOnClickListener(this);
        rlPolicy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
