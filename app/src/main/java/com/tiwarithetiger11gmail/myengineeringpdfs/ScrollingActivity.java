package com.tiwarithetiger11gmail.myengineeringpdfs;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {
RadioGroup rg;
    EditText e1;
    RadioButton rb;
      int sem;
    String branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This App has Been Developed By Murari Tiwari a 2nd Year  CSE Student of CIT Ranchi ",10000)
                        .setAction("Action", null).show();
            }
        });
    }



    public void submit(View view) {
        rg=(RadioGroup)findViewById(R.id.branch);
        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

       e1=(EditText)findViewById(R.id.sem);
        if(rb==null  || e1.getText().toString().equals("")|| e1.getText().toString().equals("0")|| e1.getText().toString().equals("9")) {
            Toast.makeText(this, "YOU NEED TO ENTER BRANCH  AND VALID SEMESTER", Toast.LENGTH_LONG).show();
        }else{

            ConnectivityManager cm=(ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
            NetworkInfo ni= cm.getActiveNetworkInfo();
            if(ni!=null&&ni.isConnected()){
                Intent i=new Intent(ScrollingActivity.this,MainActivity.class);
                Bundle b=new Bundle();
                b.putString("branch",rb.getText().toString());
                b.putInt("sem",Integer.parseInt(e1.getText().toString()));
                i.putExtras(b);
                startActivity(i);
            }else {
                AlertDialog.Builder ab=new AlertDialog.Builder(this);
                ab.setTitle("Internet");
                ab.setMessage("You are not Connected to Internet. Please ensure  your connection and retry");
                ab.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                });
                ab.show();
            }

        }

    }

}
