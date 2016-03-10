package edu.auburn.app.diabetestoolkit.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.auburn.app.diabetestoolkit.DiabetesApplication;
import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseFragment;
import edu.auburn.app.diabetestoolkit.adapter.ResourceAdapter;
import edu.auburn.app.diabetestoolkit.model.ReadModel;

/**
 * Created by liguorui on 2/2/16.
 */
public class EducationFragment extends BaseFragment{
    private static String TAG = "EducationFragment";
    private ViewGroup mFragMainLayout;
    private ListView lvResource;
    private ResourceAdapter adapter;
    private RelativeLayout rlQuiz;
    private ItemClickListener itemListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragMainLayout = (ViewGroup) inflater.inflate(R.layout.fragment_education, null);
        initView();
        return mFragMainLayout;
    }

    private final class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ReadModel m = (ReadModel)parent.getItemAtPosition(position);
            Intent intent = new Intent(getActivity(), WebViewActivity.class);
            intent.putExtra("name","Education");
            intent.putExtra("url",m.getUrl());
            startActivity(intent);
        }
    }
    private void initView(){
        lvResource = (ListView)mFragMainLayout.findViewById(R.id.lvResource);
        rlQuiz = (RelativeLayout)mFragMainLayout.findViewById(R.id.rlQuiz);
        itemListener = new ItemClickListener();
        initData();
    }
    private void initData(){

        List<ReadModel> datas= new ArrayList<ReadModel>();
        AssetManager asset = DiabetesApplication.getApp().getAssets();
        String [] names = null;
        try {
            names = asset.list("reading");
        }catch (IOException e){
            Log.i(TAG,e.toString());
        }
        ReadModel rm;
        for (int i=0; i< names.length;i++){
            rm = new ReadModel();
            rm.setName(names[i]);
            //http://docs.google.com/gviewembedded=true&url=https://drive.google.com/open?id=0B5lDqW9grSfhWVlTR3Mzc0NkZm8
            if(names[i].contains(".html")){
                rm.setUrl("file:///android_asset/reading/"+names[i]);
            }else{
                rm.setUrl("https://docs.google.com/gview?embedded=true&url=http://www.auburn.edu/~czm0062/pdf/" + names[i]);
            }

            datas.add(rm);
        }


        adapter = new ResourceAdapter(DiabetesApplication.getApp(),datas);
        lvResource.setAdapter(adapter);
        lvResource.setOnItemClickListener(itemListener);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
