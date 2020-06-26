package com.example.quizapp.model;

import java.util.List;

public interface FireStoreInterface {

    void quizListDataAdded(List<QuizModel> quizModelList);
    void onError(Exception e);
}
