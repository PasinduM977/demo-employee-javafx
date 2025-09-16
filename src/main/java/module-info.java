module lk.pasindu.employee_save {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.pasindu.employee_save to javafx.fxml;
    exports lk.pasindu.employee_save;
    exports lk.pasindu.employee_save.controller;
    opens lk.pasindu.employee_save.controller to javafx.fxml;
}