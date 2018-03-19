package com.example.rachi.first;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SQLiteOpenHelper openHelper;
SQLiteDatabase db;
Button but;
EditText f;
EditText l,p,e,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper= new databasehelper(this);
        but=(Button)findViewById(R.id.but);
        f=(EditText)findViewById(R.id.f);
        l=(EditText)findViewById(R.id.l);
        p=(EditText)findViewById(R.id.p);
        e=(EditText)findViewById(R.id.e);
        pass=(EditText)findViewById(R.id.pass);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            db=openHelper.getWritableDatabase();
            String F_Name= f.getText().toString();

                String L_Name= l.getText().toString();
                String Passowrd= pass.getText().toString();
                String Email= e.getText().toString();
                String Phone = p.getText().toString();
                insertdata(F_Name,L_Name,Passowrd,Phone,Email);
                Toast.makeText(getApplicationContext(),"register succesfull",Toast.LENGTH_LONG).show();
            }
        });


    }
    public void insertdata(String F_name,String L_name,String Password,String Email,String Phone)
    {
        ContentValues contentValues =new ContentValues();
        contentValues.put(databasehelper.col2,F_name);
        contentValues.put(databasehelper.col3,L_name);
        contentValues.put(databasehelper.col4,Password);
        contentValues.put(databasehelper.col2,Email);
        contentValues.put(databasehelper.col2,Phone);
        long id=db.insert(databasehelper.tablename,null,contentValues);
    }
}
//comiting changes