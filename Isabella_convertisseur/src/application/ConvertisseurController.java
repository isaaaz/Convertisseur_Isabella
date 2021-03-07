/*
 * Author: Isabella Zhang 
 * Date: 6-Mar-2021
 * Nom de programme: Convertisseur d'unités
 * Description: une application java qui permet la conversion entre les unités impériales, métriques et les unités coutumières des États-Unis
*/

package application;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConvertisseurController implements Initializable{

    @FXML
    private ComboBox<String> cbolong2;

    @FXML
    private ComboBox<String> cbovol1;

    @FXML
    private ComboBox<String> cbomasse1;

    @FXML
    private ComboBox<String> cbolong1;

    @FXML
    private ComboBox<String> cbovol2;

    @FXML
    private ComboBox<String> cbomasse2;

    @FXML
    private TextField txtvol1;

    @FXML
    private TextField txtmasse1;

    @FXML
    private TextField txtvol2;

    @FXML
    private TextField txtmasse2;

    @FXML
    private TextField txtlong1;

    @FXML
    private TextField txtlong2;

    @FXML
    private ComboBox<String> cbotemps1;

    @FXML
    private ComboBox<String> cbotemps2;

    @FXML
    private TextField txttemps1;

    @FXML
    private TextField txttemps2;

    @FXML
    private Button butquit;
    
    @FXML
    private Button butquit1;
    
    @FXML
    private Button butquit2;
    
    @FXML
    private Button butquit3;
    
    @FXML
    private Button butquit4;

    
    // Pour les longueurs 
    
    private ObservableList<String> listLong = (ObservableList<String>) FXCollections.observableArrayList("Pouce","Pied","Yard","Mile");
    
    double [] longueur = {39370.1, 3280.84, 1093.61, 0.621371};
    
    private ObservableList<String> listLong2 = (ObservableList<String>) FXCollections.observableArrayList("Millimètre","Centimètre","Décimètre","Mètre", "Kilomètre");
    
    double [] longueur2 = {1000000.0, 100000.0, 10000.0, 1000.0, 1.0};
    

    // Pour les volumes
    
    private ObservableList<String> listVol = (ObservableList<String>) FXCollections.observableArrayList("Tasse","Pinte","Quart", "Gallon");
    
    double [] volume = {3.5195 ,1.7597, 0.879877, 0.219969};
    
    private ObservableList<String> listVol2 = (ObservableList<String>) FXCollections.observableArrayList("Millilitre","Litre");
    
    double [] volume2 = {1000.0, 1.0};
    
    
    // Pour le temps 
    
    private ObservableList<String> listTemps = (ObservableList<String>) FXCollections.observableArrayList("Seconde", "Minute","Heure");
    
    double [] temps = {3600.0 ,60.0, 1.0};

    
    // Pour les masses
    
    private ObservableList<String> listMasse = (ObservableList<String>) FXCollections.observableArrayList("Once","Livre");
    
    double [] masse = {35.274, 2.20462};
    
    private ObservableList<String> listMasse2 = (ObservableList<String>) FXCollections.observableArrayList("Milligramme","Gramme","Kilogramme");
    
    double [] masse2 = {1000000, 1000, 1};
     
    
    
    public void initialize(URL location, ResourceBundle resources)
    {
    	// Créer les comboBox pour les longueurs
    	cbolong1.setItems(listLong);
    	cbolong2.setItems(listLong2);
    	cbolong1.getSelectionModel().selectFirst();
    	cbolong2.getSelectionModel().selectFirst();
    	
    	// Créer les comboBox pour les volumes
    	cbovol1.setItems(listVol);
    	cbovol2.setItems(listVol2);
    	cbovol1.getSelectionModel().selectFirst();
    	cbovol2.getSelectionModel().selectFirst();
    	
    	// Créer les comboBox pour le temps
    	cbotemps1.setItems(listTemps);
    	cbotemps2.setItems(listTemps);
    	cbotemps1.getSelectionModel().selectFirst();
    	cbotemps2.getSelectionModel().selectFirst();
    	
    	// Créer les comboBox pour les masses
    	cbomasse1.setItems(listMasse);
    	cbomasse2.setItems(listMasse2);
    	cbomasse1.getSelectionModel().selectFirst();
    	cbomasse2.getSelectionModel().selectFirst();
    	
    }
    
    
    // Convertir d'unités des longueurs 
    
    @FXML
    void calLong1()
    {
    	convertir(txtlong1,txtlong2,cbolong1,cbolong2,longueur,longueur2);
    }
    
	@FXML
	void calLong2()
	{
		convertir(txtlong2,txtlong1,cbolong2,cbolong1,longueur2,longueur);
	}
	
	
	// Convertir d'unités des volumes 
	
    @FXML
    void calVol1()
    {
    	convertir(txtvol1,txtvol2,cbovol1,cbovol2,volume,volume2);
    }

	@FXML
	void calVol2()
	{
		convertir(txtvol2,txtvol1,cbovol2,cbovol1,volume2,volume);
	}
	
	
	// Convertir d'unités du temps
	
    @FXML
    void calTemps()
    {
    	convertirSingle(txttemps1,txttemps2,cbotemps1,cbotemps2,temps);
    }
    
    @FXML
    void calTemps2()
    {
    	convertirSingle(txttemps2,txttemps1,cbotemps2,cbotemps1,temps);
    }
	
	
	
	//Convertir d'unités des masses
	
    @FXML
    void calMasse1()
    {
    	convertir(txtmasse1,txtmasse2,cbomasse1,cbomasse2,masse,masse2);
    }

	@FXML
	void calMasse2()
	{
		convertir(txtmasse2,txtmasse1,cbomasse2,cbomasse1,masse2,masse);
	}
	
	
	
	
	// Méthode pour convertir d'unités d'un système à l'autre 

	public void convertir(TextField txtA,TextField txtB,ComboBox boxA, ComboBox boxB, double [] tab, double [] tab2) 
	{
		verifNum(txtA);
		
		int item1 = boxA.getSelectionModel().getSelectedIndex();
		int item2 = boxB.getSelectionModel().getSelectedIndex();
		double taux = tab2[item2]/tab[item1];
		double res = taux*(Double.parseDouble(txtA.getText()));
		txtB.setText(Double.toString(res));
		
	}
	
	
	// Méthode pour convertir d'unités dans un seul système
	
	public void convertirSingle (TextField txtA,TextField txtB,ComboBox boxA, ComboBox boxB, double [] tab) 
	{
		verifNum(txtA);
		
		int item1 = boxA.getSelectionModel().getSelectedIndex();
		int item2 = boxB.getSelectionModel().getSelectedIndex();
		double taux = tab[item2]/tab[item1];
		double res = taux*(Double.parseDouble(txtA.getText()));
		txtB.setText(Double.toString(res));
	}
	
	
	// Pour le système accepte des caractères numériques seulement 
	
	public void verifNum(TextField a)
	{
		if(a.getText().equals("")) a.setText("0");
		a.textProperty().addListener((observable,oldValue,newValue)->
		{
			if(!newValue.matches("^[0-9](\\.[0-9]+)?$"))
			{
				a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
			}
		});
	}
	

	// Pour quitter l'application
	
	@FXML
	void quitter() 
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Attention");
		alert.setTitle("Confirmation");
		alert.setContentText("Voulez-vous quitter l'application ?");
		Optional<ButtonType> result=alert.showAndWait();
		if(result.get()==ButtonType.OK)
		{
			System.exit(0);
		}
	}


	
}