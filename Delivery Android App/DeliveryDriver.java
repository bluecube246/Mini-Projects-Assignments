package com.example.bluec.delivery_homework2;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class DeliveryDriver extends AppCompatActivity {

    private static Scanner in;
    public static DeliveryList current;
    DeliveryList first, second, third;
    Delivery copy, removeTemp;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_driver);

        first = new DeliveryList();
        second = new DeliveryList();
        third = new DeliveryList();
        current = first;
        copy = null;
        String option;

        header = (TextView) findViewById(R.id.textView);
        header.setText("Current List: List 1");

//        current.insertAfterCursor(new Delivery("a", "b", "c"));
//        current.insertAfterCursor(new Delivery("d", "e", "f"));
//        current.insertAfterCursor(new Delivery("g", "h", "i"));

        in = new Scanner(System.in);

        Button Add = (Button) findViewById(R.id.AddDelivery);
        Button Remove = (Button) findViewById(R.id.RemoveDelivery);

        Button Copy = (Button) findViewById(R.id.Cut);
        Button Paste = (Button) findViewById(R.id.Paste);

        Button Head = (Button) findViewById(R.id.Head);
        Button Tail = (Button) findViewById(R.id.Tail);

        Button Forward = (Button) findViewById(R.id.Forward);
        Button Back = (Button) findViewById(R.id.back);

        Button Switch = (Button) findViewById(R.id.Switch);
        Button Print = (Button) findViewById(R.id.Print);

        Button Quit = (Button) findViewById(R.id.Quit);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Delivery", "Add Delivery has been pressed");
                Intent myIntent = new Intent(DeliveryDriver.this, UserInput.class);
                myIntent.putExtra("Type", "Add");
                startActivityForResult(myIntent, 1);
            }
        });

        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    removeTemp = current.removeCursor();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(DeliveryDriver.this);
                alert.setTitle("Remove success");
                alert.setMessage("To: " + removeTemp.getDest() + " | From:" + removeTemp.getSource() + "\n" + "Instruction: " + removeTemp.getinstruction() + "\n");
                alert.setCancelable(true);
                alert.show();

            }
        });

        Copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    copy = current.removeCursor();
                    Toast.makeText(getApplicationContext(), "Cut successful", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        Paste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (copy == null)
                    Toast.makeText(getApplicationContext(), "Nothing to copy", Toast.LENGTH_SHORT).show();
                else {
                    current.insertAfterCursor(copy);
                    Toast.makeText(getApplicationContext(), "Paste Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.resetCursorToHead();
                Toast.makeText(getApplicationContext(), "Cursor To head", Toast.LENGTH_SHORT).show();
            }
        });

        Tail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.resetCursorToTail();
                Toast.makeText(getApplicationContext(), "Cursor To tail", Toast.LENGTH_SHORT).show();
            }
        });

        Forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    current.cursorForward();
                    Toast.makeText(getApplicationContext(), "Cursor Forward Pressed", Toast.LENGTH_SHORT).show();
                } catch (EndOfListException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    current.cursorBackward();
                    Toast.makeText(getApplicationContext(), "Cursor Backward Pressed", Toast.LENGTH_SHORT).show();
                } catch (EndOfListException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        Switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Delivery", "Switch Delivery has been pressed");
                Intent myIntent = new Intent(DeliveryDriver.this, UserInput.class);
                myIntent.putExtra("Type", "Switch");
                startActivityForResult(myIntent, 1);
            }
        });

        Print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Delivery", "Switch Delivery has been pressed");
                Intent myIntent = new Intent(DeliveryDriver.this, ViewPrint.class);
                myIntent.putExtra("Type", "Print");
                //startActivityForResult(myIntent, 1);
                startActivity(myIntent);
            }
        });

        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                moveTaskToBack(true);
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(1);
//                System.exit(0);
//                  ActivityCompat.finishAffinity(this);
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data.getExtras().containsKey("source")) {
            String getSource = data.getStringExtra("source");
            String getDest = data.getStringExtra("dest");
            String getInstruction = data.getStringExtra("instruction");
            current.insertAfterCursor(new Delivery(getSource, getDest, getInstruction));

            Toast.makeText(getApplicationContext(), "Add success", Toast.LENGTH_SHORT).show();
        } else if (data.getExtras().containsKey("number")) {
            String getNumber = data.getStringExtra("number");
            if (getNumber.equals("1")) {
                current = first;
                header.setText("Current List: List 1");
                Toast.makeText(getApplicationContext(), "Moving to list 1", Toast.LENGTH_SHORT).show();
            } else if (getNumber.equals("2")) {
                Toast.makeText(getApplicationContext(), "Moving to list 2", Toast.LENGTH_SHORT).show();
                header.setText("Current List: List 2");
                current = second;
            } else if (getNumber.equals("3")) {
                current = third;
                header.setText("Current List: List 3");
                Toast.makeText(getApplicationContext(), "Moving to list 3", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getApplicationContext(), "Input error please type 1 or 2 or 3", Toast.LENGTH_SHORT).show();


        }
    }


}
