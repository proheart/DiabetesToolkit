package edu.auburn.app.diabetestoolkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.model.StateModel;

/**
 * Created by liguorui on 3/2/16.
 */
public class StateAdapter extends BaseAdapter{
    private Context ctx;
    private List<StateModel> models;
    public StateAdapter(Context context, List<StateModel> stateModels){
        this.ctx = context;
        this.models = stateModels;
    }
    @Override
    public int getCount() {
        return this.models.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public StateModel getItem(int position) {
        return this.models.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_state, null);
            viewHolder = new ViewHolder();
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tvNumber);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setViewData(viewHolder,models.get(position));
        return convertView;
    }
    private void setViewData(ViewHolder viewHolder, StateModel model) {
        if(viewHolder==null||model==null){
            return;
        }
        viewHolder.tvDate.setText(model.getTime());
        viewHolder.tvNumber.setText(model.getBlood());
    }
    static class ViewHolder{
        TextView tvDate;
        TextView tvNumber;
    }
}
