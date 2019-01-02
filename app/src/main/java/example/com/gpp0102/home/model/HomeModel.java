package example.com.gpp0102.home.model;

import java.io.IOException;

import example.com.gpp0102.okhttp.OkHttp3;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HomeModel implements IHomeModel {
   public static Modulecall modulecall;

    public HomeModel(Modulecall modulecall) {
        this.modulecall = modulecall;
    }

    @Override
    public void getModelData(final String url) {
        OkHttp3.OkHttpGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                modulecall.LoadSuccess(response.body().string());
            }
        });

    }
    public interface Modulecall{
         void LoadSuccess(String data);
        public void Failed();
    }
}
