package com.pierre.timerfonctionnelsamedi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaisieActivity extends AppCompatActivity implements View.OnClickListener{
    final String Tag="messageAppTimer";
    Button button = null;
    EditText editText = null;

    int nbrSec= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        button = (Button) findViewById(R.id.lancer_dec);
        editText = (EditText) findViewById(R.id.saisie_text);

        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Log.i(this.Tag, "clic sur le bouton");
        try {
            this.nbrSec = Integer.parseInt(editText.getText().toString());

            Intent intent = new Intent();
            intent.putExtra("ExtraDecompte", this.nbrSec);
            setResult(Activity.RESULT_OK, intent);
            finish();

        }
        catch (Exception e){
            Toast.makeText(SaisieActivity.this, "Le texte rentré ne correspond pas à un nombre",  Toast.LENGTH_LONG).show();

        }
    }


}
