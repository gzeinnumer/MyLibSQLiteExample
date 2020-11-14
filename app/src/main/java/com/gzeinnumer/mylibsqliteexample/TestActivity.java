package com.gzeinnumer.mylibsqliteexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.mylibsqlite.entity.MCategoryTrainer;
import com.gzeinnumer.mylibsqlite.helper.GblVariabel;

import java.util.List;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        GblVariabel.initDb(getApplicationContext());

        MCategoryTrainer mCategoryTrainer = new MCategoryTrainer();

        List<MCategoryTrainer> list = mCategoryTrainer.read();
        Log.d(TAG, "onCreate2: "+list.get(2).getName());
        Log.d(TAG, "onCreate2: "+list.size());

        List<MCategoryTrainer> listQuery = mCategoryTrainer.query();
        Log.d(TAG, "onCreate2: "+listQuery.get(0).getName());
        Log.d(TAG, "onCreate2: "+listQuery.get(0).getMtm_name());

        mCategoryTrainer.insert(new MCategoryTrainer(500, "Zein", 1, 1, "2020-12-12",1,"2020-12-12"));

        mCategoryTrainer.update(new MCategoryTrainer(500, "Zein", 1, 1, "2020-11-11",1,"2020-11-11"), "id = '500'");

        int count = mCategoryTrainer.count();
    }
}