package com.ali.learnandroid.Models;

public class ListRowData {
    private String imgProfile, Name, Age, Job;

    public ListRowData(String imgProfile, String name, String age, String job) {
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

