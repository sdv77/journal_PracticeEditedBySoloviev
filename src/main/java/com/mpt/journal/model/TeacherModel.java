package com.mpt.journal.model;

public class TeacherModel {
    private int Id;
    private String Name;
    private String LastName;
    private String FirstName;
    private String MiddleName;

    public TeacherModel(int id, String name, String lastName, String firstName, String middleName) {
        Id = id;
        Name = name;
        LastName = lastName;
        FirstName = firstName;
        MiddleName = middleName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

}
