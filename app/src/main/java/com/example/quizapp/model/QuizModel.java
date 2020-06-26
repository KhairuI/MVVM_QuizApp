package com.example.quizapp.model;

import com.google.firebase.firestore.DocumentId;

public class QuizModel {

    @DocumentId
    private String quiz_id;
    private String name,desc,image,level,visibility;
    private long question;

    public QuizModel() {
        //empty constractor
    }

    public QuizModel(String quiz_id, String name, String desc, String image, String level, String visibility, long question) {
        this.quiz_id = quiz_id;
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.level = level;
        this.visibility = visibility;
        this.question = question;
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(String quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public long getQuestion() {
        return question;
    }

    public void setQuestion(long question) {
        this.question = question;
    }
}
