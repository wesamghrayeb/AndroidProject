package com.example.arabic.restaurants;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogIn extends AppCompatActivity{

    @SuppressLint("Registered")
    public static class LoginSetting extends AppCompatActivity {
        Button button, button2;
        EditText editText, editText2;
        USERsDATaBASE useRsDATaBASE;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate  (savedInstanceState);
            setContentView(R.layout.activity_main);

            button = findViewById(R.id.button);
            button2 = findViewById(R.id.button2);
            editText = findViewById(R.id.editText);
            editText2 = findViewById(R.id.editText2);
            useRsDATaBASE = new USERsDATaBASE(LoginSetting.this) {
                @Override
                public void onCreate(SQLiteDatabase db) {
                    super.onCreate(db);
                }
            };
            //useRsDATaBASE.AddUser("admin","admin");
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {// signUp
                    String strName= editText.getText().toString();
                    String strPass = editText2.getText().toString();
                    if(strName.isEmpty() || strPass.isEmpty())
                    {
                        Toast.makeText(LoginSetting.this, "Username or password is Empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(useRsDATaBASE.checkIfuserExists(strName))
                    {
                        Toast.makeText(LoginSetting.this, "Username exists, please choose another one", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    useRsDATaBASE.AddUser(strName, strPass);
                    Toast.makeText(LoginSetting.this, "Account created, please login", Toast.LENGTH_SHORT).show();
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                { //Login
                    String strName= editText.getText().toString();
                    String strPass = editText2.getText().toString();
                    if(strName.equals("admin") && strPass.equals("admin123")){
                        Intent intent2 = new Intent(getApplicationContext(), adminClass.class);
                        startActivity(intent2);
                        return;
                    }
                    if(strName.isEmpty() || strPass.isEmpty())
                    {
                        Toast.makeText(LoginSetting.this, "Username or password is Empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String passwordFromDB = useRsDATaBASE.logInUser(strName);
                    if(passwordFromDB.equals(strPass)&&!strName.equals("admin"))
                    {
                        Intent intent1 = new Intent(getApplicationContext(), ListOfFood.class);
                        startActivity(intent1);
                    }
                    else
                        Toast.makeText(LoginSetting.this, "Username or password are incorrect", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
