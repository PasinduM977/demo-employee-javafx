package lk.pasindu.employee_save.service.impl;

import lk.pasindu.employee_save.db.DataBase;
import lk.pasindu.employee_save.dto.EmployeeDto;
import lk.pasindu.employee_save.entity.Employee;
import lk.pasindu.employee_save.service.EmployeeService;

import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public boolean saveEmployee(EmployeeDto employeeDto) {

        DataBase.employees.add(new Employee(employeeDto.getIdNo(),employeeDto.getName(),employeeDto.getAddress(),employeeDto.getPosition()));
        return true;
    }

    @Override
    public boolean updateEmployee(EmployeeDto employeeDto) {

        for (Employee e:DataBase.employees)
        {
            if (e.getIdNo()==employeeDto.getIdNo())
            {
                e.setName(employeeDto.getName());
                e.setAddress(employeeDto.getAddress());
                e.setPosition(employeeDto.getPosition());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int idNo) {
        for (int i=0;i<DataBase.employees.size();i++)
        {
            if (DataBase.employees.get(i).getIdNo()==idNo)
            {
                DataBase.employees.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<EmployeeDto> getAllEmployee() {
        ArrayList<EmployeeDto> allEmployee=new ArrayList<>();
        for (Employee e:DataBase.employees)
        {
            allEmployee.add(new EmployeeDto(e.getIdNo(),e.getName(),e.getAddress(), e.getPosition()));
        }
        return allEmployee;
    }
}
