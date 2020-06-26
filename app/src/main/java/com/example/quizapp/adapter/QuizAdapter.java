package com.example.quizapp.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quizapp.R;
import com.example.quizapp.model.QuizModel;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private List<QuizModel> quizModelList;

    public void setQuizModelList(List<QuizModel> quizModelList) {
        this.quizModelList = quizModelList;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list,parent,false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

        holder.quizTitle.setText(quizModelList.get(position).getName());
        String imageUrl= quizModelList.get(position).getImage();
        Glide.with(holder.itemView.getContext()).load(imageUrl)
                .centerCrop().placeholder(R.drawable.placeholder_image).into(holder.imageView);
        String quizDesc= quizModelList.get(position).getDesc();
        if(quizDesc.length() >120){
            quizDesc= quizDesc.substring(0,120);
        }
        holder.quizDescription.setText(quizDesc +"....");
        holder.quizDificulty.setText(quizModelList.get(position).getLevel());

    }

    @Override
    public int getItemCount() {
        if(quizModelList==null){
            return 0;
        }
        else {
            return quizModelList.size();
        }
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView imageView;
        private AppCompatTextView quizTitle;
        private AppCompatTextView quizDescription;
        private AppCompatTextView quizDificulty;
        private AppCompatButton button;


        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.singleQuizImageId);
            quizTitle= itemView.findViewById(R.id.singleQuizTitleId);
            quizDescription= itemView.findViewById(R.id.singleQuizDescriptionId);
            quizDificulty= itemView.findViewById(R.id.singleQuizDifficultyId);
            button= itemView.findViewById(R.id.singleQuizButtonId);
        }
    }
}
