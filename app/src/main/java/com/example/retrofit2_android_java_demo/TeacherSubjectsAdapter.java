package com.example.retrofit2_android_java_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.retrofit2_android_java_demo.api.model.SubjectResponse;

import java.util.List;

public class TeacherSubjectsAdapter extends ArrayAdapter<SubjectResponse> {
    public TeacherSubjectsAdapter(@NonNull Context context, int resource, @NonNull List<SubjectResponse> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Adapter.getViewで必ず定義する。
        if (convertView == null) {
            // R.layout.subject_list_itemはListView内に配置するViewレイアウトファイルを指定する。
            // 3つ目のAttachToRoot falseは指定しないとエラーが発生する
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.subject_list_item, parent,false);
        }

        SubjectResponse subject = getItem(position);

        TextView subjectNameView = convertView.findViewById(R.id.subjectName);
        subjectNameView.setText(subject.subjectName);

        return convertView;
    }

}
