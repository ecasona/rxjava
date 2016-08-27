package com.ecasona.rxjavaapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ecasona.rxjavaapplication.R;
import com.ecasona.rxjavaapplication.entity.Result;
import com.ecasona.rxjavaapplication.entity.User;
import com.ecasona.rxjavaapplication.net.NetRequset;
import com.ecasona.rxjavaapplication.net.Request;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVeiw();
    }

    private void initVeiw() {
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                NetRequset.getNetRequset().getUser(new Subscriber<Result<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onNext(Result<User> result) {
                        textView.setText(result.getRow().getName());
                    }
                }, "ecasona");
                break;

            default:
                break;
        }
    }
}
