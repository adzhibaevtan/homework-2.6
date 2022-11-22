package com.registration.homework_26;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private TextView tv_input, tv_registry;
    private EditText et_email, et_password;
    private Button btn_enter;
    private ConstraintLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_input = findViewById(R.id.input);
        tv_registry = findViewById(R.id.reg);
        et_email = findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        btn_enter = findViewById(R.id.enter);
        container = findViewById(R.id.container);


        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( et_password.getText().toString().length() >= 1 || et_email.getText().toString().length() >= 1) {
                    btn_enter.setBackgroundColor(btn_enter.getContext().getResources().getColor(R.color.orange));
                } else {
                    btn_enter.setBackgroundColor(btn_enter.getContext().getResources().getColor(R.color.grey));
                }
            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( et_password.getText().toString().length() >= 1 || et_email.getText().toString().length() >= 1) {
                    btn_enter.setBackgroundColor(btn_enter.getContext().getResources().getColor(R.color.orange));
                } else {
                    btn_enter.setBackgroundColor(btn_enter.getContext().getResources().getColor(R.color.grey));
                }
            }
        });
        btn_enter.setOnClickListener(e -> {
            if(et_email.getText().toString().equals("admin") && et_password.getText().toString().equals("admin")){
                container.setVisibility(View.GONE);
                tv_input.setVisibility(View.GONE);
                Toast.makeText(this, "Вы правильно ввели пароль", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Не правильный пароль, введите еще раз", Toast.LENGTH_SHORT).show();
                et_password.getText().clear();
                et_email.getText().clear();
            }
        });
    }
}