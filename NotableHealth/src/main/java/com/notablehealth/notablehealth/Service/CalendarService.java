package com.notablehealth.notablehealth.Service;

import com.notablehealth.notablehealth.Model.Appointment;
import com.notablehealth.notablehealth.Model.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CalendarService {
    private List<Doctor> doctors = new ArrayList<>(Arrays.asList(new Doctor("1001", "Pooja", "Seth"),
            new Doctor("2001", "Snehal", "Vantashala"),
            new Doctor("3001","Jahnavi", "Seth")));

    private List<Appointment> appointments = new ArrayList<>(Arrays.asList(
            new Appointment("1", "1001", "01/01/2001", "8:15AM", "Mark", "Smith", "Regular checkup"),
            new Appointment("2", "2001", "01/02/2001", "8:30AM", "Mark", "Smith", "Regular checkup"),
            new Appointment("3", "3001", "01/03/2001", "8:45PM", "Mark", "Smith", "Regular checkup"),
            new Appointment("4", "1001", "01/01/2001", "8:15AM", "Mark", "Smith", "Regular checkup"),
            new Appointment("5", "1001", "01/01/2001", "8:15AM", "Mark", "Smith", "Regular checkup")));


    public List<Doctor> getDoctors(){
        return doctors;
    }

    public List<Appointment> getAppointments(){
        return appointments;
    }

    public List<Appointment> getAppointmentsByDoctorAndDate(String doctorId, String appointmentDate){
        List<Appointment> selectedAppointment = new ArrayList<>();
        for(Appointment appointment: appointments){
            if(appointment.getDoctorId().equals(doctorId) && appointment.getDate().equals(appointmentDate)){
                selectedAppointment.add(appointment);
            }
        }
        return selectedAppointment;
    }

    public String deleteAppointment(String appointmentId){
        appointments.removeIf(app -> app.getId().equals(appointmentId));
        return "Appointment is deleted.";
    }

    public String addAppointment(Appointment appointment){
        if(validTimeInterval(appointment.getTime())) {
            int count = 0;

            for (Appointment app : appointments) {
                if (app.getDoctorId() == appointment.getDoctorId() && app.getDate() == appointment.getDate()
                        && app.getTime() == appointment.getTime()) {
                    count++;
                }
            }
            if (count > 3) {
                return "Appointment can't be added.";
            } else {
                appointments.add(appointment);
                return "Appointment has been confirmed.";
            }
        }
        return "Appointment can't be added. Time should be multiple of 15";
    }

    private boolean validTimeInterval(String time){
        time = time.split(":")[1];
        time = time.substring(0,2);

        return Integer.parseInt(time)%15 == 0;
    }
}
