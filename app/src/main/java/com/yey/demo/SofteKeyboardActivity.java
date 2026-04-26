package com.yey.demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.yey.demo.databinding.ActivitySofteKeyboardBinding;


public class SofteKeyboardActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = SofteKeyboardActivity.class.getName();
    private ActivitySofteKeyboardBinding mDataBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = (ActivitySofteKeyboardBinding) DataBindingUtil.setContentView(this, R.layout.activity_softe_keyboard);
        mDataBinding.setLifecycleOwner(this);
        initLister();
    }

    private void initLister() {
        mDataBinding.keyBoard.keypad0.setOnClickListener(this);
        mDataBinding.keyBoard.keypad1.setOnClickListener(this);
        mDataBinding.keyBoard.keypad2.setOnClickListener(this);
        mDataBinding.keyBoard.keypad3.setOnClickListener(this);
        mDataBinding.keyBoard.keypad4.setOnClickListener(this);
        mDataBinding.keyBoard.keypad5.setOnClickListener(this);
        mDataBinding.keyBoard.keypad6.setOnClickListener(this);
        mDataBinding.keyBoard.keypad7.setOnClickListener(this);
        mDataBinding.keyBoard.keypad8.setOnClickListener(this);
        mDataBinding.keyBoard.keypad9.setOnClickListener(this);
        mDataBinding.keyBoard.containerDelete.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.keypad0) inputNumber(0);
        else if (id == R.id.keypad1) inputNumber(1);
        else if (id == R.id.keypad2) inputNumber(2);
        else if (id == R.id.keypad3) inputNumber(3);
        else if (id == R.id.keypad4) inputNumber(4);
        else if (id == R.id.keypad5) inputNumber(5);
        else if (id == R.id.keypad6) inputNumber(6);
        else if (id == R.id.keypad7) inputNumber(7);
        else if (id == R.id.keypad8) inputNumber(8);
        else if (id == R.id.keypad9) inputNumber(9);
        else if (id == R.id.container_delete) deleteNumber();
    }

    /**
     * 删除内容
     */
    private void deleteNumber() {
        mDataBinding.vcv.deleteContent();
        String mCodeStr = mDataBinding.vcv.getContent();
        Toast.makeText(this, mCodeStr, Toast.LENGTH_LONG).show();
    }

    /**
     * 输入内容
     */
    private void inputNumber(int content) {
        mDataBinding.vcv.inputContent(String.valueOf(content));
        String mCodeStr = mDataBinding.vcv.getContent();
        Toast.makeText(this, mCodeStr, Toast.LENGTH_LONG).show();
    }
}
