package in.tss.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.imageView);
       /* final Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_blink);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);*/

        final RotateAnimation anim = new RotateAnimation(180f, 350f, 25f, 25f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);

// Start animating the image
       // final ImageView splash = (ImageView) findViewById(R.id.splash);
        imageView.startAnimation(anim);

// Later.. stop the animation
       // splash.setAnimation(null);

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (imageView != null) {

                if (imageView.isAttachedToWindow()) {
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                imageView.startAnimation(anim);
                                overridePendingTransition(R.anim.anim_in_fade, R.anim.anim_out_fade);
//                                startRevealAnimation(rootLayout);
//                                rootLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        });
                    }
                }
            }
//        overridePendingTransition(R.anim.anim_in_fade, R.anim.anim_out_fade);
            int time = 2000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                SplashScreenActivity.this.finish();
                overridePendingTransition(R.anim.anim_in_fade, R.anim.anim_out_fade);
            }
        }, time);
        }
    }
}
