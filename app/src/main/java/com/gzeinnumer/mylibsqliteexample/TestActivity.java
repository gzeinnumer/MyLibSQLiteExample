package com.gzeinnumer.mylibsqliteexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.mylibsqliteexample.databinding.ActivityTestBinding;
import com.gzeinnumer.mylibsqliteexample.entity.Table1;
import com.gzeinnumer.mylibsqliteexample.helper.GblVariabel;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GblVariabel.initDb(getApplicationContext());

        Table1 table1 = new Table1();

        binding.btnInsert.setOnClickListener(view -> {
            boolean istrue = table1.insert();
            Toast.makeText(this, "Insert data success " + istrue, Toast.LENGTH_SHORT).show();
        });
        binding.btnUpdate.setOnClickListener(view -> {
            boolean istrue2 = table1.update();
            Toast.makeText(this, "Update data success " + istrue2, Toast.LENGTH_SHORT).show();
        });
        binding.btnDelete.setOnClickListener(view -> {
            boolean istrue3 = table1.delete();
            Toast.makeText(this, "Delete data success " + istrue3, Toast.LENGTH_SHORT).show();
        });
        binding.btnCount.setOnClickListener(view -> {
            int count = table1.count();
            Toast.makeText(this, "Count data success " + count, Toast.LENGTH_SHORT).show();
        });
        binding.btnCount2.setOnClickListener(view -> {
            int count2 = table1.count2();
            Toast.makeText(this, "Count data success " + count2, Toast.LENGTH_SHORT).show();
        });
        binding.btnCount3.setOnClickListener(view -> {
            int count3 = table1.queryCount();
            Toast.makeText(this, "Count data success " + count3, Toast.LENGTH_SHORT).show();
        });
        binding.btnRead.setOnClickListener(view -> {
            List<Table1> read = table1.read();
            Toast.makeText(this, "Read data success " + read.get(0).getName() + " Size " + read.size(), Toast.LENGTH_SHORT).show();
        });
        binding.btnRead2.setOnClickListener(view -> {
            List<Table1> read2 = table1.read2();
            Toast.makeText(this, "Read data success " + read2.get(0).getName() + " Size " + read2.size(), Toast.LENGTH_SHORT).show();
        });
        binding.btnQuery.setOnClickListener(view -> {
            List<Table1> listQuery = table1.query();
            Toast.makeText(this, "Read data success " + listQuery.get(0).getName() + " Size " + listQuery.size() + " Table2Name " + listQuery.get(0).getTable2_name(), Toast.LENGTH_SHORT).show();
        });
        binding.btnQueryResultUpdate.setOnClickListener(view -> {
            boolean queryUpdate = table1.queryResultUpdate();
            Log.d(TAG, "onCreate_10: " + queryUpdate);
            Toast.makeText(this, "Update data success " + queryUpdate, Toast.LENGTH_SHORT).show();

        });
    }
}