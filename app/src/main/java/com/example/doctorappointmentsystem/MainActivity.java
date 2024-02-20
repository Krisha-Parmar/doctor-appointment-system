package com.example.doctorappointmentsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public TextView txview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txview=findViewById(R.id.textView40);
    }
    public void signinlayout(View view ){
        setContentView(R.layout.sign_in);
    }
    public void homelayout(View view ){
        setContentView(R.layout.home2);
    }
    public void abc(View view){
        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(myIntent);
        Toast.makeText(MainActivity.this, "activity changed", Toast.LENGTH_SHORT).show();
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
//        TextView view1=(TextView) findViewById(R.id.textView40);
//        view1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(myIntent);
//
//            }
//        });

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
    public void doctorlistlayout(View view) {setContentView(R.layout.doctorlist);}
    public void bookinglayout(View view) {setContentView(R.layout.datetime);}

//    public void EventChangeListener(){
//        ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Fetching data...");
//        progressDialog.show();
//
//        RecyclerView recyclerView;
//        ArrayList<Doctor> doctorArrayList;
//        MyAdapter myAdapter;
//        FirebaseFirestore db;
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        db = FirebaseFirestore.getInstance();
//        doctorArrayList = new ArrayList<Doctor>();
//        myAdapter = new MyAdapter(MainActivity.this,doctorArrayList);
//
//        recyclerView.setAdapter(myAdapter);
//
//        EventChangeListener();
//
//        db.collection("Doctors").orderBy("doctorName", Query.Direction.ASCENDING)
//                .addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                if (error != null){
//                    if (progressDialog.isShowing())
//                        progressDialog.dismiss();
//                    System.out.println("Firestore error");
//                    return;
//                }
//                for (DocumentChange dc : value.getDocumentChanges()){
//                    if (dc.getType() == DocumentChange.Type.ADDED){
//                        doctorArrayList.add(dc.getDocument().toObject((Doctor.class)));
//                    }
//                    myAdapter.notifyDataSetChanged();
//                    if (progressDialog.isShowing())
//                        progressDialog.dismiss();
//                }
//
//            }
//        });
//    }


//    public void insertData(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CalendarView calendarView = findViewById(R.id.calendar_view);
//        EditText Time = findViewById(R.id.appointment_time);
////        String time = Time.getText().toString().trim();
//        EditText Reason = findViewById(R.id.appointment_reason);
////        String reason = Reason.getText().toString().trim();
//
//        Map<String,String> items=new HashMap<>();
//        items.put("date", String.valueOf(calendarView.getDate()));
//        items.put("time", Time.getText().toString().trim());
//        items.put("reason", Reason.getText().toString().trim());
//
//        db.collection("bookings").add(items)
//                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        calendarView.setDate(Long.parseLong(""));
//                        Time.setText("");
//                        Reason.setText("");
//                        System.out.println("Inserted successfully");
//                    }
//                });
//    }

    public void callayout(View view) {setContentView(R.layout.cal);}
    public void baglayout(View view) {setContentView(R.layout.bag);}
    public void profilelayout(View view) {setContentView(R.layout.profile);}
    public void dr1layout(View view) {setContentView(R.layout.dr1);}
    public void editlayout(View view) {setContentView(R.layout.editprofile);}


    public void insertData(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        EditText Date = findViewById(R.id.appointment_date);
        EditText Time = findViewById(R.id.appointment_time);
//        String time = Time.getText().toString().trim();
        EditText Reason = findViewById(R.id.appointment_reason);
//        String reason = Reason.getText().toString().trim();

        Map<String,String> items=new HashMap<>();
        items.put("date", Date.getText().toString().trim());
        items.put("time", Time.getText().toString().trim());
        items.put("reason", Reason.getText().toString().trim());

        db.collection("bookings").add(items)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Date.setText("");
                        Time.setText("");
                        Reason.setText("");
                        System.out.println("Inserted successfully");
                    }
                });

    }
}