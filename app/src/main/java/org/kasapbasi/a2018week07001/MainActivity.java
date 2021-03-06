package org.kasapbasi.a2018week07001;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

     final int readCalender=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link PackageManager#PERMISSION_GRANTED}
     *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
     * @see #requestPermissions(String[], int)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode){

            case readCalender:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"İzni Kaptım",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"Tekrar İzni iste",Toast.LENGTH_LONG).show();


                break;
            default:

        }

    }

    public void CheckPermission(View view) {

        int PermissionCheck= ContextCompat.checkSelfPermission (this,"Manifest.permission.READ_CALENDAR");
        if( PermissionCheck!= PackageManager.PERMISSION_GRANTED){

            if(shouldShowRequestPermissionRationale("Manifest.permission.READ_CALENDAR")){



            }else {
                requestPermissions(new String[]{Manifest.permission.READ_CALENDAR}, readCalender);
            }

        }else
        {

            Toast.makeText(this,"ZATEN iznin Var",Toast.LENGTH_LONG).show();
        }


    }
}
