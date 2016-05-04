package carlor.centrocomercial;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    private ImageView img;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        img = (ImageView) view.findViewById(R.id.imageView2);
        Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.home1);
        Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.home2);
        Bitmap img3 = BitmapFactory.decodeResource(getResources(), R.drawable.home3);
        int frameDuration= 250;
        final AnimationDrawable animation = new AnimationDrawable();
        animation.setOneShot(false);
        animation.addFrame(new BitmapDrawable(getResources(), img1),
                frameDuration);
        animation.addFrame(new BitmapDrawable(getResources(),img2),
                frameDuration);
        animation.addFrame(new BitmapDrawable(getResources(),img3),
                frameDuration);
        if (Build.VERSION.SDK_INT < 16) {
            img.setBackgroundDrawable(animation);
        } else {
            img.setBackground(animation);
        }
        img.post(new Runnable() {

            @Override
            public void run() {
                animation.start();
            }

        });

        return view;
    }

}
