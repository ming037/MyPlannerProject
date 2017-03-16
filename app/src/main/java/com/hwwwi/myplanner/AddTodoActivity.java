package com.hwwwi.myplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hwwwi.myplanner.Fragments.ViewPagerFragment;

public class AddTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        final int index = getIntent().getIntExtra(ViewPagerFragment.KEY_TODO_INDEX, -1);
        final int version = getIntent().getIntExtra("checklist", -1);
        Button buttonLeft = (Button) findViewById(R.id.AddTodoButtonLeft);
        Button buttonRight = (Button) findViewById(R.id.AddTodoButtonRight);

        if(version == 1) //1은 수정, 2는 신규
        {
            buttonLeft.setText("삭제");
            buttonRight.setText("완료");
            buttonLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (index != -1) {
                        //delete
                    }

                }
            });

            buttonRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        else
        {
            buttonLeft.setText("취소");
            buttonRight.setText("완료");
            buttonLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            buttonRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }




    }
}
