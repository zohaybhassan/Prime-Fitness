module sdaproject {
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.sql;

	opens application to javafx.fxml;
	exports application to javafx.graphics;
	opens db to javafx.fxml;
}