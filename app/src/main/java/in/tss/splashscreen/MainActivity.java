package in.tss.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void splash1(View view) {
        Intent intent=new Intent(this,SplashScreenActivity.class);
        startActivity(intent);
    }

    public void splash2(View view) {
        Intent intent=new Intent(this,SplashGifActivity.class);
        startActivity(intent);
    }
}
