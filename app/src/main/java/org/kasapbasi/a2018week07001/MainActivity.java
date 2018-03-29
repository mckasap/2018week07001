package org.kasapbasi.a2018week07001;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CheckPermission(View view) {

        int PermissionCheck= ContextCompat.checkSelfPermission (this,"Manifest.permission.READ_CALENDAR");
        if( PermissionCheck!= PackageManager.PERMISSION_GRANTED){

            if(shouldShowRequestPermissionRationale("Manifest.permission.READ_CALENDAR")){



            }else {
                requestPermissions(new String[]{Manifest.permission.READ_CALENDAR}, 0);
            }


        }else
        {

            Toast.makeText(this,"ZATEN iznin Var",Toast.LENGTH_LONG).show();
        }


    }
}
