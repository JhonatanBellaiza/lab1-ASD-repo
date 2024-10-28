module com.miu.lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.miu.lab1 to javafx.fxml;
    exports com.miu.lab1;
}