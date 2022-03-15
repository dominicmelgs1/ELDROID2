package com.example.melgodominic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;


public class CreateStudent extends AppCompatActivity {
    //global variables
    Spinner spinner;
    CheckBox male, female;
    Button add;
    EditText fname, lname, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        ref();
        spnr();

        //validator for checkboxes
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!male.isChecked() && !female.isChecked()) {
                    male.setChecked(true);
                    female.setChecked(false);
                }
                if ( female.isChecked() && male.isChecked()){
                    male.setChecked(true);
                    female.setChecked(false);
                }

            }
        });
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!female.isChecked() && !male.isChecked()) {
                    female.setChecked(true);
                    male.setChecked(false);
                }
                if ( female.isChecked() && male.isChecked()){
                    female.setChecked(true);
                    male.setChecked(false);
                }

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectStudent objectStudent = new ObjectStudent();
                objectStudent.firstname = fname.getText().toString();
                objectStudent.lastname = lname.getText().toString();
                objectStudent.address = address.getText().toString();
                objectStudent.course = spinner.getSelectedItem().toString();
                if(female.isChecked()){
                    objectStudent.gender = "Female";
                }
                else if(male.isChecked()){
                    objectStudent.gender = "Male";
                }

            }
        });

    }
    public void ref(){
        spinner = findViewById(R.id.Course_Spinner);
        //
        male = findViewById(R.id.Male_CheckBox);
        female = findViewById(R.id.Female_CheckBox);
        //
        fname = findViewById(R.id.Firstname_EditText);
        lname =findViewById(R.id.Lastname_EditText);
        address = findViewById(R.id.Address_EditText);
        //
        add = findViewById(R.id. Add_Button);
    }
    public void spnr(){
        //creating a list of items for the spinner.
        String[] items = new String[]{"BSIT", "BSED", "BSCE", "BSMA", "BSCRIM", "BSNURSING"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinner.setAdapter(adapter);
    }
}