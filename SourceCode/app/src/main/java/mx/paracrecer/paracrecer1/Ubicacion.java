package mx.paracrecer.paracrecer1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ubicacion extends AppCompatActivity {

    private TextView tv;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        loadView();
    }

    private void loadView(){

        tv = (TextView) findViewById(R.id.textView);
        bundle = getIntent().getExtras();
        tv.setText(bundle.getString("prueba").toString());
    }
}
