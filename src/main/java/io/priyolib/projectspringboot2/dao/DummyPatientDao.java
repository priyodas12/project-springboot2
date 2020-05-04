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
        listOfPatient.remove(firstPatientByName.get());
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
      /* return return selectById(id).map(p -> {
            int index = listOfPatient.indexOf(p);
            if (index >= 0) {
                listOfPatient.set(index, p);
                return 1;
            }
            return 0;
        }).orElse(0);*/
        Optional<Patient> updatePatientByName=selectById(id);
        if(updatePatientByName.isEmpty()){
            log.info("no patient found");
            return 0;
        }
        Patient p=updatePatientByName.get();
        log.info("got object..{}",p.getName());
        int index=listOfPatient.indexOf(p);
        listOfPatient.set(index,new Patient(id,patient.getName()));
        log.info("update object with ..{}",patient.getName());
        return 1;
    }


}
