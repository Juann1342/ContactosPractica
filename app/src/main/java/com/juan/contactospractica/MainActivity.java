package com.juan.contactospractica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private EditText edtxtFecha;
    private EditText edtxtNombre;
    private EditText edtxtTelefono;
    private EditText edtxtEmail;
    private EditText edtxtDescripcion;
    private String nombre;
    private String telefono;
    private String fecha;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtFecha = (EditText) findViewById(R.id.txtFecha);
        edtxtNombre = (EditText) findViewById(R.id.txtNombre);
        edtxtTelefono = (EditText) findViewById(R.id.txtTelefono);
        edtxtEmail = (EditText) findViewById(R.id.txtEmail);
        edtxtDescripcion = (EditText) findViewById(R.id.txtDesc);

        if (getIntent().getExtras()!=null){
            Bundle parametros = getIntent().getExtras();
            nombre           = parametros.getString("nombre");
            telefono         = parametros.getString("telefono");
            fecha            = parametros.getString("fecha");
            email            = parametros.getString("email");
            descripcion      = parametros.getString("descripcion");
            edtxtNombre.setText(nombre);
            edtxtTelefono.setText(telefono);
            edtxtDescripcion.setText(descripcion);
            edtxtFecha.setText(fecha);
            edtxtEmail.setText(email);
        }

    }

    public void mostrarDatePicker(View v){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this,
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.YEAR)
                );
        datePickerDialog.show();
    }

    public void siguienteLayout(View v){
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

        intent.putExtra("nombre", edtxtNombre.getText().toString());
        intent.putExtra("telefono", edtxtTelefono.getText().toString());
        intent.putExtra("email", edtxtEmail.getText().toString());
        intent.putExtra("descripcion", edtxtDescripcion.getText().toString());
        intent.putExtra("fecha", edtxtFecha.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        int mes = i1+1;
        String date = i2 + "/"+mes+"/"+i;
        edtxtFecha.setText(date);
    }

}