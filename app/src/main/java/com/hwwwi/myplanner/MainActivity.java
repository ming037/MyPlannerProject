package com.hwwwi.myplanner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hwwwi.myplanner.Fragments.TodoFragment;
import com.hwwwi.myplanner.Fragments.ViewPagerFragment;

public class MainActivity extends AppCompatActivity implements TodoFragment.OnTodoSelectedInterface
{
    public static final String VIEWPAGER_FRAGMENT= "viewpager_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPagerFragment savedFragment = (ViewPagerFragment) getFragmentManager().
                findFragmentByTag(VIEWPAGER_FRAGMENT);

        if(savedFragment == null)
        {
            ViewPagerFragment fragment = new ViewPagerFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListTodoSelected(int index) {

        if(index>=ScheduleData.names.length) //할 일은 수정창으로
        {
            Intent intent = new Intent(MainActivity.this, AddTodoActivity.class);
            intent.putExtra(ViewPagerFragment.KEY_TODO_INDEX, index);
            intent.putExtra("checklist", 1); //1은 수정
            this.startActivity(intent);

        }
        //else  기념일 수정 창으로

    }
}
