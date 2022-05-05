package com.notablehealth.notablehealth.Controller;

import com.notablehealth.notablehealth.Model.Appointment;
import com.notablehealth.notablehealth.Model.Doctor;
import com.notablehealth.notablehealth.Service.CalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotableHealthCalendarController {

    CalendarService calendarService = new CalendarService();

    @GetMapping("/getDoctors")
    public List<Doctor> getDoctors(){
        return calendarService.getDoctors();
    }

    @GetMapping("/getAppointments")
    public List<Appointment> getAppointments(){
        return calendarService.getAppointments();
    }

    @GetMapping("/getAppointmentsByDoctorAndDate")
    public List<Appointment> getAppointmentsByDoctorAndDate(@RequestParam String doctorId, @RequestParam String date){
        return calendarService.getAppointmentsByDoctorAndDate(doctorId, date);
    }

    @DeleteMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam String appointmentId){
        return calendarService.deleteAppointment(appointmentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addAppointment")
    public String addAppointment(@RequestBody Appointment appointment){
        return calendarService.addAppointment(appointment);
    }
}
