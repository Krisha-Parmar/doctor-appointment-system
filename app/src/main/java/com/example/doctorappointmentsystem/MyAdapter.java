package com.example.doctorappointmentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.firebase.database.core.Context;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Doctor> doctorArrayList;

    public MyAdapter(Context context, ArrayList<Doctor> doctorArrayList) {
        this.context = context;
        this.doctorArrayList = doctorArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.doctorlist,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Doctor doctor = doctorArrayList.get(position);

        holder.doctorName.setText(doctor.DoctorName);
        holder.experience.setText(doctor.Experience);
        holder.speciality.setText(doctor.Speciality);
    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView doctorName,experience,speciality;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorName = itemView.findViewById(R.id.doctorname);
            experience = itemView.findViewById(R.id.experience);
            speciality = itemView.findViewById(R.id.speciality);
        }
    }
}