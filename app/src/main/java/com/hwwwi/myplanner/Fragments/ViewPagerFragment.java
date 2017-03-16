package com.hwwwi.myplanner.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwwwi.myplanner.Fragments.CalenderFragment;
import com.hwwwi.myplanner.Fragments.PlanFragment;
import com.hwwwi.myplanner.Fragments.SettingFragment;
import com.hwwwi.myplanner.Fragments.TodoFragment;
import com.hwwwi.myplanner.R;

/**
 * Created by hwi on 17. 3. 13.
 */

public class ViewPagerFragment extends Fragment {

    public static final String KEY_TODO_INDEX = "todo_index";

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //int index = getArguments().getInt(KEY_RECIPE_INDEX);
        //Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();

        //getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);

        final CalenderFragment tab_calender = new CalenderFragment();
        final TodoFragment tab_todo = new TodoFragment();
        final PlanFragment tab_today = new PlanFragment();
        final SettingFragment tab_setting = new SettingFragment();


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment item;
                if(position == 0) item = tab_calender;
                else if(position ==1) item = tab_today;
                else if(position ==2) item = tab_todo;
                else item = tab_setting;
                return item;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title ;
                if(position == 0) title = "달력";
                else if(position ==1) title = "계획";
                else if(position ==2) title = "할 일";
                else title = "설정";
                return title;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
