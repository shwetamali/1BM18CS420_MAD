package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner s;
    Button b1;
    EditText et1,et2;
    TextView tv,tv1,tv2,tv3;

    String[] dept_array={"CSE","ECE","ISE","MECH","CVIL"};
    String name,reg,dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView);
        b1=(Button) findViewById(R.id.button);
        tv1=(TextView) findViewById(R.id.textView2);
        et1=(EditText) findViewById(R.id.editText);
        tv2=(TextView) findViewById(R.id.textView3);
        et2=(EditText) findViewById(R.id.editText2)
        tv3=(TextView) findViewById(R.id.textView4);
        s=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter;
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et1.getText().toString();
                reg=et2.getText().toString();
                dept=s.getSelectedItem().toString();


                Intent i = new Intent(MainActivity.this,sec_activity.class);

                i.putExtra("name_key",name);
                i.putExtra("reg_key",reg);
                i.putExtra("dept_key",dept);

                startActivity(i);


            }
        });



    }
}
