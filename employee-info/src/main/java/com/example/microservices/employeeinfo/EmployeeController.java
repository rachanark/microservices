package com.example.microservices.employeeinfo;

import com.example.microservices.employeeinfo.model.Employee;
import com.example.microservices.employeeinfo.model.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    Map<Integer,String> employeeInfo=new HashMap<>();
    EmployeeController(){
        employeeInfo.put(1,"Andy");
        employeeInfo.put(2,"April");
        employeeInfo.put(3,"Ron");
        employeeInfo.put(4,"Leslie");
        employeeInfo.put(5,"Ben");
        employeeInfo.put(6,"Donna");
        employeeInfo.put(7,"Ann");
        employeeInfo.put(8,"Tom");
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int empId){
        String employeeName=employeeInfo.get(empId);
        if(employeeName==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Employee employee=new Employee();
        employee.setName(employeeName);
        PersonalData data=restTemplate.getForObject("http://person-service/person/"+employeeName,PersonalData.class);
        employee.setPersonalData(data);
        employee.setDepartment("Parks and Recreations");
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
