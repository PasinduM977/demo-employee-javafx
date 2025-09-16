package lk.pasindu.employee_save.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.pasindu.employee_save.dto.EmployeeDto;
import lk.pasindu.employee_save.service.EmployeeService;
import lk.pasindu.employee_save.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;

public class EmployeeFormController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPosition;

    EmployeeService service=new EmployeeServiceImpl();

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        boolean isSaved=service.saveEmployee(new EmployeeDto(Integer.parseInt(txtID.getText()),txtName.getText(),txtAddress.getText(),txtPosition.getText()));

        if (isSaved)
        {
            System.out.println("Employee saved...");
        }
        clearFileds();
    }



    public void btnUpdateOnAction(ActionEvent actionEvent) {
        boolean isUpdated=service.updateEmployee(new EmployeeDto(Integer.parseInt(txtID.getText()),txtName.getText(),txtAddress.getText(),txtPosition.getText()));
        if (isUpdated)
        {
            System.out.println("Employee Updated!");
        }

        else
        {
            System.out.println("Employee not found!!!");
        }
        clearFileds();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean isDelete=service.deleteEmployee(Integer.parseInt(txtID.getText()));
        if (isDelete)
        {
            System.out.println("Employee Deleted!");
        }

        else
        {
            System.out.println("Employee not found!!!");
        }
        clearFileds();

    }

    public void btnGetAllOnAction(ActionEvent actionEvent) {
        ArrayList<EmployeeDto> employees = service.getAllEmployee();

        if (employees.size()>0)
        {
            for(EmployeeDto e:employees)
            {
                System.out.println("ID : "+e.getIdNo()+" Name : "+e.getName()+" Address : "+e.getAddress()+" Position : "+e.getPosition());
            }
        }
        else
            System.out.println("No Employees saved yet!!!");

        clearFileds();

    }
    private void clearFileds() {
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtPosition.clear();

    }
}
