package io.priyolib.projectspringboot2.dao;

import io.priyolib.projectspringboot2.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository("dummyDAO")
public class DummyPatientDao  implements PatientDao{
    //demo storage
    private static List<Patient> listOfPatient=new ArrayList<>();

    //methods
    @Override
    public int registerPatient(UUID id, Patient patient) {
        log.info("addPatient() @Repository called for {}",patient.getId());
        listOfPatient.add(new Patient(id,patient.getName()));
        return 1;
    }
}
