package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChamarBrowserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtURL;
    private Button btnAbrirBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamar_browser);

        edtURL = (EditText) findViewById(R.id.edtURL);
        btnAbrirBrowser = (Button) findViewById(R.id.btnAbrirBrowser);

        btnAbrirBrowser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Uri uri = Uri.parse(edtURL.getText().toString());
            Intent it = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(it);
        } catch (Exception ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle(R.string.erro);
            dlg.setMessage(R.string.url_invalida);
            dlg.setNeutralButton(R.string.ok, null);
            dlg.show();
        }
    }
}
