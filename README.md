Android Data Between Activitys
=======================

## Descripción

<p align="justify">
	La siguiente aplicación busca compartir datos entre vistas.
</p>

## Desarrollo

### Creamos las Vista 1

<p align="center">
	<img src="https://github.com/ginppian/Android-Data_Between_Activitys/blob/master/imgs/img2.png" width="233" height="381">
</p>

<p align="justify">
	Para crear esta vista embebimos dos <i>LinearLayout</i> debido a que el primero es <i>VERTICAL</i> debido a que nuestros elementos <i>Name, Password</i> en realidad se conforman por dos elementos
</p>

<ol>
	<li>ImageView</li>
	<li>EditText</li>
</ol>

<p align="justify">
	Los embebimos en otro <i>LinearLayout</i> pero <i>HORIZONTAL</i>. De esta menera tenemos 4 elementos en vertical y el 2do y 3er elemento estan conformados por dos elementos en horizontal.
</p>

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="mx.paracrecer.paracrecer1.MainActivity">


    <ImageView
        android:id="@+id/imageView"
        android:layout_width="149dp"
        android:layout_height="158dp"
        android:layout_gravity="center"
        android:layout_marginBottom="34sp"
        app:srcCompat="@mipmap/ic_launcher"
        tools:layout_editor_absoluteX="118dp"
        tools:layout_editor_absoluteY="16dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="102dp"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="8sp"
            app:srcCompat="@mipmap/ic_launcher"
            tools:layout_editor_absoluteX="30dp"
            tools:layout_editor_absoluteY="312dp" />

        <EditText
            android:id="@+id/editText"
            android:layout_width="290dp"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:paddingLeft="8sp"
            android:paddingRight="28sp"
            android:text="Name"
            tools:layout_editor_absoluteX="118dp"
            tools:layout_editor_absoluteY="242dp" />

    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="102dp"
        android:orientation="horizontal">
        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="8sp"
            app:srcCompat="@mipmap/ic_launcher"
            tools:layout_editor_absoluteX="30dp"
            tools:layout_editor_absoluteY="242dp" />

        <EditText
            android:id="@+id/editText2"
            android:layout_width="290dp"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:paddingLeft="8sp"
            android:paddingRight="8sp"
            android:text="Password"
            tools:layout_editor_absoluteX="118dp"
            tools:layout_editor_absoluteY="312dp" />
    </LinearLayout>


    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="65dp"
        android:text="Button"
        android:layout_margin="13sp"
        tools:layout_editor_absoluteY="430dp"
        tools:layout_editor_absoluteX="16dp"
        android:layout_weight="0.17" />

</LinearLayout>

```

### Creamos la Vista 2

<p align="center">
	<img src="https://github.com/ginppian/Android-Data_Between_Activitys/blob/master/imgs/img3.png" width="233" height="381">
</p>

<p align="justify">
	Es mejor agregar un <i>ACTIVITY</i> desde click derecho, new activitys porque de esta manera el <i>IDE</i> nos lo registra de manera automática en el archivo <i>ANDROID MANIFEST XML</i>.
</p>

<p align="center">
	<img src="https://raw.githubusercontent.com/ginppian/Android-Data_Between_Activitys/master/imgs/img1.png" width="1015" height="650">
</p>

<p align="justify">
	De otra manera nos mandara un <i>ERROR</i> diciendo algo como: <b>xml the file name must end with xml</b>.
	Para solucionar lo, tendriamos que registrar nuestro <i>ACTIVITY</i> de manera manual en el archivo <i>ANDROID MANIFEST XML</i> escribiendo en un tag <i>activity</i> el nombre de nuestro <i>ACTIVITY</i> entre comillas anteponiendo un punto.
</p>

```
<activity android:name=".MyActivityName">
```

<p align="justify">
	Aquí simplemente agregamos un <i>TextView</i>
</p>

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="mx.paracrecer.paracrecer1.Ubicacion">

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="10dp"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="120dp"
        android:layout_weight="0.04"
        android:gravity="center"
        android:text="Hola Mundo" />

</LinearLayout>

```

### Cargamos los elementos y enviamos los datos

* Primero:

```
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
```

* Segundo:

```
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
```

## Fuente

<a href="http://blog.agencialanave.com/mandar-datos-entre-activities-en-android-tutorial4/">Mandar datos entre activitys Tutorial</a>
<a href="http://www.vogella.com/tutorials/AndroidIntent/article.html">Android Intents - Tutorial</a>