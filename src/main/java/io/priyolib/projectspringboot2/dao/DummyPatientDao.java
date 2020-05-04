package io.priyolib.projectspringboot2.dao;

import io.priyolib.projectspringboot2.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    @Override
    public List<Patient> selectAllPatient() {
        log.info("selectAllPatient() @Repository called..");
        return listOfPatient;
    }

    @Override
    public int deletePatientRecord(UUID id) {
        log.info("deletePatientRecord() @Repository called..");
        Optional<Patient> firstPatientByName=selectById(id);
        if(firstPatientByName.isEmpty()){
            return 0;
        }
        listOfPatient.remove(firstPatientByName);
        return 1;
    }

    @Override
    public Optional<Patient> selectById(UUID id) {
        log.info("selectById() @Repository called..");
        return listOfPatient.stream().filter(patient -> patient.getId().equals(id)).findFirst();
    }

    @Override
    public int updateById(UUID id, Patient patient) {
        log.info("updateById() @Repository called..");
        Optional<Patient> updatePatientByName=selectById(id);
        if(updatePatientByName.isEmpty()){
            return 0;
        }
        int index = listOfPatient.indexOf(updatePatientByName);
        listOfPatient.set(index,patient);
        return 1;
    }


}
