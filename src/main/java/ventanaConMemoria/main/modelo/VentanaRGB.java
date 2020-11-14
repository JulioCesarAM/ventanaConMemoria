package ventanaConMemoria.main.modelo;

import javafx.beans.property.SimpleDoubleProperty;

public class VentanaRGB {
	private SimpleDoubleProperty fondoRojo;
	private SimpleDoubleProperty fondoVerde;
	private SimpleDoubleProperty  fondoAzul;
	public VentanaRGB() {
		fondoRojo  = new SimpleDoubleProperty();
		fondoVerde = new SimpleDoubleProperty();
		fondoAzul  = new SimpleDoubleProperty();
	}
	public SimpleDoubleProperty fondoRojoProperty() {
		return this.fondoRojo;
	}
	
	public double getFondoRojo() {
		return this.fondoRojoProperty().get();
	}
	
	public void setFondoRojo(final double fondoRojo) {
		this.fondoRojoProperty().set(fondoRojo);
	}
	
	public SimpleDoubleProperty fondoVerdeProperty() {
		return this.fondoVerde;
	}
	
	public double getFondoVerde() {
		return this.fondoVerdeProperty().get();
	}
	
	public void setFondoVerde(final double fondoVerde) {
		this.fondoVerdeProperty().set(fondoVerde);
	}
	
	public SimpleDoubleProperty fondoAzulProperty() {
		return this.fondoAzul;
	}
	
	public double getFondoAzul() {
		return this.fondoAzulProperty().get();
	}
	
	public void setFondoAzul(final double fondoAzul) {
		this.fondoAzulProperty().set(fondoAzul);
	}
	
	
	
	
	
	
}

