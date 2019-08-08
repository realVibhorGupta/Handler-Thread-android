package com.example.vibhor.handlerdemo2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyThread myThread;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button= (Button) findViewById(R.id.sendMessage);
        myThread =new MyThread();
        myThread.start();
    }
    public void OnSendMessage(View view)
    {
       myThread.handler.post(new Runnable() {
           @Override
           public void run() {
            L.m(Thread.currentThread().getName().toString());
           }
       });
    }

    class MyThread extends Thread{

        Handler handler ;

        public MyThread()
        {
            
        }

        /**
         * Starts executing the active part of the class' code. This method is
         * called when a thread is started that has been created with a class which
         * implements {@code Runnable}.
         */
        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler();
            Looper.loop();
        }
    }
}

