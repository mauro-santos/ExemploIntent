package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExemploParametrosActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtValor;
    private Button btnConfirmar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_parametros);

        edtValor = (EditText) findViewById(R.id.edtValor);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnConfirmar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnConfirmar) {
            Intent it = new Intent();
            it.putExtra("VALOR", edtValor.getText().toString());
            setResult(RESULT_OK, it);
            finish();
        } else if (view == btnCancelar) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
