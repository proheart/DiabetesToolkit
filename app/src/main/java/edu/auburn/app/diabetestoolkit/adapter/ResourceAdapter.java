package edu.auburn.app.diabetestoolkit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.model.ReadModel;

/**
 * Created by liguorui on 3/2/16.
 */
public class ResourceAdapter extends BaseAdapter{
    private Context ctx;
    private List<ReadModel> models;
    public ResourceAdapter(Context context, List<ReadModel> readModels){
        this.ctx = context;
        this.models = readModels;
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
    public ReadModel getItem(int position) {
        return this.models.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_reads, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setViewData(viewHolder,models.get(position));
        return convertView;
    }
    private void setViewData(ViewHolder viewHolder, ReadModel model) {
        if(viewHolder==null||model==null){
            return;
        }
        viewHolder.tvName.setText(model.getName());
    }
    static class ViewHolder{
        TextView tvName;
    }
}
