package ventanaConMemoria.main.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ventanaConMemoria.main.controller.RgbController;

public class App extends Application {

	String ruta = System.getProperty("user.home") + File.separator + ".VentanaConMemoria";
	String rutaConfig = ruta + File.separator + "ventana.config";
	
	private SimpleDoubleProperty width = new SimpleDoubleProperty();
	private SimpleDoubleProperty height = new SimpleDoubleProperty();
	private SimpleDoubleProperty locationX = new SimpleDoubleProperty();
	private SimpleDoubleProperty locationY = new SimpleDoubleProperty();
	private double auxRojo,auxVerde,auxAzul,auxWidth,auxHeight,auxX,auxY;
	private boolean inicio=false;
	RgbController ventaController;
	Scene sceneRGB;
	Stage stageRGB;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
				
		ventaController = new RgbController();
		sceneRGB= new Scene(ventaController.getAnchorPane(), 400, 400);
		stageRGB = new Stage();
		locationX.bind(stageRGB.xProperty());
		locationY.bind(stageRGB.yProperty());
		width.bind(stageRGB.widthProperty());
		height.bind(stageRGB.heightProperty());
		if (inicio==true)
			ficheroInicio();
		stageRGB.setScene(sceneRGB);
		stageRGB.show();
		
		
	}

	private void ficheroInicio() {
		stageRGB.setWidth(auxWidth);
		stageRGB.setHeight(auxHeight);
		stageRGB.setX(auxX);
		stageRGB.setY(auxY);	
		ventaController.getRedSlider().valueProperty().set(auxRojo);
		ventaController.getGreenSlider().valueProperty().set(auxVerde);
		ventaController.getBlueSlider().valueProperty().set(auxAzul);
	
	}

	@Override
	public void init() throws IOException {}{
		System.out.println("entrando");
		try (InputStream input = new FileInputStream(rutaConfig)) {
			System.out.println("dentro");
			Properties lectorEntrada = new Properties();
          if (input==null)
        	  System.out.println("sin archivo de configuracion inicial");
          else {
        	  lectorEntrada.load(input);
        	  auxRojo=Double.parseDouble(lectorEntrada.getProperty("background.red="));
        	  auxVerde=Double.parseDouble(lectorEntrada.getProperty("background.verde="));
        	  auxAzul=Double.parseDouble(lectorEntrada.getProperty("background.azul="));
        	  auxWidth=Double.parseDouble(lectorEntrada.getProperty("size.width="));
        	  auxHeight=Double.parseDouble(lectorEntrada.getProperty("size.height="));
        	  auxX=Double.parseDouble(lectorEntrada.getProperty("location.x="));
        	  auxY=Double.parseDouble(lectorEntrada.getProperty("location.y="));
        	  inicio=true;
          }


        } catch (Exception e) {
           System.out.println(e);
        }
	}
    

	

	@Override
	public void stop() throws IOException {
			File directorio = new File(ruta);
			directorio.mkdir();
			File propertiesConfig = new File(rutaConfig);
			propertiesConfig.createNewFile();

		try (OutputStream output = new FileOutputStream(propertiesConfig.getPath())) {
			Properties salidaDatosFichero = new Properties();
			// set the properties value
			salidaDatosFichero.setProperty("background.red=", ventaController.getRedSlider().valueProperty().get() + "");
			salidaDatosFichero.setProperty("background.verde=", ventaController.getGreenSlider().valueProperty().get() + "");
			salidaDatosFichero.setProperty("background.azul=", ventaController.getBlueSlider().valueProperty().get() + "");
			salidaDatosFichero.setProperty("size.width=", width.get() + "");
			salidaDatosFichero.setProperty("size.height=", height.get() + "");
			salidaDatosFichero.setProperty("location.x=", locationX.get() + "");
			salidaDatosFichero.setProperty("location.y=", locationY.get() + "");
			// save properties to project root folder
			salidaDatosFichero.store(output, null);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		launch(args);

	}

}
