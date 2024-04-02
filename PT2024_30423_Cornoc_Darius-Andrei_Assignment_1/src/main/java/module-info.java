module com.example.pt2024_30423_cornoc_dariusandrei_assignment_1 {
    requires javafx.controls;
    requires javafx.fxml;


    //opens com.example.pt2024_30423_cornoc_dariusandrei_assignment_1 to javafx.fxml;
    exports com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Graphical_user_interface;
    opens com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Graphical_user_interface to javafx.fxml;
    exports com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models;
    opens com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Data_Models to javafx.fxml;
    exports com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Business_logic;
    opens com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Business_logic to javafx.fxml;
}