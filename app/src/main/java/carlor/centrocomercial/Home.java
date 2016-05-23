package carlor.centrocomercial;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    private ImageView img;
    private ImageView imgb1;
    private ImageView imgb2;
    private ImageView imgb3;
    private Bitmap soundOn;
    private Bitmap soundOff;
    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        img = (ImageView) view.findViewById(R.id.imageView2);
        imgb1 = (ImageView) view.findViewById(R.id.imageView12);
        imgb2 = (ImageView) view.findViewById(R.id.imageView14);
        imgb3 = (ImageView) view.findViewById(R.id.imageView15);

        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_on);
        soundOff = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_off);
        if(((MainActivity)getActivity()).toggleCheck()){
            imgb2.setImageBitmap(soundOn);
        }else{
            imgb2.setImageBitmap(soundOff);
        }

        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics metrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;
                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ((MainActivity)getActivity()).pw = new PopupWindow(
                        inflater.inflate(R.layout.info, null, false),
                        900,
                        900,
                        true);
                ((MainActivity)getActivity()).pw.showAtLocation(view.findViewById(R.id.main), Gravity.CENTER, 0, 0);
            }
        });
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toggleSound();
                if(((MainActivity)getActivity()).toggleCheck()){
                    imgb2.setImageBitmap(soundOn);
                }else{
                    imgb2.setImageBitmap(soundOff);
                }
            }
        });
        imgb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).abrirHome();
            }
        });
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img);
        Glide.with(this).load(R.drawable.home).into(imageViewTarget);
       /* Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.home1);
        //Bitmap img2 = BitmapFactory.decodeResource(getResources(), R.drawable.home2);
        //Bitmap img3 = BitmapFactory.decodeResource(getResources(), R.drawable.home3);
        int frameDuration= 250;
        final AnimationDrawable animation = new AnimationDrawable();
        //animation.setOneShot(false);
        animation.addFrame(new BitmapDrawable(getResources(), img1),
                frameDuration);
        //animation.addFrame(new BitmapDrawable(getResources(),img2),
          //      frameDuration);
       // animation.addFrame(new BitmapDrawable(getResources(),img3),
         //       frameDuration);
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

        });*/
        return view;
    }


}
