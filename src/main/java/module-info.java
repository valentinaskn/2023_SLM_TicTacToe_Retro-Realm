module com.retrorealm.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.retrorealm.tictactoe to javafx.fxml;
    exports com.retrorealm.tictactoe;
}