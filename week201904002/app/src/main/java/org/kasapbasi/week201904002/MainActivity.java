package org.kasapbasi.week201904002;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView  tv;

    public void Oku(View v){

        SQLiteDatabase db= openOrCreateDatabase("MyDb",MODE_PRIVATE,null);
        Cursor c= db.rawQuery("Select * from myTable",null);

        String str="";
        if(c!=null){
            c.moveToFirst();
            do{
                str+= c.getString(c.getColumnIndex("FirstName")) +"  ";
                str+= c.getString(c.getColumnIndex("LastName")) +"  ";
                str+=c.getInt(c.getColumnIndex("Age")) +"/n";
            }while(c.moveToNext());
         tv.setText(str);


        }

    }

    public void Tiklandi(View v){
        SQLiteDatabase db = openOrCreateDatabase("MyDb",MODE_PRIVATE,null);

        db.execSQL("Create Table if not exists myTable(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                ",FirstName varchar NOT NULL," +
                "LastName varchar NOT NULL, " +
                "Age int(3) NOT NULL )");
         db.execSQL("Insert Into myTable(FirstName,LastName, Age)" +
                         " values('kasapbaşı','Mustafa Cem ',43)");

        db.close();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView);
    }
}
