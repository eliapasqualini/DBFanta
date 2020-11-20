package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import db.AttaccanteTable;
import db.CalciatoreTable;
import db.CampionatoTable;
import db.CentrocampistaTable;
import db.DifensoreTable;
import db.FantaAllenatoriTable;
import db.FantaFormazioneTable;
import db.FantaPartiteTable;
import db.FantaSquadreTable;
import db.GiornataTable;
import db.LegheTable;
import db.PartecipazioneTable;
import db.PortiereTable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Calciatore;
import model.FantaAllenatore;
import model.FantaSquadra;

public class CreazioneLegaScreenController {
    
    
    
    private final FXEnvironment environment;
    
    @FXML
    private ComboBox<String> boxRuolo, boxSquadra, boxCampionato;
    
    @FXML
    private Button btnInserisci, btnRimuovi;
    
    @FXML
    private VBox boxMercato;
    
    @FXML
    private TextField textLega, textNomeAllenatore1, textNomeAllenatore2, textNomeAllenatore3, textNomeAllenatore4, textNomeAllenatore5, textNomeAllenatore6, textNomeAllenatore7, textNomeAllenatore8;
    
    @FXML
    private TextField textCognomeAllenatore1, textCognomeAllenatore2, textCognomeAllenatore3, textCognomeAllenatore4, textCognomeAllenatore5, textCognomeAllenatore6, textCognomeAllenatore7, textCognomeAllenatore8;
    
    @FXML
    private TextField textSquadra1, textSquadra2, textSquadra3, textSquadra4, textSquadra5, textSquadra6, textSquadra7, textSquadra8; 
    
    @FXML
    private TableView<Calciatore> tableCalciatori, tableCalciatoriRosa;
    

    List<Calciatore> scelti = new ArrayList<>();
    
    
    
    public CreazioneLegaScreenController(final FXEnvironment environment) {
        super();
        this.environment = environment;
        this.environment.loadScreen(FXMLScreens.CREAZIONE, this);
    }
    
    /**
     * 
     */
    @FXML
    public void initialize() {
    	
    	CampionatoTable cat = new CampionatoTable();
        
        //inizializzo la combobox dei ruoli
        this.boxRuolo.getItems().addAll("Portiere","Difensore","Centrocampista","Attaccante");
        
        //inizializzo la combobox dei campionati
        this.boxCampionato.getItems().addAll(cat.selectCampionati());
      
        //inizializzo le table dei calciatori forse da mettere nel bottone crea lega
        final TableColumn<Calciatore, String> nomeCalciatoreCol = new TableColumn<>("Nome");
        nomeCalciatoreCol.setCellValueFactory(
                new PropertyValueFactory<Calciatore, String>("nome")
        );
        final TableColumn<Calciatore, String> cognomeCalciatoreCol = new TableColumn<>("Cognome");
        cognomeCalciatoreCol.setCellValueFactory(
                new PropertyValueFactory<Calciatore, String>("cognome")
        );
        final TableColumn<Calciatore, String> squadraCol = new TableColumn<>("Squadra");
        squadraCol.setCellValueFactory(
                new PropertyValueFactory<Calciatore, String>("squadra")
        );
        final TableColumn<Calciatore, String> ruoloCol = new TableColumn<>("Ruolo");
        ruoloCol.setCellValueFactory(
                new PropertyValueFactory<Calciatore, String>("ruolo")
        );
        /*
        this.tableCalciatoriRose.getColumns().addAll(nomeCalciatoreCol, cognomeCalciatoreCol,squadraCol,ruoloCol);
        this.tableCalciatori.getColumns().addAll(nomeCalciatoreCol, cognomeCalciatoreCol,squadraCol,ruoloCol);
        */
        
    }
    
    
    /**
     * 
     */
    @FXML
    public void tornaMain() {
        
        //Elimino la Lega?
        
        this.environment.displayScreen(FXMLScreens.MAIN);
    }
    
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @FXML
    public void creaLega() {
    	boolean a = true;
    	boolean b = true;
    	boolean c = true;
    	String s1, s2, s3, s4, s5, s6, s7, s8;
     	LegheTable lt = new LegheTable();
     	CampionatoTable ct = new CampionatoTable();
     	FantaAllenatoriTable fat = new FantaAllenatoriTable();
     	FantaSquadreTable fst = new FantaSquadreTable();
     	List<String> fantaSquadre = new LinkedList<>();
     	PartecipazioneTable pt = new PartecipazioneTable();
     	GiornataTable gt = new GiornataTable();
     	FantaFormazioneTable fft = new FantaFormazioneTable();
     	FantaPartiteTable fpt = new FantaPartiteTable();
          	
        //controllo che il nome della lega non esista già
     	if (lt.selectLegheName() != null) {
     		for (String s : lt.selectLegheName()) {
        		if (textLega.getText().equals(s)) {
        			a = false;
        		}
        	}
     	}
        
        //controllo sui nomi delle fantaSquadre
        fantaSquadre.add(textSquadra1.getText());
        fantaSquadre.add(textSquadra2.getText());
        fantaSquadre.add(textSquadra3.getText());
        fantaSquadre.add(textSquadra4.getText());
        fantaSquadre.add(textSquadra5.getText());
        fantaSquadre.add(textSquadra6.getText());
        fantaSquadre.add(textSquadra7.getText());
        fantaSquadre.add(textSquadra8.getText());
        
        fantaSquadre.remove(textSquadra1.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra1.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra1.getText());
        
        fantaSquadre.remove(textSquadra2.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra2.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra2.getText());
        
        fantaSquadre.remove(textSquadra3.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra3.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra3.getText());
        
        fantaSquadre.remove(textSquadra4.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra4.getText() == s){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra4.getText());
        
        fantaSquadre.remove(textSquadra5.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra5.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra6.getText());
        
        fantaSquadre.remove(textSquadra6.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra1.getText() == s){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra6.getText());
        
        fantaSquadre.remove(textSquadra7.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra7.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra7.getText());
        
        fantaSquadre.remove(textSquadra8.getText());
        for (String s : fantaSquadre) {
        	if (textSquadra8.getText().equals(s)){
        		b = false;
        	}
        }
        fantaSquadre.add(textSquadra8.getText());
        
        
                
       // rendo visibile la vbox mercato solo se ho inserito tutti i dati       
        if (textNomeAllenatore1.getText() != null
        	&& textNomeAllenatore2.getText() != null 
        	&& textNomeAllenatore3.getText() != null
        	&& textNomeAllenatore4.getText() != null
        	&& textNomeAllenatore5.getText() != null
        	&& textNomeAllenatore6.getText() != null
        	&& textNomeAllenatore7.getText() != null
        	&& textNomeAllenatore8.getText() != null
        	&& a
        	&& b
        	&& textCognomeAllenatore1.getText() != null
            && textCognomeAllenatore2.getText() != null
        	&& textCognomeAllenatore3.getText() != null
        	&& textCognomeAllenatore4.getText() != null
        	&& textCognomeAllenatore5.getText() != null
        	&& textCognomeAllenatore6.getText() != null
        	&& textCognomeAllenatore7.getText() != null
        	&& textCognomeAllenatore8.getText() != null
        	&& textSquadra1.getText() != null
        	&& textSquadra2.getText() != null
        	&& textSquadra3.getText() != null
        	&& textSquadra4.getText() != null
        	&& textSquadra5.getText() != null
        	&& textSquadra6.getText() != null
        	&& textSquadra7.getText() != null
        	&& textSquadra8.getText() != null
        	&& boxCampionato.getSelectionModel().getSelectedItem() != null) {
        	
                //crea lega       	
        	int idCampionato = ct.selectIDCampionato(boxCampionato.getSelectionModel().getSelectedItem());
        	lt.insertLega(textLega.getText(), idCampionato);
        	this.boxMercato.setVisible(true);
        	
            //Devo controllare se esistono già Fanta-Allenatori con lo stesso nome e cognome non lo aggiungo.
        	if (fat.selectFantaAllenatori() != null) {
            for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore1.getText().equals(f.getNome()) && textCognomeAllenatore1.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
            } 
        	}
            if (c) {
    	        	//crea allenatore
            		fat.insertFantaAllenatore(textNomeAllenatore1.getText(), textCognomeAllenatore1.getText());
    	        }        	
            c = true;
            
            for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore2.getText().equals(f.getNome()) && textCognomeAllenatore2.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
            }
            if (c) {
    	        	//crea allenatore
        		fat.insertFantaAllenatore(textNomeAllenatore2.getText(), textCognomeAllenatore2.getText());
    	        }        
            c = true;
            for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore3.getText().equals(f.getNome()) && textCognomeAllenatore3.getText().equals(f.getCognome())) {
    	        	c = false;
    	        }
    	    }
    	    if (c) {
    	        	//crea allenatore	
        		fat.insertFantaAllenatore(textNomeAllenatore3.getText(), textCognomeAllenatore3.getText());
    	        }
    	    	c = true;
    	    for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore4.getText().equals(f.getNome()) && textCognomeAllenatore4.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
    	    }
    	    if (c) {
    	    	//crea allenatore
        		fat.insertFantaAllenatore(textNomeAllenatore4.getText(), textCognomeAllenatore4.getText());
    	    }
    	    c = true;

    	    for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore5.getText().equals(f.getNome()) && textCognomeAllenatore5.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
    	    }
    	    if (c) {
    	    	//crea allenatore	
        		fat.insertFantaAllenatore(textNomeAllenatore5.getText(), textCognomeAllenatore5.getText());
    	    }
    	    c = true;

    	    for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore6.getText().equals(f.getNome()) && textCognomeAllenatore6.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
    	    }
    	    if (c) {
    	    	//crea allenatore	    
        		fat.insertFantaAllenatore(textNomeAllenatore6.getText(), textCognomeAllenatore6.getText());
    	    }
    	    c = true;

    	    for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore7.getText().equals(f.getNome()) && textCognomeAllenatore7.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
    	    }
    	    if (c) {
    	    	//crea allenatore
        		fat.insertFantaAllenatore(textNomeAllenatore7.getText(), textCognomeAllenatore7.getText());
    	    }
    	    c = true;
    	    
    	    for (FantaAllenatore f : fat.selectFantaAllenatori()) {
    	        if (textNomeAllenatore8.getText().equals(f.getNome()) && textCognomeAllenatore8.getText().equals(f.getCognome())) {
    	        	c = false;
    	        } 
    	    }
    	    if (c) {
    	    	//creo allenatore
        		fat.insertFantaAllenatore(textNomeAllenatore8.getText(), textCognomeAllenatore8.getText());
        	}
            
            //quando clicco il bottone conferma devo inserire Partecipazionix8, FantaSquadrex8.

    	    int idLega = lt.selectIDLega(textLega.getText());
    	    int idAllenatore1 = fat.selectIdAllenatore(textNomeAllenatore1.getText(), textCognomeAllenatore1.getText());
    	    int idAllenatore2 = fat.selectIdAllenatore(textNomeAllenatore2.getText(), textCognomeAllenatore2.getText());
    	    int idAllenatore3 = fat.selectIdAllenatore(textNomeAllenatore3.getText(), textCognomeAllenatore3.getText());
    	    int idAllenatore4 = fat.selectIdAllenatore(textNomeAllenatore4.getText(), textCognomeAllenatore4.getText());
    	    int idAllenatore5 = fat.selectIdAllenatore(textNomeAllenatore5.getText(), textCognomeAllenatore5.getText());
    	    int idAllenatore6 = fat.selectIdAllenatore(textNomeAllenatore6.getText(), textCognomeAllenatore6.getText());
    	    int idAllenatore7 = fat.selectIdAllenatore(textNomeAllenatore7.getText(), textCognomeAllenatore7.getText());
    	    int idAllenatore8 = fat.selectIdAllenatore(textNomeAllenatore8.getText(), textCognomeAllenatore8.getText());
    	   
    	    //inserimento partecipazioni
    	    pt.insertLega(idAllenatore1, idLega);
    	    pt.insertLega(idAllenatore2, idLega);
    	    pt.insertLega(idAllenatore3, idLega);
    	    pt.insertLega(idAllenatore4, idLega);
    	    pt.insertLega(idAllenatore5, idLega);
    	    pt.insertLega(idAllenatore6, idLega);
    	    pt.insertLega(idAllenatore7, idLega);
    	    pt.insertLega(idAllenatore8, idLega);
    	    
    	    //inserimento squadre
    	    fst.insertFantaSquadra(textSquadra1.getText(), idAllenatore1, idLega);
    	    fst.insertFantaSquadra(textSquadra2.getText(), idAllenatore2, idLega);
    	    fst.insertFantaSquadra(textSquadra3.getText(), idAllenatore3, idLega);
    	    fst.insertFantaSquadra(textSquadra4.getText(), idAllenatore4, idLega);
    	    fst.insertFantaSquadra(textSquadra5.getText(), idAllenatore5, idLega);
    	    fst.insertFantaSquadra(textSquadra6.getText(), idAllenatore6, idLega);
    	    fst.insertFantaSquadra(textSquadra7.getText(), idAllenatore7, idLega);
    	    fst.insertFantaSquadra(textSquadra8.getText(), idAllenatore8, idLega);
            //pulisco la box delle squadre 
    	    this.boxSquadra.getItems().clear();
            //alla fine inizializzo la combobox delle fantasquadre (query)
          for (FantaSquadra f : fst.selectNameFantaSquadre(textLega.getText())) {
              this.boxSquadra.getItems().add(f.getNome());
          } 
          
          s1 = textSquadra1.getText();
          s2 = textSquadra2.getText();
          s3 = textSquadra3.getText();
          s4 = textSquadra4.getText();
          s5 = textSquadra5.getText();
          s6 = textSquadra6.getText();
          s7 = textSquadra7.getText();
          s8 = textSquadra8.getText();
          
          //pulire tabella calciatori e ripopolarla (chiedere per come fare con le colonne)
          this.tableCalciatori.getItems().clear();
          this.tableCalciatoriRosa.getItems().clear();
          
          //pulisco i calciatori scelti
          scelti.clear();
          
          
          
          
          
          //creo le fanta-formazioni
          for (Integer i : gt.selectGiornate()) {
        	  fft.insertFormazione(s1, i);
        	  fft.insertFormazione(s2, i);
        	  fft.insertFormazione(s3, i);
        	  fft.insertFormazione(s4, i);
        	  fft.insertFormazione(s5, i);
        	  fft.insertFormazione(s6, i);
        	  fft.insertFormazione(s7, i);
        	  fft.insertFormazione(s8, i);
          }
          
          
          //creo le fanta-partite
          //1,15,29
          for (int i = 1; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s1, i);
        	  int formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s1, s2, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s3, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s5, s6, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s7, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s7, s8, i, formC, formT);
          }
          
          //giornate 2,16,30
          for (int i = 2; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s8, i);
        	  int formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s8, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s2, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s4, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s6, s7, i, formC, formT);
          }
          
          //giornate 3,17,31
          for (int i = 3; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s1, i);
        	  int formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s1, s6, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s3, s8, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s5, s2, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s7, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s7, s4, i, formC, formT);
          }
          
          //giornate 4,18,32
          for (int i = 4; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s4, i);
        	  int formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s4, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s6, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s8, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s2, s7, i, formC, formT);
          }
          
          //giornate 5,19,33
          for (int i = 5; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s1, i);
        	  int formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s1, s7, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s3, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s6, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s2, s8, i, formC, formT);
          }
          
          //giornate 6,20,34
          for (int i = 6; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s7, i);
        	  int formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s7, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s5, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s4, s2, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s8, s6, i, formC, formT);
          }
          
          //giornate 7,21,35
          for (int i = 7; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s5, i);
        	  int formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s5, s7, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s3, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s8, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s2, s6, i, formC, formT);
          }
          
        //8,22,36
          for (int i = 8; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s2, i);
        	  int formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s2, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s4, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s6, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s8, s7, i, formC, formT);
          }
          
          //giornate 9,23,37
          for (int i = 9; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s1, i);
        	  int formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s1, s8, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s3, s2, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s5, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s7, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s7, s6, i, formC, formT);
          }
          
          //giornate 10,24,38
          for (int i = 10; i <= 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s6, i);
        	  int formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s6, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s8, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s2, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s4, s7, i, formC, formT);
          }
          
          //giornate 11,25
          for (int i = 11; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s1, i);
        	  int formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s1, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s3, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s3, s6, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s5, s8, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s7, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s7, s2, i, formC, formT);
          }
          
          //giornate 12,26
          for (int i = 12; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s7, i);
        	  int formT = fft.selectIdFantaFormazione(s1, i);
        	  fpt.insertFantaPartita(s7, s1, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s5, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s5, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s6, i);
        	  fpt.insertFantaPartita(s4, s6, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s8, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s8, s2, i, formC, formT);
          }
          
          //giornate 13,27
          for (int i = 13; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s3, i);
        	  int formT = fft.selectIdFantaFormazione(s7, i);
        	  fpt.insertFantaPartita(s3, s7, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s1, i);
        	  formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s1, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s2, i);
        	  formT = fft.selectIdFantaFormazione(s4, i);
        	  fpt.insertFantaPartita(s2, s4, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s6, s8, i, formC, formT);
        	    
          }
          
        //giornate 14,28
          for (int i = 14; i < 38; i=i+14) {
        	  int formC = fft.selectIdFantaFormazione(s7, i);
        	  int formT = fft.selectIdFantaFormazione(s5, i);
        	  fpt.insertFantaPartita(s7, s5, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s1, i);
        	  formT = fft.selectIdFantaFormazione(s3, i);
        	  fpt.insertFantaPartita(s1, s3, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s4, i);
        	  formT = fft.selectIdFantaFormazione(s8, i);
        	  fpt.insertFantaPartita(s4, s8, i, formC, formT);
        	  
        	  formC = fft.selectIdFantaFormazione(s6, i);
        	  formT = fft.selectIdFantaFormazione(s2, i);
        	  fpt.insertFantaPartita(s6, s2, i, formC, formT);
          }
          
          final TableColumn<Calciatore, String> nomeCalciatoreCol = new TableColumn<>("Nome");
          nomeCalciatoreCol.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("nome")
          );
          final TableColumn<Calciatore, String> cognomeCalciatoreCol = new TableColumn<>("Cognome");
          cognomeCalciatoreCol.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("cognome")
          );
          final TableColumn<Calciatore, String> squadraCol = new TableColumn<>("Squadra");
          squadraCol.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("squadra")
          );
          final TableColumn<Calciatore, String> ruoloCol = new TableColumn<>("Ruolo");
          ruoloCol.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("ruolo")
          );
          
          this.tableCalciatoriRosa.getColumns().addAll(nomeCalciatoreCol, cognomeCalciatoreCol,squadraCol,ruoloCol);
          
          final TableColumn<Calciatore, String> nomeCalciatore2Col = new TableColumn<>("Nome");
          nomeCalciatore2Col.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("nome")
          );
          final TableColumn<Calciatore, String> cognomeCalciatore2Col = new TableColumn<>("Cognome");
          cognomeCalciatore2Col.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("cognome")
          );
          final TableColumn<Calciatore, String> squadra2Col = new TableColumn<>("Squadra");
          squadra2Col.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("squadra")
          );
          final TableColumn<Calciatore, String> ruolo2Col = new TableColumn<>("Ruolo");
          ruolo2Col.setCellValueFactory(
                  new PropertyValueFactory<Calciatore, String>("ruolo")
          );
          this.tableCalciatori.getColumns().addAll(nomeCalciatore2Col, cognomeCalciatore2Col,squadra2Col,ruolo2Col);
                              
        	
        } else {
        	//parte alert
                final Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setHeaderText("Errore nell'inserimento dei campi, riprova!");
                alert.showAndWait();
              
        }
        
    }
    
    
    /**
     * 
     */
    @FXML
    public void cambioRuolo(ActionEvent event) {
        //è cambiato il ruolo nella combobox devo aggiornare la lista dei calciatori nella tabella sotto
        this.tableCalciatori.getItems().clear();
        CalciatoreTable ct = new CalciatoreTable();
        //query che restituisce una lista di calciatori
        List<Calciatore> calciatori = new LinkedList<>();
        List<Calciatore> sceltiruolo = new LinkedList<>();
        List<Calciatore> rosa = new ArrayList<>();
        List<Calciatore> rosaruolo = new ArrayList<>();
        
        sceltiruolo.clear();
        rosa.clear();
        rosaruolo.clear();
        //ripopolo la table di sinistra senza quelli scelti
        String ruolo = this.boxRuolo.getSelectionModel().getSelectedItem();
        rosa = this.tableCalciatoriRosa.getItems();
        calciatori.addAll(ct.selectAll(ruolo));
        
        for(Calciatore c : scelti) {
            if(c.getRuolo().equals(ruolo)) {
                sceltiruolo.add(c);
            }
        }
        for(Calciatore c : rosa) {
            if(c.getRuolo().equals(ruolo)) {
                rosaruolo.add(c);
            }
        }
        

        calciatori.removeAll(rosaruolo);
        
        calciatori.removeAll(sceltiruolo);
        
        this.tableCalciatori.getItems().addAll(FXCollections.observableArrayList(calciatori));
        
    }
    
    /**
     * 
     */
    @FXML
    public void inserisciCalciatori() {
        List<Calciatore> calciatori = new ArrayList<>();
        AttaccanteTable at = new AttaccanteTable();
        CentrocampistaTable ct = new CentrocampistaTable();
        DifensoreTable dt = new DifensoreTable();
        PortiereTable pt = new PortiereTable();
        LegheTable lt = new LegheTable();
        String squadra = this.boxSquadra.getSelectionModel().getSelectedItem();
        calciatori.clear();
        calciatori.addAll(this.tableCalciatoriRosa.getItems());
        String ruolo;
        Integer p = 0, d = 0, c = 0, a = 0;
        //Data la FantaSquadra(presa dalla combobox), idCalciatore(query che prende l'id del calciatore di riferimento) e la FantaLega (combobox?) 
        //Inserisci gli elementi della tabella di destra e controlla che il numero dei ruoli sia corretto?
        
        for(Calciatore calciatore : calciatori) {
            ruolo = calciatore.getRuolo();
            if(ruolo.equals("Portiere")) {
                p ++;
                
            }else if (ruolo.equals("Difensore")) {
                d ++;
            } else if (ruolo.equals("Centrocampista")) {
                c ++;
            } else {
                a ++;
            }
        }

        if (p == 3 && d == 8 && c == 8 && a == 6) {
            //inserimento corretto metto i miei calciatori nella lista dei calciatori scelti 
            this.tableCalciatoriRosa.getItems().clear();
            this.tableCalciatori.getItems().clear();
            scelti.addAll(calciatori);
            this.boxSquadra.getItems().remove(this.boxSquadra.getSelectionModel().getSelectedIndex());
            int idLega = lt.selectIDLega(this.textLega.getText());
            //per ogni calciatore controllo il ruolo 
            for(Calciatore calciatore : calciatori) {
                ruolo = calciatore.getRuolo();
                if(ruolo.equals("Portiere")) {
                    //inserisco nei portieri
                   pt.insertPortiereRosa(idLega, calciatore.getCalciatore(), squadra);
                   
                }else if (ruolo.equals("Difensore")) {
                    //inserisco nei difensori
                	
                    dt.insertDifensoreRosa(idLega, calciatore.getCalciatore(), squadra);
                    
                } else if (ruolo.equals("Centrocampista")) {
                    //inserisco nei centrocampisti
                	
                    ct.insertCentrocampistaRosa(idLega, calciatore.getCalciatore(), squadra);
                    
                } else {
                    //inserisco in attaccanti
                    at.insertAttaccanteRosa(idLega, calciatore.getCalciatore(), squadra);
                }
            }
            
        } else {
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Errore nell'inserimento della rosa, controlla i ruoli!");
            alert.showAndWait();
        }
        
        //elimina dalla tabella di destra
    }
    
    
    /**
     * 
     */
    @FXML
    public void cambioSquadra(ActionEvent event) {
        //è cambiato la squadra nella combobox devo aggiornare la lista dei calciatori nella tabella sotto
        this.btnInserisci.setDisable(false);
        this.btnRimuovi.setDisable(false);
        List<Calciatore> calciatori = new ArrayList<>();
        List<Calciatore> sceltiruolo = new ArrayList<>();
        sceltiruolo.clear();
        CalciatoreTable ct = new CalciatoreTable();
        //pulisco la lista
        this.tableCalciatori.getItems().clear();
        this.tableCalciatoriRosa.getItems().clear();
        
      //ripopolo la table di sinistra senza quelli scelti
        String ruolo = this.boxRuolo.getSelectionModel().getSelectedItem();
        calciatori.addAll(ct.selectAll(ruolo));
        
        for(Calciatore c : scelti) {
            if(c.getRuolo().equals(ruolo)) {
                sceltiruolo.add(c);
            }
        }
        calciatori.removeAll(sceltiruolo);
        this.tableCalciatori.getItems().addAll(FXCollections.observableArrayList(calciatori));
        
        
        //faccio la query con la nuova squadra per ripopolarla
        
        
        
    }
    
    
    /**
     * 
     */
    @FXML 
    public void inserisciTabella() {
        
        if(this.tableCalciatori.getSelectionModel().getSelectedItem() != null) {
            this.tableCalciatoriRosa.getItems().add(this.tableCalciatori.getSelectionModel().getSelectedItem());
            this.tableCalciatori.getItems().remove(this.tableCalciatori.getSelectionModel().getSelectedIndex());
        }
        
        
        
    }
    
    /**
     * 
     */
    @FXML
    public void rimuoviTabella() {
        
        if(this.tableCalciatoriRosa.getSelectionModel().getSelectedItem() != null) {
            this.tableCalciatoriRosa.getItems().remove(this.tableCalciatoriRosa.getSelectionModel().getSelectedIndex());
            if(this.tableCalciatoriRosa.getSelectionModel().getSelectedItem().getRuolo().equals(this.boxRuolo)) {
                this.tableCalciatori.getItems().add(this.tableCalciatoriRosa.getSelectionModel().getSelectedItem());
            }
            
            
        }
        
        
    }
    
    @FXML
    public void salva() {

    	if (this.boxSquadra.getItems().size() == 0) {
            this.environment.displayScreen(FXMLScreens.MAIN);
    	} else {
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Errore, completa l'inserimento della rosa");
            alert.showAndWait();
    	}      
        
    }
    
    
    /**
     * Show the current view.
     */
    public void show() {
        this.environment.displayScreen(FXMLScreens.CREAZIONE);
    }

}
