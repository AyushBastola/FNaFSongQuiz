module com.example.fnafquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.fnafquiz to javafx.fxml;
    exports com.example.fnafquiz;
}