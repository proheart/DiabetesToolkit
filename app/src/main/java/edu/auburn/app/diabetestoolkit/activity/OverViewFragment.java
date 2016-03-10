package edu.auburn.app.diabetestoolkit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;
import edu.auburn.app.diabetestoolkit.controller.StateService;

/**
 * Created by liguorui on 2/2/16.
 */
public class OverViewFragment extends BaseFragment implements View.OnClickListener{
    private static String TAG = "DiscoveryFragment";
    private ViewGroup mFragMainLayout;
    private RelativeLayout rlNew, rlReadAll;
    private TextView tvLast, tvDaily, tvWeek, tvMonth, tvTotal;
    private StateService service;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        String last = service.getLast().getBlood();
        String daily = service.getDaily();
        String monthly = service.getMonth();
        String weekly = service.getWeek();
        if (!TextUtils.isEmpty(last)) tvLast.setText(last);
        if (!TextUtils.isEmpty(daily))
            tvDaily.setText(daily);
        if (!TextUtils.isEmpty(weekly))
            tvWeek.setText(weekly);
        if (!TextUtils.isEmpty(monthly))
            tvMonth.setText(monthly);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_overview,null);
        initView();
        return mFragMainLayout;
    }

    private void initView() {
        service = new StateService(getActivity());
        rlNew = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlNew);
        rlReadAll = (RelativeLayout) mFragMainLayout.findViewById(R.id.rlViewAll);
        tvDaily = (TextView) mFragMainLayout.findViewById(R.id.tvDaily);
        tvLast = (TextView) mFragMainLayout.findViewById(R.id.tvLast);
        tvWeek = (TextView) mFragMainLayout.findViewById(R.id.tvWeek);
        tvMonth = (TextView) mFragMainLayout.findViewById(R.id.tvMonth);

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
