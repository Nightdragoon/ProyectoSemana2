package com.joaquinemmanuel.proyectosemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView Fecha;
    TextView Name;
    TextView Tel;
    TextView Email;
    TextView Descripcion;
    Button EditarDatos;
    String nombre;
    String telefono;
    String email;
    String descripcion;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = getIntent().getExtras();

         nombre = parametros.getString("Nombre");
         telefono = parametros.getString("Telefono");
         email = parametros.getString("Email");
         descripcion = parametros.getString("Descripcion");
         date = parametros.getString("Date");

        Fecha = findViewById(R.id.tvFecha2);
        Name = findViewById(R.id.tvNombre);
        Tel = findViewById(R.id.tvTel2);
        Email = findViewById(R.id.tvEmail2);
        Descripcion = findViewById(R.id.tvDescripcion);

        Fecha.setText(date);
        Name.setText(nombre);
        Tel.setText(telefono);
        Email.setText(email);
        Descripcion.setText(descripcion);


        buttonClick();




    }

    public void buttonClick(){
        EditarDatos = findViewById(R.id.btEditarDatos);
        EditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity2.this , MainActivity.class);
                intent2.putExtra(getResources().getString(R.string.pname2) , nombre);
                intent2.putExtra(getResources().getString(R.string.pdescripcion2) , descripcion);
                intent2.putExtra(getResources().getString(R.string.pemail2) , email);
                intent2.putExtra(getResources().getString(R.string.ptelefono2) , telefono);
                startActivity(intent2);
                finish();
            }
        });
    }
}