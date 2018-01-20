package com.cs.niu.z1803824.findme;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GameActivity extends AppCompatActivity
{
    String ans1 = "waterfall";
    String ans2 = "reflection";
    String ans3 = "queue";
    String ans4 = "towel";
    String ans5 = "secret";
    String ans6 = "fire";
    String ans7 = "coffin";
    String ans8 = "watermelon";
    String ans9 = "priest";
    String buttonValue, buttonName;
    TextView tv;
    TextView jumble;
    EditText answer;
    Button btn;
    private CountDownTimer countDownTimer;
    public boolean timerStopped;
    private GameActivity context;
    private static Map<Integer,Puzzle> puzzleMap=new HashMap<Integer,Puzzle>();
    private static Integer qnGenerated;
    static
    {
        puzzleMap.put(1,new Puzzle(1,"This old one runs forever, but never moves at all.He has no lungs nor throat, but still a mighty roaring call.What is it?????"

                ,"waterfall"));
        puzzleMap.put(2,new Puzzle(2,"You can see nothing else, when you look in my face, I will look you in the eye, and I will never lie.","reflection"));
        puzzleMap.put(3,new Puzzle(3,"What English word retains the same pronunciation, even after you take away four of its five letters?","queue"));
        puzzleMap.put(4,new Puzzle(4,"What gets wetter and wetter the more it dries?","towel"));
        puzzleMap.put(5,new Puzzle(5,"When you have me, you feel like sharing me.But if you do share me, you do not have me. What am I?"
                ,"secret"));
        puzzleMap.put(6,new Puzzle(6,"I am not alive, but I grow,I do not have lungs, but I need air,I do not have a mouth, but water kills me.What am I?"
                 ,"fire"));
        puzzleMap.put(7,new Puzzle(7,"Who makes it, has no need of it.Who buys it, has no use for it.Who uses it can neither see nor feel it.What is it?What is it?"

                ,"coffin"));
        puzzleMap.put(8,new Puzzle(8,"There was a green house. Inside the green house there was a white house.Inside the white house there was a red house. Inside the red house there were lots of babies.What is it?"
                ,"watermelon"));
        puzzleMap.put(9,new Puzzle(9,"He has married many women, but has never been married. Who is he?","priest"));
       // puzzleMap.put(10,new Puzzle(1,"",""));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = new Intent();
        Bundle bundle = getIntent().getExtras();
        buttonValue = bundle.getString("button");
        buttonName = bundle.getString("buttonid");
        context = this;
        //System.out.println("buttonvalue-->"+buttonValue);
        tv = (TextView)findViewById(R.id.textView);
        jumble = (TextView)findViewById(R.id.jumble);
        answer = (EditText)findViewById(R.id.answer);
        btn = (Button)findViewById(R.id.btn);
        //final MainActivity ma = new MainActivity();
        Set<Integer> qn=
                puzzleMap.keySet();
        List<Integer> keyList=new ArrayList(qn); //[1,2,3]
        Collections.shuffle(keyList); //[3,1,2]
        qnGenerated=keyList.get(0); //3
        Puzzle puzzle = puzzleMap.get(qnGenerated); //3rd question
        tv.setText(puzzle.getQuestion());
        findMe(puzzle.getAnswer());
        startTimer();

        //String recv = answer.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String recv = answer.getText().toString();
                String ans=puzzleMap.get(qnGenerated).getAnswer();
                if ( recv.equals(ans))
                {

                    Intent output = new Intent();
                    output.putExtra("button", buttonValue);
                    setResult(RESULT_OK, output);
                    stopTimer();
                    puzzleMap.remove(qnGenerated);
                    finish();
                }
                else
                {
                    stopTimer();
                    Intent intent =new Intent(v.getContext(),MainActivity.class);
                    setResult(RESULT_CANCELED, intent);
                    finish();
                }
            }

        });

    }
    private String findMe(String ans)
    {

        char a[] = ans.toCharArray();
        Random random = new Random();
        for(int i = 0; i< a.length; i++)
        {
            int j = random.nextInt(a.length);
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        String s = new String(a);
        jumble.setText(s);
        return s;
    }
    //start the timer
    public void startTimer()
    {
        setTimerStartListener();
        timerStopped = false;
    }
    //stop timer
    public void stopTimer()
    {
        countDownTimer.cancel();
        timerStopped = true;
    }
    //countdown timer
    private void setTimerStartListener()
    {
        countDownTimer = new CountDownTimer(25000,25000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish()
            {
                Toast.makeText(context, "Time Up", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}
