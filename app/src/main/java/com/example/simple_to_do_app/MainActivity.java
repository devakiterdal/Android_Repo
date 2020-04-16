package com.example.simple_to_do_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    private Button button;
    private ListView list_item;
    private EditText editText;

    private ArrayList<String> items;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        list_item = findViewById(R.id.list_item);

        items = DataStorage.readData(this);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        list_item.setAdapter(adapter);


        button.setOnClickListener(this);
        list_item.setOnItemClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String itemEntered = editText.getText().toString();
                adapter.add(itemEntered);
                editText.setText("");

                DataStorage.writeData(items, this);
                Toast.makeText(MainActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onItemClick(AdapterView parent, View view, int position , long id){
            items.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
        }
    }
//    list_item.setOnItemClickListener(AdapterView.OnItemClickListener listener){






