package com.example.edward.carteraclientes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.edward.carteraclientes.BaseDatos.DatosOpenHelper;
import com.example.edward.carteraclientes.BaseDatos.FeedReaderContract.FeedEntry;

public class ActNuevoCliente extends AppCompatActivity {
    private EditText edtNombre;
    private EditText edtDireccion;
    private EditText edtEmail;
    private EditText edtTelefono;

    private SQLiteDatabase conexion;
    private DatosOpenHelper datosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_cliente);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_nuevo_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_ok:
                if(bCamposCorrectos()) {
                    try {
                        datosOpenHelper = new DatosOpenHelper(this);
                        conexion = datosOpenHelper.getWritableDatabase();

                        ContentValues values = new ContentValues();
                        values.put(FeedEntry.COLUMN_NAME_NOMBRE, edtNombre.getText().toString().trim() );
                        values.put(FeedEntry.COLUMN_NAME_DIRECCION, edtDireccion.getText().toString().trim() );
                        values.put(FeedEntry.COLUMN_NAME_EMAIL, edtEmail.getText().toString().trim() );
                        values.put(FeedEntry.COLUMN_NAME_TELEFONO, edtTelefono.getText().toString().trim() );
                        finish();

                        conexion.insert(FeedEntry.TABLE_NAME, null, values);
                        conexion.close();

                        finish();
                    } catch (Exception ex) {
                        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                        dlg.setTitle("Aviso");
                        dlg.setMessage(ex.getMessage());
                        dlg.setNeutralButton("OK", null);
                        dlg.show();
                    }
                }
                else {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                    dlg.setTitle("Aviso");
                    dlg.setMessage("Existen campos vacios");
                    dlg.setNeutralButton("OK",null);
                    dlg.show();
                }

                // Toast.makeText(this, "Boton Ok seleccionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cancelar:
                //Toast.makeText(this, "Boton Cancelar seleccionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean bCamposCorrectos() {
        boolean res = true;
        if(edtNombre.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if(edtDireccion.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if(edtEmail.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        if(edtTelefono.getText().toString().trim().isEmpty()) {
            edtNombre.requestFocus();
            res = false;
        }
        return res;
    }
}
