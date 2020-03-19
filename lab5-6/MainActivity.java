package com.example.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button insert_b, display_b, delete_b, update_b;
    EditText name_txt, marks_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDb = DatabaseHelper.getInstance(this);
        name_txt = (EditText) findViewById(R.id.editText);
        marks_txt = (EditText) findViewById(R.id.editText2);
        insert_b = (Button) findViewById(R.id.button);
        display_b = (Button) findViewById(R.id.button1);
        update_b = (Button) findViewById(R.id.button2);
        delete_b = (Button) findViewById(R.id.button3);


        insert_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (name_txt.getText().toString().trim().length() == 0 ||
                        marks_txt.getText().toString().trim().length() == 0) {

                    showMessage("Error", "Please enter all values");
                    return;
                }
                myDb.insert_record(name_txt.getText().toString(),
                        Integer.parseInt(marks_txt.getText().toString()));
                showMessage("Success", "Record added");
                clearText();

            }
        });
        display_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer record_details = (StringBuffer) myDb.display_all_records();
                showMessage("Display Status", record_details.toString());
                clearText();
            }
        });
        update_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name_txt.getText().toString().trim().length()==0||
                        marks_txt.getText().toString().trim().length() == 0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                myDb.update_record(name_txt.getText().toString(),Integer.parseInt(marks_txt.getText().toString()));
                showMessage("Success","Record Updated");
                clearText();
            }
        });
        delete_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name_txt.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter Name");
                    return;
                }

                myDb.delete_record(name_txt.getText().toString());
                showMessage("Success","Record Deleted");
                clearText();
            }

        });
    }


    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {

        name_txt.setText("");
        marks_txt.setText("");

    }

}
