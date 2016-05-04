package carlor.centrocomercial;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


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
    private Bitmap avatar1;
    private Bitmap avatar2;
    private Bitmap avatar3;
    private ImageView img1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_validar_avatar, container, false);
        imgb1 = (ImageView) view.findViewById(R.id.imageView8);
        img1 = (ImageView) view.findViewById(R.id.imageView7);
        imgb2 = (ImageView) view.findViewById(R.id.imageView9);
        if(images[1].equals("1")){
            img1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personaje1));
        }else{
            if(images[1].equals("2")){
                img1.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.personaje2));
            }else{
                img1.setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.personaje3));
            }
        }
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuJuego fragment = new MenuJuego(images);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainfragment, fragment);
                fragmentTransaction.commit();
            }
        });
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Avatar fragment = new Avatar(images);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainfragment, fragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
