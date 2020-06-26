package com.example.quizapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.quizapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class StartFragment extends Fragment {

    private AppCompatTextView startTextView;
    private ProgressBar startProgressBar;
    private FirebaseAuth firebaseAuth;
    private NavController navController;


    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseAuth= FirebaseAuth.getInstance();
        navController= Navigation.findNavController(view);
        startProgressBar= view.findViewById(R.id.startProgressId);
        startTextView= view.findViewById(R.id.startingTextId);
        startTextView.setText("Checking user account.....");

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser= firebaseAuth.getCurrentUser();
        if(currentUser==null){
            startTextView.setText("Creating account.....");
            //user must create a new account
            
            firebaseAuth.signInAnonymously().addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    startTextView.setText("Account created.....");
                    //go to the home page...
                    navController.navigate(R.id.action_startFragment_to_listFragment);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getActivity(), ""+e, Toast.LENGTH_SHORT).show();
                }
            });
            
        }
        else {
            //go to the home page...
            startTextView.setText("Logged in.....");
            navController.navigate(R.id.action_startFragment_to_listFragment);
        }
    }
}