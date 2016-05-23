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


/**
 * A simple {@link Fragment} subclass.
 */
public class ValidarAvatar extends Fragment {

    private String images[];
    public ValidarAvatar(String s[]) {
        this.images=s;
        // Required empty public constructor
    }

    private ImageView imgb1;
    private ImageView imgb2;
    private Bitmap soundOn;
    private Bitmap soundOff;
    private ImageView img1;
    private ImageView imgb3;
    private ImageView imgb4;
    private ImageView imgb5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_validar_avatar, container, false);
        imgb1 = (ImageView) view.findViewById(R.id.imageView8);
        img1 = (ImageView) view.findViewById(R.id.imageView7);
        imgb2 = (ImageView) view.findViewById(R.id.imageView9);
        imgb3 = (ImageView) view.findViewById(R.id.imageView19);
        imgb4 = (ImageView) view.findViewById(R.id.imageView20);
        imgb5 = (ImageView) view.findViewById(R.id.imageView21);
        if(images[1].equals("1")){
            img1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_retrato1));
        }else{
            if(images[1].equals("2")){
                img1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_retrato2));
            }else{
                img1.setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.pj_retrato3));
            }
        }

        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_on);
        soundOff = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_off);
        if(((MainActivity)getActivity()).toggleCheck()){
            imgb4.setImageBitmap(soundOn);
        }else{
            imgb4.setImageBitmap(soundOff);
        }

        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).images=images;
                ((MainActivity)getActivity()).abrirMenuJuego();
            }
        });
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).images=images;
                ((MainActivity)getActivity()).abrirAvatar();
            }
        });
        imgb3.setOnClickListener(new View.OnClickListener() {
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
        imgb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toggleSound();
                if(((MainActivity)getActivity()).toggleCheck()){
                    imgb4.setImageBitmap(soundOn);
                }else{
                    imgb4.setImageBitmap(soundOff);
                }
            }
        });
        imgb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).abrirHome();
            }
        });
        return view;
    }
}
