package com.example.yogi.database_login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    public static final String IDs = "MyKey";
    Button Log_In;
    EditText User_Name, Pass_Word;
    TextView ClcikHere;
    DATABASE_SOURCE DBS;
    String L1, L2, L3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log_In = (Button) findViewById(R.id.Log_In);
        User_Name = (EditText) findViewById(R.id.User_Name);
        Pass_Word = (EditText) findViewById(R.id.Pass_Word);
        ClcikHere = (TextView) findViewById(R.id.Click_here);

        ClcikHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        DBS = new DATABASE_SOURCE(getApplicationContext());
        DBS.openDB();

        Log_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1 = User_Name.getText().toString();
                L2 = Pass_Word.getText().toString();
                String UNAME, PWD;
        //        int i;

                // DATABASE_SORCE CLASS METHOD CALLED
                Cursor cursor = DBS.SOURCELOGIN_METHOD();
                cursor.moveToFirst();

                try {
                    boolean present = true;
                    do {
                     //   i = cursor.getInt(cursor.getColumnIndex(MyTableData.DETAILS.ID));
                        UNAME = cursor.getString(cursor.getColumnIndex(MyTableData.DETAILS.USERNAME));
                        PWD = cursor.getString(cursor.getColumnIndex(MyTableData.DETAILS.PASSWORD));

                        if (L1.equals(UNAME) && L2.equals(PWD)) {
                            User_Name.setText("");
                            Pass_Word.setText("");
                            present = false;

                            Intent intent = new Intent(getApplicationContext(), MY_HOMEPAGE.class);
                            startActivity(intent);
                        }
                    } while (cursor.moveToNext());
                    if (present) {
                        Toast.makeText(getApplicationContext(), "no account present", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}