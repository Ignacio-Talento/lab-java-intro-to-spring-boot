package com.labs.lab402.controller.impl;

import com.labs.lab402.controller.interfaces.IPatientController;
import com.labs.lab402.model.Employee;
import com.labs.lab402.model.Patient;
import com.labs.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    };

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/patients/dob")
    public List<Patient> getPatientsByDateOfBirthRange(@PathVariable String start, String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Patient> patients = patientRepository.findByDateOfBirthBetween(startDate, endDate);
        return patients;
    }

    @GetMapping("/patients/admitted-by/department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        List<Patient> patients = patientRepository.findByAdmittedBy_Department(department);
        return patients;
    }

    @GetMapping("/parients/admitted-by/status/OFF")
    public List<Patient> getPatientsByDoctorStatusOFF(@PathVariable String status) {
        List<Patient> patients = patientRepository.findByAdmittedBy_Status("OFF");
        return patients;
    }






}
