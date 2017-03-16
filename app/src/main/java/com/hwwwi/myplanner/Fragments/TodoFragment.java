package com.hwwwi.myplanner.Fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hwwwi.myplanner.AddTodoActivity;
import com.hwwwi.myplanner.ListAdapter;
import com.hwwwi.myplanner.R;


/**
 * Created by hwi on 17. 3. 13.
 */

public class TodoFragment extends Fragment {
    private ImageButton mAddButton;

    public interface OnTodoSelectedInterface {
     void onListTodoSelected(int index);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        OnTodoSelectedInterface listener = (OnTodoSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        /********경계선 넣기
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        */

        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        mAddButton = (ImageButton) view.findViewById(R.id.addTodoButton);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddTodoActivity.class);
                intent.putExtra("checklist", 2); //2는 신규
                getActivity().startActivity(intent);


            }
        });
        return view;

    }



}