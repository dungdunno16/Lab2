package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected EditText txtName;
    protected Button btnAdd;
    protected Button btnDelete;
    protected ListView lstContact;
    protected Adapter adapter;
    protected ArrayList<Contact> lstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        lstContact = findViewById(R.id.lstContact);

        lstName = new ArrayList<Contact>();
        lstName.add(new Contact(1,"John","091234432"));
        lstName.add(new Contact(2,"Bob","093252352"));
        lstName.add(new Contact(3,"Alice","096525254"));

        adapter = new Adapter(lstName,this);

        lstContact.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstName.add(new Contact(4,txtName.getText().toString(),null));
                adapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contactsToRemove = new ArrayList<>();
                for (Contact c : lstName) {
                    if (c.isStatus()) {
                        contactsToRemove.add(c);
                    }
                }

                lstName.removeAll(contactsToRemove);
                adapter.notifyDataSetChanged();
            }
        });
    }
}