package carlor.centrocomercial;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


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
    private ImageView imgb1;
    private ImageView imgb2;
    private ImageView imgb3;

    public Avatar(String[] s) {
       this.images=s;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        img1 = (ImageView) view.findViewById(R.id.avatar1);
        img2 = (ImageView) view.findViewById(R.id.avatar2);
        img3 = (ImageView) view.findViewById(R.id.avatar3);
        imgb1 = (ImageView) view.findViewById(R.id.imageView4);
        imgb2 = (ImageView) view.findViewById(R.id.imageView5);
        imgb3 = (ImageView) view.findViewById(R.id.imageView6);
        avatar1 = BitmapFactory.decodeResource(getResources(), R.drawable.personaje1);
        avatar2 = BitmapFactory.decodeResource(getResources(), R.drawable.personaje2);
        avatar3 = BitmapFactory.decodeResource(getResources(), R.drawable.personaje3);
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
                ValidarAvatar fragment = new ValidarAvatar(images);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainfragment, fragment);
                fragmentTransaction.commit();
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
