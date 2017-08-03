package firstandroid.com.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import firstandroid.com.R;
import firstandroid.com.service.MyService;

/**
 * 服务
 * Created by carol on 2017-08-03.
 */

public class MainServiceActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.me);
        return super.onCreateOptionsMenu(menu);
    }*/

    public void startService(View view){
        startService(new Intent(getBaseContext(),MyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(),MyService.class));
    }
}
