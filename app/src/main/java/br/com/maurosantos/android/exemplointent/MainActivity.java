package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int EXEMPLO_PARAMETROS_ACTIVITY = 0;

    private Button btnChamarBrowser;
    private Button btnFazerLigacao;
    private Button btnExemploParametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChamarBrowser = (Button) findViewById(R.id.btnChamarBrowser);
        btnFazerLigacao = (Button) findViewById(R.id.btnFazerLigacao);
        btnExemploParametros = (Button) findViewById(R.id.btnExemploParametros);

        btnChamarBrowser.setOnClickListener(this);
        btnFazerLigacao.setOnClickListener(this);
        btnExemploParametros.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnChamarBrowser) {
            Intent it = new Intent(this, ChamarBrowserActivity.class);
            startActivity(it);
        } else if (view == btnFazerLigacao) {
            Intent it = new Intent(this, FazerLigacaoActivity.class);
            startActivity(it);
        } else if (view == btnExemploParametros) {
            Intent it = new Intent(this, ExemploParametrosActivity.class);
            startActivityForResult(it, EXEMPLO_PARAMETROS_ACTIVITY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EXEMPLO_PARAMETROS_ACTIVITY) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            switch (resultCode) {
                case RESULT_OK:
                    if (data != null) {
                        Bundle parametros = data.getExtras();

                        if (parametros.containsKey("VALOR")) {
                            String valor = parametros.getString("VALOR");
                            dlg.setMessage("O valor do parâmetro é: " + valor);
                        } else {
                            dlg.setMessage("Operação confirmada sem parâmetros de retorno!");
                        }
                    } else {
                        dlg.setMessage("Operação confirmada sem Intent de retorno!");
                    }

                    break;
                case RESULT_CANCELED:
                    dlg.setMessage("Operação cancelada!");

                    break;
            }

            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
}
