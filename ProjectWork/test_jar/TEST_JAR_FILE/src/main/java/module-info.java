module org.example.test_jar_file {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.persistence;
    requires java.transaction;
    requires java.sql;
    requires org.hibernate.orm.core; // Include Hibernate dependency if needed
    opens org.database to org.hibernate.orm.core; // Open your package to Hibernate


    opens org.example.test_jar_file to javafx.fxml;
    exports org.example.test_jar_file;
}