package com.notablehealth.notablehealth.Model;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Appointment {

    private String id;
    private String doctorId;
    private String date;
    private String time;
    private String patientFirstName;
    private String patientLastName;
    private String description;

    private Date dateTime;

//    @Required
//    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
//    public String date = simpleDateFormat.format(new Date());
//
//    @Required
//    public SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm");
//    public String time = simpleTimeFormat.format(new Date());Date

    public Appointment() {
    }

    public Appointment(String id, String doctorId, String date, String time, String patientFirstName, String patientLastName, String description) {
        this.id = id;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getDescription() {
        return description;
    }
}
