package com.test.miniproject1;

import androidx.annotation.NonNull;

import java.util.Locale;

public class User {
    private String firstName;
    private String lastName;
    private String gender;
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User(String firstName, String lastName, String gender, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
    }

    public String fullName() {
        return String.format("%s %s", firstName, lastName);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("%s\n%s\n %s\n %s",
                getFirstName(),
                getLastName(),
                gender.equals("male") ? "♂" : "♀",
                city);

    }
}
