package com.example.conflictdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.conflictdemo.MyAdapter;
import com.example.conflictdemo.R;
import com.example.conflictdemo.parallel.ParallelActivity;
import com.example.conflictdemo.vertical.VerticalActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void go2Vertical(View view) {
        Intent intent=new Intent(MainActivity.this, VerticalActivity.class);
        startActivity(intent);
    }

    public void go2Parallel(View view) {
        Intent intent=new Intent(MainActivity.this, ParallelActivity.class);
        startActivity(intent);
    }
}
