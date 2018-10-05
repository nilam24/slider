package in.cdac.imageslider;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.viewPager1)
    ViewPager pager;
    @BindView(R.id.circleIndicator)
    CirclePageIndicator indicator;
    List<ImagesPojo> list;
    AdapterImageSlider adapterImageSlider;
    int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
        list = new ArrayList<>();

        int image_id[] = new int[]{R.drawable.bird, R.drawable.cycle, R.drawable.flower, R.drawable.girl};

        ImagesPojo pojo = new ImagesPojo();

        for (int i = 0; i < image_id.length; i++) {
            pojo.setImage_drawable(image_id[i]);
            list.add(pojo);
        }

        adapterImageSlider = new AdapterImageSlider(this, list);
        pager.setAdapter(adapterImageSlider);

        indicator.setViewPager(pager);

        //Set circle indicator radius
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        final int NUM_PAGES = list.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
}