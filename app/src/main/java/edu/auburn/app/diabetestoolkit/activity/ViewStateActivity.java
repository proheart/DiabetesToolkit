package edu.auburn.app.diabetestoolkit.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseActivity;
import edu.auburn.app.diabetestoolkit.adapter.StateAdapter;
import edu.auburn.app.diabetestoolkit.controller.StateService;
import edu.auburn.app.diabetestoolkit.model.StateModel;

/**
 * Created by liguorui on 3/5/16.
 */
public class ViewStateActivity extends BaseActivity implements View.OnClickListener{
    private StateService service;
    private ListView lvStates;
    private StateAdapter adapter;
    private static List<StateModel> lists;
    private TextView tvBack;
    private TextView tvTitle;
    private LongClickListener longClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_state);
        initView();

    }

    private void initView() {
        lvStates = (ListView)findViewById(R.id.lvStates);
        tvBack = (TextView)findViewById(R.id.btnBack);
        tvTitle = (TextView)findViewById(R.id.tvName);
        tvTitle.setText("Blood State");
        tvBack.setOnClickListener(this);
        service = new StateService(this);
        /* init db data
        service.clearAll();
        String time = String.valueOf(System.currentTimeMillis());
        for (int i = 0;i<7;i++){
            service.add(new StateModel(time, 100+i+"", "note1"));
        }
        */
        lists = service.getList();
        adapter = new StateAdapter(this, lists);
        lvStates.setAdapter(adapter);
        longClickListener = new LongClickListener();

        lvStates.setOnItemLongClickListener(longClickListener);
    }


    final class LongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
            new AlertDialog.Builder(ViewStateActivity.this)
                    .setTitle("Tips")
                    .setMessage("Delete this item?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            service.delete(lists.get(position).getId());
                            lists.clear();
                            lists.addAll(service.getList());
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
            return true;
        }
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnBack:
                this.finish();
                break;
        }
    }
}
