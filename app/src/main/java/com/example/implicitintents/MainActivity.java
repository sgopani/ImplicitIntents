package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button close_app,launch_btn,ring_btn;
    EditText url_txt,phone_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        close_app=findViewById(R.id.close_app);
        launch_btn=findViewById(R.id.launch_btn);
        ring_btn=findViewById(R.id.ring_btn);
        url_txt=findViewById(R.id.url_txt);
        phone_txt=findViewById(R.id.phone_txt);
        launch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!url_txt.getText().toString().isEmpty()){
                    try {
                        if(URLUtil.isValidUrl(url_txt.getText().toString())){
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(url_txt.getText().toString()));
                            startActivity(intent);
                        }
                        else{
                            url_txt.setText("");
                            url_txt.setHint(R.string.hint);
                        }

                }catch (Exception e){
                        url_txt.setText("");
                        url_txt.setHint(R.string.hint);
                    }
                }

            }
        });
        close_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ring_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!phone_txt.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone_txt.getText().toString(), null));
                    startActivity(intent);
                }
            }
        });
    }
}