package com.example.edukacine2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class ResultAdapter extends ArrayAdapter<Result> {

    public ResultAdapter(Context context, int resource, List<Result> resultList ){
        super(context,  resource, resultList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Result result = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }
        TextView kidName = (TextView) convertView.findViewById(R.id.kidName);
        TextView taskType = (TextView) convertView.findViewById(R.id.taskType);
        TextView level = (TextView) convertView.findViewById(R.id.level);
        TextView correct = (TextView) convertView.findViewById(R.id.correct);
        TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        taskType.setText(result.getTaskType());
        kidName.setText(result.getUsername());
        level.setText(String.valueOf(result.getLevel()));
        correct.setText(String.valueOf(result.getCorrectAnsw()));
        quantity.setText(String.valueOf(result.getQuestionQntt()));
        date.setText(String.valueOf(result.getDate()));

        return convertView;
    }
}
