package io.priyolib.projectspringboot2.api;

import io.priyolib.projectspringboot2.model.Patient;
import io.priyolib.projectspringboot2.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    //get by Id
    @GetMapping("/account/{id}")
    public Patient getPersonById(@PathVariable("id") UUID id){
        log.info("getPersonById() @Controller called...got {}",id);
        return patientService.selectById(id).orElse(null);
    }

    //delete by Id
    @DeleteMapping("/account/{id}")
    public void deleteById(@PathVariable("id") UUID id){
        log.info("deleteById() @Controller called...deleted {}",id);
        patientService.deleteById(id);
    }

    //update by Id
    @PutMapping("/account/{id}")
    public void updateById(@PathVariable("id") UUID id,@RequestBody Patient patient){
        log.info("updateById() @Controller called...updated {}",id);
        patientService.updateById(id,patient);
    }
}
