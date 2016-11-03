package br.com.maurosantos.android.exemplointent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChamarBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChamarBrowser = (Button) findViewById(R.id.btnChamarBrowser);
        btnChamarBrowser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnChamarBrowser) {
            Intent it = new Intent(this, ChamarBrowserActivity.class);
            startActivity(it);
        }
    }
}
