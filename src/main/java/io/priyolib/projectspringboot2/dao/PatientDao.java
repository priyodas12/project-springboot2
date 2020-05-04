package io.priyolib.projectspringboot2.dao;

import io.priyolib.projectspringboot2.model.Patient;

import java.util.UUID;

public interface PatientDao {

    int registerPatient(UUID id, Patient patient);

    default int insertPatient(Patient patient) {
        UUID id=UUID.randomUUID();
        return registerPatient(id,patient);
    }
}
