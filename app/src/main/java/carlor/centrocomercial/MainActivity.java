package carlor.centrocomercial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    private long inicio;
    private long fin;
    private boolean sw = true;
    private boolean sw2 = true;
    private Timer timer;
    public String[] images;
    public int posFragment=0;
    public PopupWindow pw;
    public MediaPlayer bgm;
    public boolean toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            timer= new Timer(extras.getLong("inicio"));
            images =extras.getStringArray("posimage");
            toggle = extras.getBoolean("sonido");
            posFragment=4;
            MenuJuego fragment = new MenuJuego(images);
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainfragment, fragment);
            fragmentTransaction.commit();
            timer.start();
            bgm = MediaPlayer.create(this,R.raw.background);
            bgm.start();
            bgm.setLooping(true);
            if(!toggle){
                bgm.pause();
            }
        }else{
            Esperar espera = new Esperar();
            espera.start();
            Splash fragment = new Splash();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainfragment, fragment);
            fragmentTransaction.commit();
            timer = new Timer(120000);
            timer.start();
            toggle = true;
            bgm = MediaPlayer.create(this,R.raw.background);
            bgm.start();
            bgm.setLooping(true);
        }
    }

    protected void  onResume(){
        super.onResume();
        if(toggle){
            bgm.start();
        }
    }

    protected void onPause(){
        super.onPause();
        bgm.pause();
    }

    public void toggleSound(){
        if(toggle){
            bgm.pause();
            toggle = false;
        }else{
            bgm.start();
            toggle = true;
        }
    }

    public boolean toggleCheck(){
        return toggle;
    }

    public void abrirHome() {
        posFragment=1;
        Home fragment = new Home();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
    }

    public void abrirAvatar() {
        posFragment=2;
        Avatar fragment = new Avatar(images);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
    }

    public void abrirValidarAvatar(){
        posFragment=3;
        ValidarAvatar fragment = new ValidarAvatar(images);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
    }

    public void abrirMenuJuego(){
        posFragment=4;
        MenuJuego fragment = new MenuJuego(images);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
    }

    public void homeClick(View view){
        posFragment=2;
        String[] p = {"1","2","3"};
        if(!(images==null)){
            p=images;
        }
        Avatar fragment = new Avatar(p);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
    }

    public void CambiarActividadCupcakes(View view){
        if(!timer.sw){
            Timeout fragment3 = new Timeout();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainfragment, fragment3);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(this, CupcakesActivity.class);
            intent.putExtra("inicio",timer.fin-timer.ini);
            intent.putExtra("posimage",images);
            intent.putExtra("sonido",toggle);
            timer.interrupt();
            startActivity(intent);
        }
    }

    public void CambiarActividadDeportes(View view){
        if(!timer.sw){
            Timeout fragment3 = new Timeout();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainfragment, fragment3);
            fragmentTransaction.commit();
        }else {
            Intent intent = new Intent(this, DeportesActivity.class);
            intent.putExtra("inicio",timer.fin-timer.ini);
            intent.putExtra("posimage",images);
            intent.putExtra("sonido",toggle);
            timer.interrupt();
            startActivity(intent);
        }
    }

    public void Close(View view){
        pw.dismiss();
    }
    @Override
    public void onBackPressed(){
        try{
                int c = posFragment;
                switch (posFragment){
                    case 1:
                        super.onBackPressed();
                        break;
                    case 2:
                        Home fragment2 = new Home();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.mainfragment, fragment2);
                        fragmentTransaction.commit();
                        c=1;
                        break;
                    case 3:
                        String[] p = {"1","2","3"};
                        if(!(images==null)){
                            p=images;
                        }
                        Avatar fragment = new Avatar(p);
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.mainfragment, fragment);
                        fragmentTransaction2.commit();
                        c=2;
                        break;
                    case 4:
                        ValidarAvatar fragment3 = new ValidarAvatar(images);
                        android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.mainfragment, fragment3);
                        fragmentTransaction3.commit();
                        c=3;
                        break;
                    default:
                        super.onBackPressed();
                        break;
                }
                posFragment=c;

        }
        catch (Exception e) {
            super.onBackPressed();
        }
    }

    public class Esperar extends Thread {
        @Override
        public void run() {
            fin=System.currentTimeMillis()+7000;
            inicio=System.currentTimeMillis();
            while(fin>inicio){
                inicio=System.currentTimeMillis();
            }
            if (sw == true) {
                Home fragment2 = new Home();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainfragment, fragment2);
                fragmentTransaction.commit();
                sw=false;
                posFragment=1;
            }
        }
    }
}
