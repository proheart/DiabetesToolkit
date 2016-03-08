package edu.auburn.app.diabetestoolkit.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.auburn.app.diabetestoolkit.DiabetesApplication;

/**
 * Created by liguorui on 2/1/16.
 */
public class BaseFragment extends Fragment {
    private ParentInterface mParentInterface;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    public void setParentInterface(ParentInterface pif){
        mParentInterface = pif;
    }
    public ParentInterface getParentInterface(){
        return mParentInterface;
    }

    public void showToast(String message) {
        Toast.makeText(DiabetesApplication.getApp(), message, Toast.LENGTH_SHORT).show();
    }
    public void showToast(int messageId){
        Toast.makeText(DiabetesApplication.getApp(), messageId, Toast.LENGTH_SHORT).show();
    }
}
