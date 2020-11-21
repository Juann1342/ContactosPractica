package com.juan.contactospractica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvFecha;
    private TextView tvDescripcion;
    private String nombre;
    private String telefono;
    private String fecha;
    private String email;
    private String descripcion;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Bundle parametros = getIntent().getExtras();
        nombre           = parametros.getString("nombre");
        telefono         = parametros.getString("telefono");
        fecha            = parametros.getString("fecha");
        email            = parametros.getString("email");
        descripcion      = parametros.getString("descripcion");
        tvNombre       = (TextView) findViewById(R.id.tvNombre);
        tvTelefono     = (TextView) findViewById(R.id.tvTel);
        tvEmail        = (TextView) findViewById(R.id.tvEmail);
        tvFecha        = (TextView) findViewById(R.id.tvFechaNac);
        tvDescripcion  = (TextView) findViewById(R.id.tvDescripcion);
        tvNombre.setText(nombre);
        tvTelefono.setText("Telefono: "+telefono);
        tvFecha.setText("Fecha Nacimiento: "+fecha);
        tvEmail.setText("Email: "+email);
        tvDescripcion.setText("Descripción: "+descripcion);

    }

    public  void atras(View v){
        Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("fecha", fecha);
        startActivity(intent);
        finish();
    }
}