package com.hwwwi.myplanner;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.hwwwi.myplanner.Fragments.TodoFragment;

/**
 * Created by hwi on 17. 3. 15.
 */

public class ListAdapter extends RecyclerView.Adapter {

    private final TodoFragment.OnTodoSelectedInterface mListener;

    public ListAdapter(TodoFragment.OnTodoSelectedInterface listener) {
        mListener = listener;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //바로 item과 bind할 수가 없으니까 listViewHolder에서 bindview함수를 만들어서 내가 가진 데이터(여기서는 레시피)
        //와 item을 bind하자
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return (TodoData.names.length + ScheduleData.names.length);
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CheckBox mCheckBox;
        private TextView mTextView;
        private int mIndex;

        //체크박스 체크하거나 해제하면 변화되는 내용 설정
        CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener =new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) mTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                else mTextView.setPaintFlags(0);
            }
        };

        public ListViewHolder(View itemView) {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.todoCheckBox);
            mTextView = (TextView) itemView.findViewById(R.id.todoText);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position) //정보 불러와서 연결하는 곳
        {
            mIndex = position;
            int scheduleNum = ScheduleData.names.length;
            if (position < scheduleNum) //기념일 일때
            {
                mTextView.setText(ScheduleData.names[position]);
                mTextView.setTextColor(Color.BLUE);
                mCheckBox.setWidth(0);
                mCheckBox.setVisibility(View.INVISIBLE);

            }
            else //할일 일때
            {
                mTextView.setText(TodoData.names[position-scheduleNum]);
                if(TodoData.isChecked[position-scheduleNum])
                {
                    mCheckBox.toggle();
                    mTextView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                }
                mCheckBox.setOnCheckedChangeListener(mOnCheckedChangeListener);
            }

        }

        @Override
        public void onClick(View v) {
            mListener.onListTodoSelected(mIndex);
        }
    }
}