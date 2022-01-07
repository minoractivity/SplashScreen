package in.tss.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashGifActivity extends AppCompatActivity {
ImageView loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_gif);

        loading= findViewById(R.id.loading);
        Glide.with(this)
                .load(R.drawable.company)
                //.asGif()
//                .placeholder(R.drawable.loading2)
//                .crossFade()
                .into(loading);

        int time = 6000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashGifActivity.this, MainActivity.class));
                SplashGifActivity.this.finish();
                overridePendingTransition(R.anim.anim_in_fade, R.anim.anim_out_fade);
            }
        }, time);
    }

}
