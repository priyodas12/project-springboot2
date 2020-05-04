package io.priyolib.projectspringboot2.api;

import io.priyolib.projectspringboot2.model.Patient;
import io.priyolib.projectspringboot2.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/global/regdesk")
public class PatientResourceController {
    //field
    private final PatientService patientService;

    //constructor
    @Autowired
    public PatientResourceController(PatientService patientService) {
        this.patientService = patientService;
    }
    //controllerMethod
    @PostMapping("/account")
    public void addPatient(@RequestBody Patient patent){
        log.info("addPatient() @Controller called for {}",patent.getId());
        patientService.addPatient(patent);
    }

    //get all resource
    @GetMapping("/accounts")
    public List<Patient> getAllPatient(){
        log.info("getAllPatient() @Controller called...");
        return patientService.getAllPatientInfo();
    }
}
