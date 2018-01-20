package com.cs.niu.z1803824.findme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button done;
    EditText et;
    String btn1;
    String correct = "Angelina";
    int count = 0;
    private MainActivity context;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String returnString = data.getStringExtra("button");
                Button button=(Button)findViewById(Integer.parseInt(returnString));
                button.setVisibility(View.INVISIBLE);
                System.out.println(returnString);
            }
            else if(resultCode == RESULT_CANCELED)
            {
                // do nothing..
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button9);
        button2 = (Button)findViewById(R.id.button8);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button7);
        button5 = (Button)findViewById(R.id.button6);
        button6 = (Button)findViewById(R.id.button2);
        button7 = (Button)findViewById(R.id.button5);
        button8 = (Button)findViewById(R.id.button4);
        button9 = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);
        context = this;
        done = (Button)findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                  count++;
                  String recieved = et.getText().toString();
                  if(recieved.equalsIgnoreCase(correct))
                  {
                      Intent intent = new Intent(v.getContext(),WinActivity.class);
                      startActivity(intent);
                      finish();

                  }
                  else if(count <3)
                  {
                      Toast.makeText(context,"Nice Guess!! Try Again",Toast.LENGTH_LONG).show();
                  }
                  else if(count >=3)
                  {
                    Intent intent = new Intent(v.getContext(),GameOver.class);
                      startActivity(intent);
                      finish();
                  }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startNewActivity(v,button1.getId(),"button1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button2.getId(),"button2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button3.getId(),"button3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button4.getId(),"button4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button5.getId(),"button5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button6.getId(),"button6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button7.getId(),"button7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button8.getId(),"button8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(v,button9.getId(),"button9");
            }
        });

    }
    public void startNewActivity(View v,int id,String buttonName)
    {
        Intent intent = new Intent(v.getContext(),GameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("button", String.valueOf(id));
        bundle.putString("buttonid",buttonName);
        intent.putExtras(bundle);
        startActivityForResult(intent,0);
    }
}
