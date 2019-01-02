package example.com.gpp0102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class SecondActicity extends AppCompatActivity {

    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acticity);
        web_view = findViewById(R.id.web_view);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
    }
}
