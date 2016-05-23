package carlor.centrocomercial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class CupcakesActivity extends AppCompatActivity {
    Timer timer;
    String[] images;
    boolean toggle;
    public MediaPlayer bgm;
    private ImageView imgb1;
    private ImageView imgb2;
    private ImageView imgb3;
    private Bitmap soundOn;
    private Bitmap soundOff;
    public PopupWindow pw;
    public Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakes);
        context=this;
        Bundle extras = getIntent().getExtras();
        long inicio = extras.getLong("inicio");
        images = extras.getStringArray("posimage");
        toggle = extras.getBoolean("sonido");
        timer = new Timer(inicio);
        timer.start();
        bgm = MediaPlayer.create(this, R.raw.background);
        bgm.start();
        bgm.setLooping(true);
        if(!toggle){
            bgm.pause();
        }
        imgb1 = (ImageView) findViewById(R.id.imageView28);
        imgb2 = (ImageView) findViewById(R.id.imageView29);
        imgb3 = (ImageView) findViewById(R.id.imageView30);
        soundOn = BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_on);
        soundOff= BitmapFactory.decodeResource(getResources(), R.drawable.btn_sonido_off);
        if(toggle){
            imgb2.setImageBitmap(soundOn);
        }else{
            imgb2.setImageBitmap(soundOff);
        }
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                pw = new PopupWindow(
                        inflater.inflate(R.layout.info, null, false),
                        700,
                        700,
                        true);
                pw.showAtLocation(findViewById(R.id.main), Gravity.CENTER, 0, 0);
            }
        });
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggle){
                    bgm.pause();
                    toggle = false;
                    imgb2.setImageBitmap(soundOff);
                }else{
                    bgm.start();
                    toggle = true;
                    imgb2.setImageBitmap(soundOn);
                }
            }
        });
        imgb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("inicio", timer.fin - timer.ini);
                intent.putExtra("posimage", images);
                intent.putExtra("sonido",toggle);
                timer.interrupt();
                bgm.release();
                startActivity(intent);
            }
        });
    }

    protected void  onResume(){
        super.onResume();
        if(toggle){
            bgm.start();
        }
    }

    protected void onPause(){
        super.onPause();
        bgm.release();
    }

    public void Close(View view){
        pw.dismiss();
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("inicio",timer.fin-timer.ini);
        intent.putExtra("posimage",images);
        intent.putExtra("sonido", toggle);
        timer.interrupt();
        startActivity(intent);
    }
}
