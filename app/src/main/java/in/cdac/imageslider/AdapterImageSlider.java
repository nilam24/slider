package in.cdac.imageslider;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterImageSlider extends PagerAdapter {


    List<ImagesPojo>pojoList;
    ImagesPojo imagesPojo;
   @BindView(R.id.img_slider)ImageView img;
    AdapterImageSlider(Context context, List<ImagesPojo>pojoList){

      this.pojoList=pojoList;

    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.image_slider_layout,container,false);


        ButterKnife.bind(this,view);
      //  pojoList=new ArrayList<>();
        imagesPojo=new ImagesPojo();
        //imagesPojo=pojoList.get(position);
      //  for(int i=0;i<4;i++) {
            img.setImageResource(pojoList.get(position).getImage_drawable());
            container.addView(view,0);
       // }



        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);

        container.removeView((View) object);

    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }

    @Override
    public int getCount() {
        return pojoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        view.equals(o);
        return true;
    }


    @Nullable
    @Override
    public Parcelable saveState() {


        return super.saveState();
    }
}
