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

public class RegistActivity extends AppCompatActivity {

    private EditText reg_username;//声明私有视图名
    private EditText reg_pwd;
    private EditText reg_pwd2;
    private Button reg_btn_sure;
    private Button reg_btn_login;
    private EditText reg_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        reg_username = (EditText)findViewById(R.id.reg_username);//通过Id找到注册用户名视图
        reg_pwd=(EditText)findViewById(R.id.reg_password);//通过Id找到注册密码视图
        reg_pwd2=(EditText)findViewById(R.id.reg_password2);//通过Id找到确认注册密码视图
        reg_mail=(EditText)findViewById(R.id.reg_mail);//通过Id找到注册邮箱视图
        reg_btn_sure=(Button)findViewById(R.id.reg_btn_sure);//通过Id找到注册按钮视图
        reg_btn_login=(Button)findViewById(R.id.reg_btn_login);//通过Id找到返回登录视图
        reg_btn_sure.setOnClickListener(new RegistButton());//创建注册按钮点击事件监听
        reg_btn_login.setOnClickListener(new RegistButton());//创建返回登录按钮点击事件监听


    }

    private class RegistButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
          String username = reg_username.getText().toString().trim();//获取注册用户名
          String  pwd =reg_pwd.getText().toString().trim();//获取注册密码
          String pwd2 =reg_pwd2.getText().toString().trim();//获取确认密码
          String mail =reg_mail.getText().toString().trim();//获取注册邮箱
            switch (view.getId()) {
                //注册开始，判断注册条件
                case R.id.reg_btn_sure:
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwd2) || TextUtils.isEmpty(mail)) {
                        Toast.makeText(RegistActivity.this, "各项均不能为空", Toast.LENGTH_SHORT).show();
                    } else {
                        if (TextUtils.equals(pwd, pwd2)) {
                            //执行注册操作，判断两次输入密码是否相同
                            SaveInfo.SaveInformation(RegistActivity.this,username,pwd,pwd2,mail);
                            Toast.makeText(RegistActivity.this,"注册成功,请返回登录",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegistActivity.this, "两次输入的密码不一样", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case R.id.reg_btn_login://返回登录界面
                    Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
            }

        }
    }
}