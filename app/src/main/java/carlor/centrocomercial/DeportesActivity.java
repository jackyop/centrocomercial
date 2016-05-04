package carlor.centrocomercial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DeportesActivity extends AppCompatActivity {
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportes);
        Bundle extras = getIntent().getExtras();
        long inicio = extras.getLong("inicio");
        timer = new Timer(inicio);
        timer.start();
    }
}
