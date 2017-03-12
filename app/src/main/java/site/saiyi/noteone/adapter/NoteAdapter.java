package site.saiyi.noteone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import site.saiyi.noteone.Module.NoteBo;
import site.saiyi.noteone.R;

/**
 * Created by ding-syi on 2017/3/12.
 */

public class NoteAdapter extends BaseAdapter {

    private ArrayList<NoteBo> noteBos;
    private Context context;

    public NoteAdapter(Context context){
        this.context = context;
        this.noteBos = new ArrayList<>();
    }

    public void setData(List<NoteBo> noteBos){
        this.noteBos.clear();

        if (noteBos != null){
            Collections.reverse(noteBos);
            this.noteBos.addAll(noteBos);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.noteBos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.noteBos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        NoteBo item = noteBos.get(position);

        viewHolder.checkBox.setEnabled(false);
        if (item.getState() == 0){
            viewHolder.checkBox.setChecked(true);
        }

        viewHolder.primaryId.setText(item.getId().toString());
        viewHolder.time.setText(item.getTime_stamp());
        viewHolder.detail.setText(item.getDetail());

        return convertView;
    }

    class ViewHolder{
        TextView primaryId;
        TextView time;
        TextView detail;
        CheckBox checkBox;

        public ViewHolder(View view){
            primaryId = (TextView) view.findViewById(R.id.primary_id);
            time = (TextView) view.findViewById(R.id.time);
            detail = (TextView) view.findViewById(R.id.detail);
            checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        }
    }
}
