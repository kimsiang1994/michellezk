package com.pm.general.manager;

import com.pm.general.entity.EmployeeEntity;
import com.pm.general.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeManager {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findByUniqueId(id);
    }

    public void saveEmployee(EmployeeEntity employeeEntity){
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}
