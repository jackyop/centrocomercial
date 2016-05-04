package carlor.centrocomercial;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daasuu.library.DisplayObject;
import com.daasuu.library.FPSTextureView;
import com.daasuu.library.drawer.SpriteSheetDrawer;


/**
 * A simple {@link Fragment} subclass.
 */
public class Splash extends Fragment {

    private FPSTextureView mFPSTextureView;
    private double height;
    private double width;
    public Splash() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        mFPSTextureView = (FPSTextureView) view.findViewById(R.id.animation_texture_view);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displaymetrics);
         height = displaymetrics.heightPixels;
         width = displaymetrics.widthPixels;
        addAnimation();
        return view;
    }
    public void addAnimation(){
        Bitmap ave = BitmapFactory.decodeResource(getResources(), R.drawable.spriteave);
        ave=Bitmap.createScaledBitmap(ave,600,600,false);
        long width2 = (new Double(width)).longValue();
        height=height*0.4;
        width=width*0.82;

        float posx = (float) width;
        float posy = (float) height;
        SpriteSheetDrawer ave1 = new SpriteSheetDrawer(
                ave,
                200,
                200,
                7)
                .spriteLoop(true);
        DisplayObject displayObject = new DisplayObject();
        displayObject
                .with(ave1)
                .tween()
                .tweenLoop(true)
                .transform(posx,posy)
                .toX(width2, 0)
                .end();
        mFPSTextureView.addChild(displayObject).tickStart();

    }
}
