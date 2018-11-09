package com.example.bluec.delivery_homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserInput extends AppCompatActivity {

    String a, b, c, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

        Button submit = (Button) findViewById(R.id.submit);
        TextView firstText = (TextView) findViewById(R.id.firstText);
        TextView secondText = (TextView) findViewById(R.id.secondText);
        TextView thirdText = (TextView) findViewById(R.id.thirdtext);
        TextView fourthText = (TextView) findViewById(R.id.fourthtext);

        final EditText firstEdit = (EditText) findViewById(R.id.firstText1);
        final EditText secondEdit = (EditText) findViewById(R.id.secondText1);
        final EditText thirdEdit = (EditText) findViewById(R.id.thridText1);
        final EditText fourthEdit = (EditText) findViewById(R.id.fourthText1);

        Intent i = getIntent();

        String msg = i.getStringExtra("Type");

        if (msg.contentEquals("Add")) {
            //editTextField.setVisibility(View.VISIBLE);
            firstText.setText("Type in the Source");
            secondText.setText("Type in the Destination");
            thirdText.setText("Type in any Instructions");
            fourthText.setVisibility(View.GONE);
            fourthText.setText("Type in the Index");

            fourthEdit.setVisibility(View.GONE);
            a = "source";
            b = "dest";
            c = "instruction";
            d = "";

        }

        else if(msg.contentEquals("Switch")){
            secondText.setVisibility(View.GONE);
            secondEdit.setVisibility(View.GONE);
            thirdText.setVisibility(View.GONE);
            thirdEdit.setVisibility(View.GONE);
            fourthText.setVisibility(View.GONE);
            fourthEdit.setVisibility(View.GONE);
            firstText.setText("Type 1 for list 1 type 2 for list 2 type 3 for list three");

            a = "number";
            b="";
            c="";
            d="";
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = firstEdit.getText().toString();
                String second = secondEdit.getText().toString();
                String third = thirdEdit.getText().toString();
                String fourth = fourthEdit.getText().toString();
                Intent i = getIntent();
                i.putExtra(a, first);
                i.putExtra(b, second);
                i.putExtra(c, third);
                i.putExtra(d, fourth);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
