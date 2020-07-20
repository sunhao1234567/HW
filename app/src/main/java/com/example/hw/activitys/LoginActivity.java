package com.example.hw.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hw.R;
import com.example.hw.base.SaveInfo;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText account = null;
    EditText code = null;
    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = (EditText) findViewById(R.id.textView4);//获取用户名
        code = (EditText) findViewById(R.id.textView3);//获取密码
        Button bt3 =(Button) findViewById(R.id.button3);
        Button bt4 =(Button) findViewById(R.id.button4);
        Map<String, String> userInfo = SaveInfo.getSaveInformation(this);
        if (userInfo != null) {
            et_username.setText(userInfo.get("username"));//获取注册信息
            et_password.setText(userInfo.get("pwd"));
        }
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//登陆点击事件，判断用户名密码
                String username = ((EditText)findViewById(R.id.textView4)).getText().toString();//获取用户名
                String pwd = ((EditText)findViewById(R.id.textView3)).getText().toString();//获取密码
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this,"密码或账号不能为空",Toast.LENGTH_SHORT).show();
                }

                else {
                    if (username.equals( username) && pwd.equals(pwd)) {
                        Intent intent = new Intent(LoginActivity.this, LoginInActivity.class);
                        startActivity(intent);//转到登录成功页面
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"密码或账号错误！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}