package edu.auburn.app.diabetestoolkit.activity;

import android.content.Intent;
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
    private static String preString = "file:///android_asset/sys/";
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(getActivity(), WebViewActivity.class);

        switch (id){
            case R.id.llSetting:

                break;
            case R.id.rlAbout:
                intent.putExtra("name","More");
                String url = preString+"about.html";
                intent.putExtra("url",url);
                startActivity(intent);
                break;
            case R.id.rlAck:
                intent.putExtra("name","More");
                String url_Ack = preString+"acknowledgements.html";
                intent.putExtra("url",url_Ack);
                startActivity(intent);
                break;
            case R.id.rlPolicy:
                intent.putExtra("name","More");
                String url_po = preString+"privacyPolicy.html";
                intent.putExtra("url",url_po);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
