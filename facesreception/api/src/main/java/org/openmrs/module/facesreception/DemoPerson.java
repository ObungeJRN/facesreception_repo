package org.openmrs.module.facesreception;

import java.util.Date;

/**
 * Created by obungejrn on 3/10/17.
 */
public class DemoPerson {
    private int id;
    private String name;
    private Date DOB;
    private String gender;


    public DemoPerson() {
    }

    public DemoPerson(int id, String name, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.DOB = dob;
        this.gender=gender;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
