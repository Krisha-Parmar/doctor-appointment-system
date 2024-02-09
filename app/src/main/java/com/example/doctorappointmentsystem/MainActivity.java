package com.example.doctorappointmentsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signinlayout(View view ){
        setContentView(R.layout.sign_in);
    }
    public void homelayout(View view ){
        setContentView(R.layout.home2);
    }

    public void testMethod(View view){
        FirebaseAuth mAuth  =  FirebaseAuth.getInstance();;
        FirebaseAuth.AuthStateListener mAuthListner;
        FirebaseUser mUser;

        System.out.println("Wohooo");
        EditText Email = (EditText) findViewById(R.id.emailSignin);
        String email = Email.getText().toString().trim();
        EditText Password= (EditText) findViewById(R.id.passwordSignin);
        String password = Password.getText().toString().trim();


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
//                    dialog.dismiss();

                     System.out.println("=== Woho Your user does not exist");
//                    Toast.makeText(login.this, "Login not successfull", Toast.LENGTH_SHORT).show();

                } else {
                    FirebaseUser users=FirebaseAuth.getInstance().getCurrentUser();
                    boolean emailVerified=users.isEmailVerified();
                    System.out.println("=== emailVerified" + emailVerified);
                    System.out.println(users.getUid());
                    setContentView(R.layout.home2);
//                    dialog.dismiss();

//                    checkIfEmailVerified();

                }
            }
        });


    }

    public void loginlayout(View view ){
        setContentView(R.layout.loginpage);

//        FirebaseAuth mAuth  =  FirebaseAuth.getInstance();;
//        FirebaseAuth.AuthStateListener mAuthListner;
//        FirebaseUser mUser;

//        EditText fullName = (EditText) findViewById(R.id.fullname);
//        String actualFullName = fullName.getText().toString().trim();
//        EditText email = (EditText) findViewById(R.id.email);
//        String actuaEmail = email.getText().toString().trim();
//        EditText password = (EditText) findViewById(R.id.password);
//        String actualPassword = password.getText().toString().trim();

//        mAuth.createUserWithEmailAndPassword(actuaEmail, actualPassword)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            System.out.println(user.getEmail());
////                            updateUI(user);
//                        } else {
//                            System.out.println("Oops Something Went Wrong");
//                            // If sign in fails, display a message to the user.
////                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
////                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
////                                    Toast.LENGTH_SHORT).show();
////                            updateUI(null);
//                        }
//                    }
//                });

    }
    public void signUpUser(View view){
        FirebaseAuth mAuth  =  FirebaseAuth.getInstance();;
        FirebaseAuth.AuthStateListener mAuthListner;
        FirebaseUser mUser;

        EditText fullName = (EditText) findViewById(R.id.fullname);
        String actualFullName = fullName.getText().toString().trim();
        EditText email = (EditText) findViewById(R.id.email);
        String actuaEmail = email.getText().toString().trim();
        EditText password = (EditText) findViewById(R.id.password);
        String actualPassword = password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(actuaEmail, actualPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            System.out.println(user.getEmail());
                            setContentView(R.layout.sign_in);
//                            updateUI(user);
                        } else {
                            System.out.println("Oops Something Went Wrong");
                            // If sign in fails, display a message to the user.
                            Log.d("Woo", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }
    public void searchlayout(View view) {setContentView(R.layout.seach);}
    public void callayout(View view) {setContentView(R.layout.cal);}
    public void baglayout(View view) {setContentView(R.layout.bag);}
    public void profilelayout(View view) {setContentView(R.layout.profile);}
    public void dr1layout(View view) {setContentView(R.layout.dr1);}
    public void editlayout(View view) {setContentView(R.layout.editprofile);}



}