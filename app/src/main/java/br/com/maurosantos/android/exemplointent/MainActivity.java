package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChamarBrowser;
    private Button btnFazerLigacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChamarBrowser = (Button) findViewById(R.id.btnChamarBrowser);
        btnFazerLigacao = (Button) findViewById(R.id.btnFazerLigacao);

        btnChamarBrowser.setOnClickListener(this);
        btnFazerLigacao.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnChamarBrowser) {
            Intent it = new Intent(this, ChamarBrowserActivity.class);
            startActivity(it);
        }
        else if(view == btnFazerLigacao)
        {
            Intent it = new Intent(this, FazerLigacaoActivity.class);
            startActivity(it);
        }
    }
}
