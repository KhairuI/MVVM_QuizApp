package com.example.quizapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.model.FireStoreInterface;
import com.example.quizapp.model.FirebaseRepository;
import com.example.quizapp.model.QuizModel;

import java.util.List;

public class QuizListViewModel extends ViewModel implements FireStoreInterface {

    private MutableLiveData<List<QuizModel>> quizListModeldata= new MutableLiveData<>();

    public LiveData<List<QuizModel>> getQuizListModeldata() {
        return quizListModeldata;
    }


    FirebaseRepository firebaseRepository= new FirebaseRepository(this);

    public QuizListViewModel(){
        firebaseRepository.getQuizData();
    }

    @Override
    public void quizListDataAdded(List<QuizModel> quizModelList) {

        quizListModeldata.setValue(quizModelList);
    }

    @Override
    public void onError(Exception e) {

    }
}
