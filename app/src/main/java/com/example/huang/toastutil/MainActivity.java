package com.example.huang.toastutil;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editInput;
    private Button btnFire;
    private Context mContext;
    private RadioGroup rg;
    private boolean isCheckDuration = false;
    private int duration = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        editInput = (EditText) findViewById(R.id.edit_input);
        btnFire = (Button) findViewById(R.id.btn_fire);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                isCheckDuration = true;
                switch (checkedId) {
                    case R.id.rb_short: {
                        duration = Toast.LENGTH_SHORT;
                        break;
                    }
                    case R.id.rb_long: {
                        duration = Toast.LENGTH_LONG;
                        break;
                    }
                    case R.id.rb_other: {
                        duration = -1;
                        break;
                    }
                    case R.id.rb_no: {
                        duration = 404;
                        break;
                    }
                }
            }
        });
        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCheckDuration) {
                    ToastUtil.show(mContext, "please check Duration");
                    return;
                }
                if (duration==404){
                    ToastUtil.show(mContext, editInput.getText().toString().trim());
                }else{
                    ToastUtil.show(mContext, editInput.getText().toString().trim(),duration);
                }

            }
        });
    }
}
