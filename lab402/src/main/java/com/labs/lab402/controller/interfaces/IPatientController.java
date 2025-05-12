package com.labs.lab402.controller.interfaces;

import com.labs.lab402.model.Patient;

import java.util.List;

public interface IPatientController {
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    List<Patient> getPatientsByDateOfBirthRange(String start, String end);
    List<Patient> getPatientsByDoctorDepartment(String department);
    List<Patient> getPatientsByDoctorStatusOFF(String status);
}
