package io.priyolib.projectspringboot2.service;

import io.priyolib.projectspringboot2.dao.PatientDao;
import io.priyolib.projectspringboot2.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientService {
    //fields
    private final PatientDao patientDao;

    //constructor
    @Autowired
    public PatientService(@Qualifier("dummyDAO") PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    //overridden methods
    public int addPatient(Patient patient){
        log.info("addPatient() @Service called for {}",patient.getId());
        return patientDao.insertPatient(patient);
    }
}
