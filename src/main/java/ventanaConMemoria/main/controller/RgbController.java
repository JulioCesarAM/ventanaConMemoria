package ventanaConMemoria.main.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import ventanaConMemoria.main.modelo.VentanaRGB;

public class RgbController implements Initializable{
	@FXML
	private AnchorPane view;
	@FXML
	private Label redLabel, greenLabel, blueLabel;
	@FXML
	private Slider redSlider, greenSlider, blueSlider;
	private VentanaRGB modeloRGB = new VentanaRGB();

	public RgbController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vista.fxml"));
		loader.setController(this);
		loader.load();
	}

	public AnchorPane getAnchorPane() {
		return view;
	}

	public Slider getRedSlider() {
		return redSlider;
	}
 
	public void setRedSlider(Slider redSlider) {
		this.redSlider = redSlider;
	}

	public Slider getGreenSlider() {
		return greenSlider;
	}

	public void setGreenSlider(Slider greenSlider) {
		this.greenSlider = greenSlider;
	}

	public Slider getBlueSlider() {
		return blueSlider;
	}

	public void setBlueSlider(Slider blueSlider) {
		this.blueSlider = blueSlider;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		redSlider.valueProperty().bindBidirectional(modeloRGB.fondoRojoProperty());
		blueSlider.valueProperty().bindBidirectional(modeloRGB.fondoAzulProperty());
		greenSlider.valueProperty().bindBidirectional(modeloRGB.fondoVerdeProperty());
		//jugada maestra
		view.styleProperty().bind(Bindings.createStringBinding(
			()->{
				System.out.println(blueSlider.valueProperty().get());
				return "-fx-background-color: rgb("+ 
						modeloRGB.getFondoRojo() +","
						+modeloRGB.getFondoVerde()+","
						+modeloRGB.getFondoAzul()
						+");";
						
				},
				modeloRGB.fondoRojoProperty(),
				modeloRGB.fondoAzulProperty(),
				modeloRGB.fondoVerdeProperty())
				);
	}

}
