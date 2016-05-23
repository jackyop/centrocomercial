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
public class Avatar extends Fragment {


    private String[] images;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private Bitmap avatar1;
    private Bitmap avatar2;
    private Bitmap avatar3;
    private Bitmap soundOn;
    private Bitmap soundOff;
    private ImageView imgb1;
    private ImageView imgb2;
    private ImageView imgb3;
    private ImageView imgb4;
    private ImageView imgb5;
    private ImageView imgb6;
    public Avatar(String[] s) {
       this.images=s;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        img1 = (ImageView) view.findViewById(R.id.avatar1);
        img2 = (ImageView) view.findViewById(R.id.avatar2);
        img3 = (ImageView) view.findViewById(R.id.avatar3);
        imgb1 = (ImageView) view.findViewById(R.id.imageView4);
        imgb2 = (ImageView) view.findViewById(R.id.imageView5);
        imgb3 = (ImageView) view.findViewById(R.id.imageView6);
        imgb4 = (ImageView) view.findViewById(R.id.imageView16);
        imgb5 = (ImageView) view.findViewById(R.id.imageView17);
        imgb6 = (ImageView) view.findViewById(R.id.imageView18);

        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_on);
        soundOff = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_off);
        if(((MainActivity)getActivity()).toggleCheck()){
            imgb5.setImageBitmap(soundOn);
        }else{
            imgb5.setImageBitmap(soundOff);
        }

        imgb4.setOnClickListener(new View.OnClickListener() {
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
                //infoimg = (ImageView) ((MainActivity)getActivity()).pw.getContentView().findViewById(R.id.imageView11);
                //infoimg.getLayoutParams().height = (int) (height*0.54);
                //infoimg.getLayoutParams().width =   (int) (width*0.60);
            }
        });
        imgb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toggleSound();
                if(((MainActivity)getActivity()).toggleCheck()){
                    imgb5.setImageBitmap(soundOn);
                }else{
                    imgb5.setImageBitmap(soundOff);
                }
            }
        });
        imgb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).abrirHome();
            }
        });

        avatar1 = BitmapFactory.decodeResource(getResources(), R.drawable.pj_avatar1);
        avatar2 = BitmapFactory.decodeResource(getResources(), R.drawable.pj_avatar2);
        avatar3 = BitmapFactory.decodeResource(getResources(), R.drawable.pj_avatar3);
        asignarImagenes();
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rodarIzquierda();
                asignarImagenes();
            }
        });
       imgb2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               rodarDerecha();
               asignarImagenes();

           }
       });
        imgb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).images=images;
                ((MainActivity)getActivity()).abrirValidarAvatar();
            }
        });
        return view;
    }
    public void rodarIzquierda(){
        String temp;
        temp=images[0];
        images[0]=images[2];
        images[2]=temp;
        temp=images[0];
        images[0]=images[1];
        images[1]=temp;

    }
    public void rodarDerecha(){
        String temp;
        temp=images[0];
        images[0]=images[1];
        images[1]=temp;
        temp=images[0];
        images[0]=images[2];
        images[2]=temp;
    }
    public void asignarImagenes(){
        if(images[0].equals("1")){
            img1.setImageBitmap(avatar1);
            if(images[1].equals("2")){
                img2.setImageBitmap(avatar2);
                img3.setImageBitmap(avatar3);
            }else{
                img2.setImageBitmap(avatar3);
                img3.setImageBitmap(avatar2);
            }
        }else{
            if(images[0].equals("2")){
                img1.setImageBitmap(avatar2);
                if(images[1].equals("1")){
                    img2.setImageBitmap(avatar1);
                    img3.setImageBitmap(avatar3);
                }else{
                    img2.setImageBitmap(avatar3);
                    img3.setImageBitmap(avatar1);
                }
            }else{
                img1.setImageBitmap(avatar3);
                if(images[1].equals("1")){
                    img2.setImageBitmap(avatar1);
                    img3.setImageBitmap(avatar2);
                }else{
                    img2.setImageBitmap(avatar2);
                    img3.setImageBitmap(avatar1);
                }
            }
        }
    }
}
