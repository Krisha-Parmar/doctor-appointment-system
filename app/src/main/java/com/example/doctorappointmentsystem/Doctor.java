package com.example.doctorappointmentsystem;

public class Doctor {

    String DoctorName, Experience, Speciality;
    public Doctor(){}
    public Doctor(String doctorName, String experience, String speciality) {
        DoctorName = doctorName;
        Experience = experience;
        Speciality = speciality;
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        DoctorName = doctorName;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

}
