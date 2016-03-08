package edu.auburn.app.diabetestoolkit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;

/**
 * Created by liguorui on 2/2/16.
 */
public class OverViewFragment extends BaseFragment implements View.OnClickListener{
    private static String TAG = "DiscoveryFragment";
    private ViewGroup mFragMainLayout;
    private RelativeLayout rlNew, rlReadAll;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_overview,null);
        initView();
        return mFragMainLayout;
    }

    private void initView() {
        rlNew = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlNew);
        rlReadAll = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlViewAll);
        rlNew.setOnClickListener(this);
        rlReadAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.rlNew:
                Intent intent1 = new Intent(getContext(),AddStateActivity.class);
                startActivity(intent1);
                break;
            case R.id.rlViewAll:
                Intent intent = new Intent(getContext(), ViewStateActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
