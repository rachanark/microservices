package com.example.microservices.personinfo;

import com.example.microservices.personinfo.model.PersonalData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    Map<String,PersonalData> personInfo =new HashMap<>();
    PersonController(){
        personInfo.put("Andy",new PersonalData("03/09/1994",25,"Minnesota"));
        personInfo.put("April",new PersonalData("18/08/1998",21,"Colombo"));
        personInfo.put("Ron", new PersonalData("24/11/1980",38,"Indiana"));
        personInfo.put("Leslie", new PersonalData("20/09/1986",32,"Pawanee"));
        personInfo.put("Ben", new PersonalData("15/10/1985",33,"California"));
        personInfo.put("Donna", new PersonalData("12/09/1982",36,"Cincinnati"));
        personInfo.put("Ann", new PersonalData("24/07/1990",29,"Georgia"));
        personInfo.put("Tom", new PersonalData("18/11/1983",35,"India"));
    }


    @RequestMapping("{name}")
    public ResponseEntity<PersonalData> getPersonalData(@PathVariable("name") String name){
             PersonalData personalData=personInfo.get(name);
             if(personalData==null)
                 new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             return new ResponseEntity<>(personalData,HttpStatus.OK);
    }
}
