package edu.auburn.app.diabetestoolkit.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragmentActivity;
import edu.auburn.app.diabetestoolkit.activity.base.ParentInterface;

public class MainActivity extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener, ParentInterface{
    //Tab Button
    private RadioGroup rgTabGroup ;
    private RadioButton rbOverView, rbMedication, rbForum, rbEducation, rbMore;
    //Fragment Container
    private RelativeLayout rlContent, rlFragment;
    //Fragment
    private BaseFragment bfSubFrag, bfOverView, bfMedication, bfForum, bfEducation, bfMore;

    private String mFragTag = "";

    private TextView tvTitle;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initDataSet();
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView(){
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        rlContent = (RelativeLayout)findViewById(R.id.main_content);
        rlFragment = (RelativeLayout)findViewById(R.id.main_fragment_content);
        rlFragment.setVisibility(View.GONE);

        rgTabGroup = (RadioGroup)findViewById(R.id.main_radio_group);
        rbOverView = (RadioButton)findViewById(R.id.main_radio_button_overview);
        rbMedication = (RadioButton)findViewById(R.id.main_radio_button_medication);
        rbEducation = (RadioButton)findViewById(R.id.main_radio_button_education);
        rbMore = (RadioButton)findViewById(R.id.main_radio_button_more);
        rbForum = (RadioButton)findViewById(R.id.main_radio_button_forum);
        rgTabGroup.setOnCheckedChangeListener(this);
        rbOverView.setChecked(true);
    }
    private void initDataSet(){

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_radio_button_overview:
                if (bfOverView == null) {
                    bfOverView = new OverViewFragment();
                    bfOverView.setParentInterface(this);
                }
                tvTitle.setText(R.string.frag_overview);
                addFragment(bfOverView, R.id.main_radio_button_overview + "");
                break;
            case R.id.main_radio_button_medication:
                if (bfMedication == null) {
                    bfMedication = new MedicationFragment();
                    bfMedication.setParentInterface(this);
                }
                tvTitle.setText(R.string.frag_medication);
                addFragment(bfMedication, R.id.main_radio_button_medication + "");
                break;
            case R.id.main_radio_button_forum:
                if (bfForum == null) {
                    bfForum = new ForumFragment();
                    bfForum.setParentInterface(this);
                }
                tvTitle.setText(R.string.frag_forum);
                addFragment(bfForum, R.id.main_radio_button_forum + "");
                break;
            case R.id.main_radio_button_education:
                if (bfEducation == null) {
                    bfEducation = new EducationFragment();
                    bfEducation.setParentInterface(this);
                }
                tvTitle.setText(R.string.frag_education);
                addFragment(bfEducation, R.id.main_radio_button_education + "");

                break;
            case R.id.main_radio_button_more:

                if (bfMore == null) {
                    bfMore = new MoreFragment();
                    bfMore.setParentInterface(this);
                }
                tvTitle.setText(R.string.frag_more);
                addFragment(bfMore, R.id.main_radio_button_more + "");

                break;
            default:
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void addFragment(BaseFragment frag, String... tags) {
        if (frag != null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            final String tag = tags[0];
            if (TextUtils.equals(mFragTag, tag)) {
                return;
            }
            if (!frag.isAdded()){
                ft.add(rlContent.getId(), frag, tag);
            }
            Fragment curFrag = getSupportFragmentManager().findFragmentByTag(mFragTag);
            if (curFrag != null) {
                ft.hide(curFrag);
            }
            mFragTag = tag;
            ft.show(frag);
            ft.commit();
        }
    }

    @Override
    public void removeFragment(BaseFragment frag, String... tags) {
        if (frag != null && frag.isAdded()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.hide(frag).commitAllowingStateLoss();
        }
    }

    @Override
    public void addSubFragment(BaseFragment frag, String... tags) {
        if (frag != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(rlFragment.getId(), frag);
            bfSubFrag = frag;
            ft.commit();
            rlFragment.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void removeSubFragment(BaseFragment frag, String... tags) {
        if (frag != null && frag.isAdded()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.remove(frag).commitAllowingStateLoss();
            rlFragment.setVisibility(View.GONE);
        }
    }

    @Override
    public void finish() {

        super.finish();
    }
}
