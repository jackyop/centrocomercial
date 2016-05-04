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
public class MenuJuego extends Fragment {
    private String[] images;
    private Bitmap avatar1;
    private Bitmap avatar2;
    private Bitmap avatar3;
    public MenuJuego(String[] s ) {
       this.images=s;
    }

    private ImageView img_cup;
    private ImageView img_dep;
    private ImageView img_pj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_juego, container, false);
        img_pj = (ImageView) view.findViewById(R.id.avatar_port);
        if(images[1].equals("1")){
            img_pj.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular));
        }else{
            if(images[1].equals("2")){
                img_pj.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular));
            }else{
                img_pj.setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.pj_circular));
            }
        }
        return view;
    }

}
