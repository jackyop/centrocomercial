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
public class MenuJuego extends Fragment {
    private String[] images;
    private Bitmap soundOn;
    private Bitmap soundOff;
    public MenuJuego(String[] s ) {
       this.images=s;
    }

    private ImageView img_cup;
    private ImageView img_dep;
    private ImageView img_pj;
    private ImageView imgb1;
    private ImageView imgb2;
    private ImageView imgb3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_menu_juego, container, false);
        img_pj = (ImageView) view.findViewById(R.id.avatar_port);
        if(images[1].equals("1")){
            img_pj.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular1));
        }else{
            if(images[1].equals("2")){
                img_pj.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular2));
            }else{
                img_pj.setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular3));
            }
        }

        img_cup = (ImageView) view.findViewById(R.id.cupcakes);
        img_dep = (ImageView) view.findViewById(R.id.deportes);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        //img_cup.setMinimumHeight(height/2);
        //img_cup.setMinimumWidth(width/2);
        img_cup.getLayoutParams().height = height/2;
        img_cup.getLayoutParams().width = width/2;
        img_dep.getLayoutParams().height = height/2;
        img_dep.getLayoutParams().width = width/2;
        imgb1 = (ImageView) view.findViewById(R.id.imageView22);
        imgb2 = (ImageView) view.findViewById(R.id.imageView23);
        imgb3 = (ImageView) view.findViewById(R.id.imageView24);

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

        return view;
    }

}
