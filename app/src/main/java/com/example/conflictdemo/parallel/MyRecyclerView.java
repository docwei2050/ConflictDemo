package com.example.conflictdemo.parallel;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(@NonNull Context context) {
        this(context,null);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float lastDownX;
    private float lastDownY;
   //scrollView嵌套多个子RecyclerView，
    //不处理冲突，那么滑到第二个RecyclerView就会卡卡的
    //处理：OnTouchEvent事件里面先设置消费down事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
                lastDownX = ev.getX();
                lastDownY = ev.getY();
                //down事件必须消费
                return true;
            case MotionEvent.ACTION_MOVE:
                //如果是左右滑动就拦截
                float moveX = ev.getX();
                float moveY = ev.getY();
                float deltaX = moveX - lastDownX;
                float deltaY = moveY - lastDownY;
                //上下滑动
                Log.e("scrollView  ", "dispatchTouchEvent: " + Math.abs(deltaX) + "-----lllll" +Math.abs(deltaY));
                if (Math.abs(deltaX) < Math.abs(deltaY)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                //滑动最后一个Item的时候要置为false，不然没法滑到下一个RecyclerView
                LinearLayoutManager linearLayoutManager= (LinearLayoutManager) getLayoutManager();
                if(linearLayoutManager.findLastVisibleItemPosition()==getAdapter().getItemCount()-1){
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                lastDownX = moveX;
                lastDownY = moveY;
                break;
        }
        return super.onTouchEvent(ev);
    }
}
