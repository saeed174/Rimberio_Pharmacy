module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.persistence;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires java.naming;
    opens org.example to javafx.fxml;
    exports org.example;
}
