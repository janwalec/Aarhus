module org.example.test_jar_file {
    requires javafx.controls;
    requires javafx.fxml;
    requires my.database;

    opens org.example.test_jar_file to javafx.fxml;
    exports org.example.test_jar_file;
}