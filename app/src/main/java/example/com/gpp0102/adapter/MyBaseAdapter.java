package example.com.gpp0102.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import example.com.gpp0102.R;
import example.com.gpp0102.bean.FocusBean;

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<FocusBean.DataBean.TuijianBean.ListBeanX> list;

    public MyBaseAdapter(Context context, List<FocusBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item, null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.img);
            holder.title = convertView.findViewById(R.id.title);
            holder.price = convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //赋值
        ImageLoader.getInstance().displayImage(list.get(position).getImages(),holder.img);
        holder.title.setText(list.get(position).getSubhead());
        holder.price.setText(list.get(position).getPrice()+".00");
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView title, price;
    }
}
