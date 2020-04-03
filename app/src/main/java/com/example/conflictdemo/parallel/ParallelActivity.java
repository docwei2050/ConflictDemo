package com.example.conflictdemo.parallel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conflictdemo.MyAdapter;
import com.example.conflictdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ParallelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallel);
        RecyclerView recyclerView1 = findViewById(R.id.recycler1);
        RecyclerView recyclerView2 = findViewById(R.id.recycler2);
        RecyclerView recyclerView3 = findViewById(R.id.recycler3);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第" + i + "行");
        }
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        recyclerView1.setAdapter(new MyAdapter(list,this,0));
        recyclerView2.setAdapter(new MyAdapter(list,this,1));
        recyclerView3.setAdapter(new MyAdapter(list,this,2));


    }
}
