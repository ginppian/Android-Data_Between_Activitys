package mx.paracrecer.paracrecer1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private ImageView imgPerfil;
    private ImageView imgPass;
    private EditText inputPerfil;
    private EditText inputPass;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();

        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                ejecutar();
            }
        });
    }

    private void loadView(){

        imgLogo = (ImageView) findViewById(R.id.imageView);
        imgPerfil = (ImageView) findViewById(R.id.imageView2);
        imgPass = (ImageView) findViewById(R.id.imageView3);
        inputPerfil = (EditText) findViewById(R.id.editText);
        inputPass = (EditText) findViewById(R.id.editText2);
        boton = (Button) findViewById(R.id.button);
    }

    private void ejecutar(){

        Intent intent = new Intent(MainActivity.this, Ubicacion.class);
        intent.putExtra("prueba", inputPerfil.getText().toString());
        startActivity(intent);
    }

}
