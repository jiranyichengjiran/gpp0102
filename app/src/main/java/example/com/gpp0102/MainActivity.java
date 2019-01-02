package example.com.gpp0102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import example.com.gpp0102.adapter.MyBaseAdapter;
import example.com.gpp0102.bean.FocusBean;
import example.com.gpp0102.home.presenter.HomePresenter;
import example.com.gpp0102.home.view.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView {

    private HomePresenter homePresenter;
    private GridView grid_view;
    private MyBaseAdapter myBaseAdapter;
    private List<FocusBean.DataBean.TuijianBean.ListBeanX> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        grid_view = findViewById(R.id.grid_view);
        //绑定presenter
        homePresenter = new HomePresenter(this);
        homePresenter.getPresenterData();
        grid_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                myBaseAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pid = list.get(position).getPid();
                Intent intent = new Intent(MainActivity.this, SecondActicity.class);
                intent.putExtra("id",pid);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getViewData(String viewData) {
        Gson gson = new Gson();
        FocusBean focusBean = gson.fromJson(viewData, FocusBean.class);
        list = focusBean.getData().getTuijian().getList();
        //设置适配器
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myBaseAdapter = new MyBaseAdapter(MainActivity.this, list);
                grid_view.setAdapter(myBaseAdapter);
            }
        });
    }
}
