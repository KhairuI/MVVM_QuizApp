package com.example.quizapp.model;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseRepository {

    private FireStoreInterface fireStoreInterface;
    private FirebaseFirestore firebaseFirestore= FirebaseFirestore.getInstance();
    private CollectionReference reference= firebaseFirestore.collection("QuizList");

    public FirebaseRepository(FireStoreInterface fireStoreInterface) {
        this.fireStoreInterface = fireStoreInterface;
    }

    public void getQuizData(){
        reference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                fireStoreInterface.quizListDataAdded(queryDocumentSnapshots.toObjects(QuizModel.class));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                fireStoreInterface.onError(e);
            }
        });
    }
}
