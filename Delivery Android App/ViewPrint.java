package com.example.bluec.delivery_homework2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewPrint extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Button submit = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.showtext);

        DeliveryListNode nodeptr = DeliveryDriver.current.getHead();

        Intent i = getIntent();

        String msg = i.getStringExtra("Type");

        text.setText("");

        if (msg.contentEquals("Print")) {
            while (nodeptr != null) {
                text.append("To: " + nodeptr.getData().getDest());
                text.append(" | From:" + nodeptr.getData().getSource() + "\n");
                text.append("Instruction: " + nodeptr.getData().getinstruction() + "\n");
                if (nodeptr.getData() == DeliveryDriver.current.getCursor())
                    text.append("->\n");
                else
                    text.append("~\n");
                nodeptr = nodeptr.getNext();
            }
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
