package com.example.quizapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.quizapp.R;
import com.example.quizapp.adapter.QuizAdapter;
import com.example.quizapp.model.QuizModel;
import com.example.quizapp.viewmodel.QuizListViewModel;

import java.util.List;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private QuizListViewModel quizListViewModel;
    private QuizAdapter adapter;
    private ContentLoadingProgressBar progressBar;

    private Animation splashIn;
    private Animation splashOut;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar= view.findViewById(R.id.listProgressBarId);

        recyclerView= view.findViewById(R.id.quizRecycleId);
        adapter= new QuizAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        splashIn= AnimationUtils.loadAnimation(getContext(),R.anim.splash);
        splashOut= AnimationUtils.loadAnimation(getContext(),R.anim.splash_out);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quizListViewModel= new ViewModelProvider(getActivity()).get(QuizListViewModel.class);
        quizListViewModel.getQuizListModeldata().observe(getViewLifecycleOwner(), new Observer<List<QuizModel>>() {
            @Override
            public void onChanged(List<QuizModel> quizModelList) {

                //load Recycle Animation......
                recyclerView.startAnimation(splashIn);
                progressBar.startAnimation(splashOut);

                adapter.setQuizModelList(quizModelList);
                adapter.notifyDataSetChanged();
            }
        });

    }
}