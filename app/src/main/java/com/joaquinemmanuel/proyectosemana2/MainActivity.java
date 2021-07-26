package com.joaquinemmanuel.proyectosemana2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

     DatePickerDialog datePickerDialog;
     Button dateButton;
     String Date;
     Button btSiguiente;
     EditText tvNombre;
     EditText tvTelefono;
     EditText tvDescripcion;
     EditText tvEmail;
     Bundle parametros;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniDatePicker();
        dateButton = findViewById(R.id.btDateButton);
        bottonS();
        if (parametros != null){
            intent();
        }



    }

private String getTodayDate(){
java.util.Calendar cal = java.util.Calendar.getInstance();

    int year = cal.get(java.util.Calendar.YEAR);
    int month = cal.get(java.util.Calendar.MONTH);
    month = month + 1;
    int day = cal.get(java.util.Calendar.DAY_OF_MONTH);

    return MakeDateString(day , month , year);
}


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void iniDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = MakeDateString(day,month,year);
                Date = date;

            }
        };
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;


        datePickerDialog = new DatePickerDialog(this ,style ,  dateSetListener , year , month , day);




    }


    private String MakeDateString(int day, int month, int year) {
        return year + "/" + month + "/" + year ;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "ENE";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "ABR";
        if (month == 5)
            return "Jun";
        if (month == 6)
            return "May";
        if (month == 7)
            return "Jul";
        if (month == 8)
            return "AGU";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DIC";
        return "Ene";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    public String edittextToString(EditText param){

        String dedsec = param.getText().toString();


        return dedsec ;

    }

    public void bottonS(){
        btSiguiente = findViewById(R.id.btSiguiente);
        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);


                tvNombre = findViewById(R.id.etvNombre);
                tvDescripcion = findViewById(R.id.etvDescripcion);
                tvTelefono = findViewById(R.id.etvTelefono);
                tvEmail = findViewById(R.id.etvEmail);

                String Nombre = edittextToString(tvNombre);
                String Descripcion = edittextToString(tvDescripcion);
                String Telefono = edittextToString(tvTelefono);
                String Email = edittextToString(tvEmail);


                intent.putExtra(getResources().getString(R.string.pnombre), Nombre);
                intent.putExtra(getResources().getString(R.string.pdescripcion), Descripcion);
                intent.putExtra(getResources().getString(R.string.ptelefono), Telefono);
                intent.putExtra(getResources().getString(R.string.pemail), Email);
                intent.putExtra(getResources().getString(R.string.pdate), Date);
                startActivity(intent);
                finish();
            }
        });
    }

    public void intent(){
         parametros = getIntent().getExtras();

        String nombre2 = parametros.getString("Nombre2");
        String email2 = parametros.getString("Email2");
        String descripcion2 = parametros.getString("Descripcion2");
        String telefono2 = parametros.getString("Telefono2");

        tvNombre.setHint(nombre2);
        tvTelefono.setHint(telefono2);
        tvDescripcion.setHint(descripcion2);
        tvEmail.setHint(email2);
    }

}