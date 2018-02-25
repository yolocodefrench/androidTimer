package com.pierre.timerfonctionnelsamedi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int decompte=0;
    TextView textView = null;
    final String Tag="messageAppTimer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = (TextView) findViewById(R.id.textDecompte);

         textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view == textView){
            Intent intent = new Intent(this, SaisieActivity.class);
            startActivityForResult(intent, 200);
            Log.i(this.Tag, "Le clic sur le text est détecté");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==200 && resultCode== Activity.RESULT_OK){
            this.decompte = data.getIntExtra("ExtraDecompte", 0);
            Log.i(this.Tag, this.decompte+" ");

            new CountDownTimer(this.decompte*1000, 1000){
                @Override
                public void onTick(long l) {
                    MainActivity.this.textView.setText(l/1000+" ");
                }

                @Override
                public void onFinish() {
                    MainActivity.this.textView.setText(R.string.creer_decompte);
                    // 1. Instantiate an AlertDialog.Builder with its constructor
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setTitle(R.string.decompte_fini);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    // 3. Get the AlertDialog from create()
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }.start();
        }


    }
}

