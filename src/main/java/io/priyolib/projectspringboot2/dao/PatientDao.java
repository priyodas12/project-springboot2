package io.priyolib.projectspringboot2.dao;

import io.priyolib.projectspringboot2.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientDao {

    //register by Id,Name
    int registerPatient(UUID id, Patient patient);

    //register by Name
    default int insertPatient(Patient patient) {
        UUID id=UUID.randomUUID();
        return registerPatient(id,patient);
    }

    //get all patient info
    List<Patient> selectAllPatient();

    //delete by Id
    public int deletePatientRecord(UUID id);

    //find by Id
    Optional<Patient> selectById(UUID id);

    //update by Id
    public int updateById(UUID id,Patient patient);
}
