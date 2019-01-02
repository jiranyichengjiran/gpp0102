package example.com.gpp0102.okhttp;



import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttp3 {
    public static void OkHttpGet(String url, okhttp3.Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
