package com.example.androidteaching;

        import android.content.Intent;
        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    boolean flag = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (flag){
                imageView.setImageResource(R.drawable.text_2);
                flag = false;
            }else {
                imageView.setImageResource(R.drawable.text_1);
                flag = true;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_1);
        textView.setText("Yes android");
        textView.setTextSize(40);

        imageView = findViewById(R.id.image01);
        imageView.setImageResource(R.drawable.text_1);

        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message message = new Message();
                    message.what = 0x0;
                    handler.sendMessage(message);
                }
            }
        }.start();

    }
}
