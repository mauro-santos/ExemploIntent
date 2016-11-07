package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FazerLigacaoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumero;
    private Button btnFazerLigacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_ligacao);

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        btnFazerLigacao = (Button) findViewById(R.id.btnFazerLigacao);

        btnFazerLigacao.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Uri uri = Uri.parse("tel:" + edtNumero.getText().toString());
            //Intent it = new Intent(Intent.ACTION_CALL, uri);
            Intent it = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(it);
        } catch (Exception ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.erro);
            dlg.setMessage(R.string.numero_invalido);
            dlg.setNeutralButton(R.string.ok, null);
            dlg.show();
        }
    }
}
