module com.example.sd2_cw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sd2_cw to javafx.fxml;
    exports com.example.sd2_cw;
}