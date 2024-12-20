package com.example.studentenrollmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    private List<Subject> subjects;
    private Context context;

    public SubjectAdapter(Context context, List<Subject> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_enrollment_menu, parent, false);
        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.subjectCheckBox.setText(subject.getName() + " (" + subject.getCredits() + " Credits)");
        holder.subjectCheckBox.setTag(subject.getCredits());
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder {
        CheckBox subjectCheckBox;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectCheckBox = itemView.findViewById(R.id.subjectCheckBox);
        }
    }
}
