package lk.pasindu.employee_save.service;

import lk.pasindu.employee_save.dto.EmployeeDto;

import java.util.ArrayList;

public interface EmployeeService {
    boolean saveEmployee(EmployeeDto employeeDto);
    boolean updateEmployee(EmployeeDto employeeDto);
    boolean deleteEmployee(int idNo);
    ArrayList<EmployeeDto> getAllEmployee();
}
