package com.ali.learnandroid.Models;

public class RecyclerRowData {
    private String imgProfile, Name, Age, Job;

    public RecyclerRowData(String imgProfile, String name, String age, String job) {
        this.imgProfile = imgProfile;
        Name = name;
        Age = age;
        Job = job;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getJob() {
        return Job;
    }
}
