package carlor.centrocomercial;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {
    private long inicio;
    private long fin;
    private boolean sw = true;
    private boolean sw2 = true;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Splash fragment = new Splash();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainfragment, fragment);
        fragmentTransaction.commit();
        Esperar espera = new Esperar();
        espera.start();
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            timer= new Timer(extras.getLong("inicio"));
            timer.start();
        }else{
            timer = new Timer(120000);
            timer.start();
        }
    }

    public void homeClick(View view){
        String[] p = {"1","2","3"};
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
            timer.interrupt();
            startActivity(intent);
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
            }
        }
    }
}
