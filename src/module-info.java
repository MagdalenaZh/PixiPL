module HelloFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.prefs;
	
	opens application to javafx.graphics, javafx.fxml;
}
