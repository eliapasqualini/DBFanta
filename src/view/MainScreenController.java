package view;
import java.util.ArrayList;
import java.util.List;

import db.AttaccanteTable;
import db.CalciatoreTable;
import db.CentrocampistaTable;
import db.ClassificaTable;
import db.DifensoreTable;
import db.FantaFormazioneTable;
import db.FantaPartiteTable;
import db.FantaSquadreTable;
import db.GiornataTable;
import db.LegheTable;
import db.PartiteTable;
import db.PortiereTable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.Calciatore;
import model.FantaPartita;
import model.FantaSquadra;
import model.Partita;

public class MainScreenController {
        

    private final FXEnvironment environment;
    private double punteggio1, punteggio2, punteggio21, punteggio211, punteggio2111, punteggio21111, punteggio21112, punteggio21113;
    private int gol1, gol2, gol21, gol211, gol2111, gol21111, gol21112, gol21113;
    private double f1S1, f2S1, f3S1, f4S1, f5S1, f6S1, f7S1, f8S1, f9S1, f10S1, f11S1;
    private double f1S2, f2S2, f3S2, f4S2, f5S2, f6S2, f7S2, f8S2, f9S2, f10S2, f11S2;
    private double f1S21, f2S21, f3S21, f4S21, f5S21, f6S21, f7S21, f8S21, f9S21, f10S21, f11S21;    
    private double f1S211, f2S211, f3S211, f4S211, f5S211, f6S211, f7S211, f8S211, f9S211, f10S211, f11S211;
    private double f1S2111, f2S2111, f3S2111, f4S2111, f5S2111, f6S2111, f7S2111, f8S2111, f9S2111, f10S2111, f11S2111;
    private double f1S21111, f2S21111, f3S21111, f4S21111, f5S21111, f6S21111, f7S21111, f8S21111, f9S21111, f10S21111, f11S21111;
    private double f1S21112, f2S21112, f3S21112, f4S21112, f5S21112, f6S21112, f7S21112, f8S21112, f9S21112, f10S21112, f11S21112;
    private double f1S21113, f2S21113, f3S21113, f4S21113, f5S21113, f6S21113, f7S21113, f8S21113, f9S21113, f10S21113, f11S21113;
    
    @FXML
    private Pane contentPane, paneFormazioni, paneVoti;
    
    
    @FXML
    private Button btnCrea, btnFantaPartite, btnPartite, btnClassifica;    
    
    @FXML
    private TableView<FantaSquadra> tableClassifica;
    
    @FXML
    private TableView<Calciatore> tableCalciatoriRosa, tableCalciatoriFormazione;
    
    @FXML
    private TableView<Partita> tablePartite;
    
    @FXML
    private TableView<FantaPartita> tableFantaPartite;
      
    @FXML
    private ComboBox<Integer> boxGiornate;
    
    @FXML
    private ComboBox<String> boxLeghe, boxSquadre;
    
    @FXML
    private Tab tabS1, tabS2, tabS3, tabS4, tabS5, tabS6, tabS7, tabS8;
    
    @FXML
    private TextField P1S1, D1S1, D2S1, D3S1, D4S1, C1S1, C2S1, C3S1, A1S1, A2S1, A3S1;
    
    @FXML
    private TextField P1S2, D1S2, D2S2, D3S2, D4S2, C1S2, C2S2, C3S2, A1S2, A2S2, A3S2;
    
    @FXML
    private TextField P1S3, D1S3, D2S3, D3S3, D4S3, C1S3, C2S3, C3S3, A1S3, A2S3, A3S3;
    
    @FXML
    private TextField P1S4, D1S4, D2S4, D3S4, D4S4, C1S4, C2S4, C3S4, A1S4, A2S4, A3S4;
    
    @FXML
    private TextField P1S5, D1S5, D2S5, D3S5, D4S5, C1S5, C2S5, C3S5, A1S5, A2S5, A3S5;
    
    @FXML
    private TextField P1S6, D1S6, D2S6, D3S6, D4S6, C1S6, C2S6, C3S6, A1S6, A2S6, A3S6;
    
    @FXML
    private TextField P1S7, D1S7, D2S7, D3S7, D4S7, C1S7, C2S7, C3S7, A1S7, A2S7, A3S7;
    
    @FXML
    private TextField P1S8, D1S8, D2S8, D3S8, D4S8, C1S8, C2S8, C3S8, A1S8, A2S8, A3S8;

    @FXML
    private TextField vP1S1, vD1S1, vD2S1, vD3S1, vD4S1, vC1S1, vC2S1, vC3S1, vA1S1, vA2S1, vA3S1;
    
    @FXML
    private TextField gfP1S1, gfD1S1, gfD2S1, gfD3S1, gfD4S1, gfC1S1, gfC2S1, gfC3S1, gfA1S1, gfA2S1, gfA3S1;
    
    @FXML
    private TextField gsP1S1, gsD1S1, gsD2S1, gsD3S1, gsD4S1, gsC1S1, gsC2S1, gsC3S1, gsA1S1, gsA2S1, gsA3S1;
    
    @FXML
    private TextField aP1S1, aD1S1, aD2S1, aD3S1, aD4S1, aC1S1, aC2S1, aC3S1, aA1S1, aA2S1, aA3S1;
    
    @FXML
    private TextField cgP1S1, cgD1S1, cgD2S1, cgD3S1, cgD4S1, cgC1S1, cgC2S1, cgC3S1, cgA1S1, cgA2S1, cgA3S1;
    
    @FXML
    private TextField crP1S1, crD1S1, crD2S1, crD3S1, crD4S1, crC1S1, crC2S1, crC3S1, crA1S1, crA2S1, crA3S1;
    
    @FXML
    private TextField vP1S2, vD1S2, vD2S2, vD3S2, vD4S2, vC1S2, vC2S2, vC3S2, vA1S2, vA2S2, vA3S2;
    
    @FXML
    private TextField gfP1S2, gfD1S2, gfD2S2, gfD3S2, gfD4S2, gfC1S2, gfC2S2, gfC3S2, gfA1S2, gfA2S2, gfA3S2;
    
    @FXML
    private TextField gsP1S2, gsD1S2, gsD2S2, gsD3S2, gsD4S2, gsC1S2, gsC2S2, gsC3S2, gsA1S2, gsA2S2, gsA3S2;
    
    @FXML
    private TextField aP1S2, aD1S2, aD2S2, aD3S2, aD4S2, aC1S2, aC2S2, aC3S2, aA1S2, aA2S2, aA3S2;
    
    @FXML
    private TextField cgP1S2, cgD1S2, cgD2S2, cgD3S2, cgD4S2, cgC1S2, cgC2S2, cgC3S2, cgA1S2, cgA2S2, cgA3S2;
    
    @FXML
    private TextField crP1S2, crD1S2, crD2S2, crD3S2, crD4S2, crC1S2, crC2S2, crC3S2, crA1S2, crA2S2, crA3S2;
    
    @FXML
    private TextField vP1S21, vD1S21, vD2S21, vD3S21, vD4S21, vC1S21, vC2S21, vC3S21, vA1S21, vA2S21, vA3S21;
    
    @FXML
    private TextField gfP1S21, gfD1S21, gfD2S21, gfD3S21, gfD4S21, gfC1S21, gfC2S21, gfC3S21, gfA1S21, gfA2S21, gfA3S21;
    
    @FXML
    private TextField gsP1S21, gsD1S21, gsD2S21, gsD3S21, gsD4S21, gsC1S21, gsC2S21, gsC3S21, gsA1S21, gsA2S21, gsA3S21;
    
    @FXML
    private TextField aP1S21, aD1S21, aD2S21, aD3S21, aD4S21, aC1S21, aC2S21, aC3S21, aA1S21, aA2S21, aA3S21;
    
    @FXML
    private TextField cgP1S21, cgD1S21, cgD2S21, cgD3S21, cgD4S21, cgC1S21, cgC2S21, cgC3S21, cgA1S21, cgA2S21, cgA3S21;
    
    @FXML
    private TextField crP1S21, crD1S21, crD2S21, crD3S21, crD4S21, crC1S21, crC2S21, crC3S21, crA1S21, crA2S21, crA3S21;
    
    @FXML
    private TextField vP1S211, vD1S211, vD2S211, vD3S211, vD4S211, vC1S211, vC2S211, vC3S211, vA1S211, vA2S211, vA3S211;
    
    @FXML
    private TextField gfP1S211, gfD1S211, gfD2S211, gfD3S211, gfD4S211, gfC1S211, gfC2S211, gfC3S211, gfA1S211, gfA2S211, gfA3S211;
    
    @FXML
    private TextField gsP1S211, gsD1S211, gsD2S211, gsD3S211, gsD4S211, gsC1S211, gsC2S211, gsC3S211, gsA1S211, gsA2S211, gsA3S211;
    
    @FXML
    private TextField aP1S211, aD1S211, aD2S211, aD3S211, aD4S211, aC1S211, aC2S211, aC3S211, aA1S211, aA2S211, aA3S211;
    
    @FXML
    private TextField cgP1S211, cgD1S211, cgD2S211, cgD3S211, cgD4S211, cgC1S211, cgC2S211, cgC3S211, cgA1S211, cgA2S211, cgA3S211;
    
    @FXML
    private TextField crP1S211, crD1S211, crD2S211, crD3S211, crD4S211, crC1S211, crC2S211, crC3S211, crA1S211, crA2S211, crA3S211;
    
    @FXML
    private TextField vP1S2111, vD1S2111, vD2S2111, vD3S2111, vD4S2111, vC1S2111, vC2S2111, vC3S2111, vA1S2111, vA2S2111, vA3S2111;
    
    @FXML
    private TextField gfP1S2111, gfD1S2111, gfD2S2111, gfD3S2111, gfD4S2111, gfC1S2111, gfC2S2111, gfC3S2111, gfA1S2111, gfA2S2111, gfA3S2111;
    
    @FXML
    private TextField gsP1S2111, gsD1S2111, gsD2S2111, gsD3S2111, gsD4S2111, gsC1S2111, gsC2S2111, gsC3S2111, gsA1S2111, gsA2S2111, gsA3S2111;
    
    @FXML
    private TextField aP1S2111, aD1S2111, aD2S2111, aD3S2111, aD4S2111, aC1S2111, aC2S2111, aC3S2111, aA1S2111, aA2S2111, aA3S2111;
    
    @FXML
    private TextField cgP1S2111, cgD1S2111, cgD2S2111, cgD3S2111, cgD4S2111, cgC1S2111, cgC2S2111, cgC3S2111, cgA1S2111, cgA2S2111, cgA3S2111;
    
    @FXML
    private TextField crP1S2111, crD1S2111, crD2S2111, crD3S2111, crD4S2111, crC1S2111, crC2S2111, crC3S2111, crA1S2111, crA2S2111, crA3S2111;
    
    @FXML
    private TextField vP1S21111, vD1S21111, vD2S21111, vD3S21111, vD4S21111, vC1S21111, vC2S21111, vC3S21111, vA1S21111, vA2S21111, vA3S21111;
    
    @FXML
    private TextField gfP1S21111, gfD1S21111, gfD2S21111, gfD3S21111, gfD4S21111, gfC1S21111, gfC2S21111, gfC3S21111, gfA1S21111, gfA2S21111, gfA3S21111;
    
    @FXML
    private TextField gsP1S21111, gsD1S21111, gsD2S21111, gsD3S21111, gsD4S21111, gsC1S21111, gsC2S21111, gsC3S21111, gsA1S21111, gsA2S21111, gsA3S21111;
    
    @FXML
    private TextField aP1S21111, aD1S21111, aD2S21111, aD3S21111, aD4S21111, aC1S21111, aC2S21111, aC3S21111, aA1S21111, aA2S21111, aA3S21111;
    
    @FXML
    private TextField cgP1S21111, cgD1S21111, cgD2S21111, cgD3S21111, cgD4S21111, cgC1S21111, cgC2S21111, cgC3S21111, cgA1S21111, cgA2S21111, cgA3S21111;
    
    @FXML
    private TextField crP1S21111, crD1S21111, crD2S21111, crD3S21111, crD4S21111, crC1S21111, crC2S21111, crC3S21111, crA1S21111, crA2S21111, crA3S21111;
    
    @FXML
    private TextField vP1S21112, vD1S21112, vD2S21112, vD3S21112, vD4S21112, vC1S21112, vC2S21112, vC3S21112, vA1S21112, vA2S21112, vA3S21112;
    
    @FXML
    private TextField gfP1S21112, gfD1S21112, gfD2S21112, gfD3S21112, gfD4S21112, gfC1S21112, gfC2S21112, gfC3S21112, gfA1S21112, gfA2S21112, gfA3S21112;
    
    @FXML
    private TextField gsP1S21112, gsD1S21112, gsD2S21112, gsD3S21112, gsD4S21112, gsC1S21112, gsC2S21112, gsC3S21112, gsA1S21112, gsA2S21112, gsA3S21112;
    
    @FXML
    private TextField aP1S21112, aD1S21112, aD2S21112, aD3S21112, aD4S21112, aC1S21112, aC2S21112, aC3S21112, aA1S21112, aA2S21112, aA3S21112;
    
    @FXML
    private TextField cgP1S21112, cgD1S21112, cgD2S21112, cgD3S21112, cgD4S21112, cgC1S21112, cgC2S21112, cgC3S21112, cgA1S21112, cgA2S21112, cgA3S21112;
    
    @FXML
    private TextField crP1S21112, crD1S21112, crD2S21112, crD3S21112, crD4S21112, crC1S21112, crC2S21112, crC3S21112, crA1S21112, crA2S21112, crA3S21112;
    
    @FXML
    private TextField vP1S21113, vD1S21113, vD2S21113, vD3S21113, vD4S21113, vC1S21113, vC2S21113, vC3S21113, vA1S21113, vA2S21113, vA3S21113;
    
    @FXML
    private TextField gfP1S21113, gfD1S21113, gfD2S21113, gfD3S21113, gfD4S21113, gfC1S21113, gfC2S21113, gfC3S21113, gfA1S21113, gfA2S21113, gfA3S21113;
    
    @FXML
    private TextField gsP1S21113, gsD1S21113, gsD2S21113, gsD3S21113, gsD4S21113, gsC1S21113, gsC2S21113, gsC3S21113, gsA1S21113, gsA2S21113, gsA3S21113;
    
    @FXML
    private TextField aP1S21113, aD1S21113, aD2S21113, aD3S21113, aD4S21113, aC1S21113, aC2S21113, aC3S21113, aA1S21113, aA2S21113, aA3S21113;
    
    @FXML
    private TextField cgP1S21113, cgD1S21113, cgD2S21113, cgD3S21113, cgD4S21113, cgC1S21113, cgC2S21113, cgC3S21113, cgA1S21113, cgA2S21113, cgA3S21113;
    
    @FXML
    private TextField crP1S21113, crD1S21113, crD2S21113, crD3S21113, crD4S21113, crC1S21113, crC2S21113, crC3S21113, crA1S21113, crA2S21113, crA3S21113;
    
    public MainScreenController(final FXEnvironment environment) {
        super();
        this.environment = environment;
        this.environment.loadScreen(FXMLScreens.MAIN, this);
    }

    
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        
        //inizializzo la table view per la classifica
        final TableColumn<FantaSquadra, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<FantaSquadra, String>("nome")
        );
        final TableColumn<FantaSquadra, Integer> giocateCol = new TableColumn<>("PG");
        giocateCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("partiteGiocate")
        );
        final TableColumn<FantaSquadra, Integer>  vittorieCol = new TableColumn<>("V");
        vittorieCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("vittorie")
        );
        final TableColumn<FantaSquadra, Integer> pareggiCol = new TableColumn<>("P");
        pareggiCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("pareggi")
            
        );
        final TableColumn<FantaSquadra, Integer> sconfitteCol = new TableColumn<>("S");
        sconfitteCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("sconfitte")
            
        );
        final TableColumn<FantaSquadra, Integer> puntiCol = new TableColumn<>("Punti");
        puntiCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("punti")
            
        );
        final TableColumn<FantaSquadra, Integer> punteggioCol = new TableColumn<>("Punteggio");
        punteggioCol.setCellValueFactory(
            new PropertyValueFactory<FantaSquadra, Integer>("punteggio")
            
        );
        this.tableClassifica.getColumns().addAll(nomeCol, giocateCol, vittorieCol, pareggiCol, sconfitteCol, puntiCol, punteggioCol);
        
        
        //inizializzo la tableview per le partite
        
        
        final TableColumn<Partita, String> squadracasaCol = new TableColumn<>("Squadra");
        squadracasaCol.setCellValueFactory(
                new PropertyValueFactory<Partita, String>("squadraCasa")
        );
        final TableColumn<Partita, String> squadratrasfertaCol = new TableColumn<>("Squadra");
        squadratrasfertaCol.setCellValueFactory(
            new PropertyValueFactory<Partita, String>("squadraTrasferta")
        );
        
        this.tablePartite.getColumns().addAll(squadracasaCol, squadratrasfertaCol);
        
        
        //inizializzo la tableview per le fantapartite
        final TableColumn<FantaPartita, String> fantasquadracasaCol = new TableColumn<>("Squadra");
        fantasquadracasaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, String>("fantaSquadraCasa")
        );
        final TableColumn<FantaPartita, Integer> golcasaCol = new TableColumn<>("Gol");
        golcasaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, Integer>("golCasa")
        );
        final TableColumn<FantaPartita, Double> punteggiocasaCol = new TableColumn<>("Punteggio");
        punteggiocasaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, Double>("punteggioCasa")
        );
        final TableColumn<FantaPartita, String> fantasquadratrasfertaCol = new TableColumn<>("Squadra");
        fantasquadratrasfertaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, String>("fantaSquadraTrasferta")
        );
        final TableColumn<FantaPartita, Integer> goltrasfertaCol = new TableColumn<>("Gol");
        goltrasfertaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, Integer>("golTrasferta")
        );
        final TableColumn<FantaPartita, Double> punteggiotrasfertaCol = new TableColumn<>("Punteggio");
        punteggiotrasfertaCol.setCellValueFactory(
                new PropertyValueFactory<FantaPartita, Double>("punteggioTrasferta")
        );
        this.tableFantaPartite.getColumns().addAll(fantasquadracasaCol,golcasaCol,punteggiocasaCol,fantasquadratrasfertaCol,goltrasfertaCol,punteggiotrasfertaCol);
    
        
        //inizializzo le tableview dei calciatori
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
        this.tableCalciatoriFormazione.getColumns().addAll(nomeCalciatore2Col, cognomeCalciatore2Col,squadra2Col,ruolo2Col);
        
        //inizializzo la combobox giornate (query)
        GiornataTable gt = new GiornataTable();
        for(Integer giornata : gt.selectGiornate()) {
            //giornate.add(g);
            this.boxGiornate.getItems().add(giornata);
        }
        
      //inizializzo la combobox leghe (query)
        
        LegheTable lt = new LegheTable();
        if (lt.selectLegheName() != null) {
        	for (String fantalega : lt.selectLegheName()) {
        		this.boxLeghe.getItems().add(fantalega);
        	}
        }
   
    }
    
    /**
     * 
     * @param event
     */
    @FXML
    public void cambioLega(ActionEvent event) {
        
        FantaSquadreTable fst = new FantaSquadreTable();
        LegheTable lt = new LegheTable();
        this.boxGiornate.setDisable(false);
        this.btnClassifica.setDisable(false);
        this.boxSquadre.getItems().clear();
        this.tableClassifica.getItems().clear();
        
        //aggiorno la combobx delle fantasquadre data la lega
    	String lega = this.boxLeghe.getSelectionModel().getSelectedItem();
    	
    	for (FantaSquadra fantasquadra : fst.selectNameFantaSquadre(lega)) {
            this.boxSquadre.getItems().add(fantasquadra.getNome());
    	}
    	
    	Integer idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
        Integer partite = fst.numeroPartiteGiocate(idLega);

        this.paneFormazioni.setVisible(false);
        if (this.boxGiornate.getSelectionModel().getSelectedItem() != null) {
        if (this.boxGiornate.getSelectionModel().getSelectedItem().equals(partite +1)) {
            this.paneFormazioni.setVisible(true);
        }
        }
    }
    
    
    @FXML
    public void aggiornaLega() {
        LegheTable lt = new LegheTable();
        this.boxLeghe.getItems().clear();
        if (lt.selectLegheName() != null) {
        for (String fantalega : lt.selectLegheName()) {
                this.boxLeghe.getItems().add(fantalega);
        }
        }
    }
    
    
    /**
     * 
     * @param event
     */
    @FXML
    public void cambioSquadra(ActionEvent event) {
        
        //pulisco le tabelle
        
        this.tableCalciatoriRosa.getItems().clear();
        this.tableCalciatoriFormazione.getItems().clear();
        
        LegheTable lt = new LegheTable();
        Integer idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
        String nome = this.boxSquadre.getSelectionModel().getSelectedItem();
        
        List<Integer> idcalciatori = new ArrayList<>();
        List<Calciatore> calciatori = new ArrayList<>();
        idcalciatori.clear();
        AttaccanteTable at = new AttaccanteTable();
        CentrocampistaTable ct = new CentrocampistaTable();
        DifensoreTable dt = new DifensoreTable();
        PortiereTable pt = new PortiereTable();
        CalciatoreTable calt = new CalciatoreTable();
        
        idcalciatori.addAll(at.selectIdCalciatore(nome, idLega));
        idcalciatori.addAll(ct.selectIdCalciatore(nome, idLega));
        idcalciatori.addAll(dt.selectIdCalciatore(nome, idLega));
        idcalciatori.addAll(pt.selectIdCalciatore(nome, idLega));
        
        //per ogni id del calciatore trovo il calciatore e lo metto nella lista di calciatori
        for(Integer id : idcalciatori) {
            calciatori.add(calt.selectCalciatori(id));            
        }
        this.tableCalciatoriRosa.getItems().addAll(FXCollections.observableArrayList(calciatori));
       
    }
    
    /**
     * 
     * @param event
     */
    @FXML
    public void cambioGiornata(ActionEvent event) {
        //disabiliti la parte destra
        
        
        LegheTable lt = new LegheTable();
        FantaSquadreTable fst = new FantaSquadreTable();
        this.tableFantaPartite.getItems().clear();
        this.tablePartite.getItems().clear();
        this.paneFormazioni.setVisible(false);
        this.btnFantaPartite.setDisable(false);
        this.btnPartite.setDisable(false);
        
        Integer idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
        Integer partite = fst.numeroPartiteGiocate(idLega);
        
        if (this.boxGiornate.getSelectionModel().getSelectedItem() - 1 == partite) {
            this.paneFormazioni.setVisible(true);
        } 

    }
    
    
    /**
     * 
     */
    @FXML
    public void visualizzaClassifica() {
        //visualizzo la classifica nella tabella o nella lista
        
        ClassificaTable ct = new ClassificaTable();
        LegheTable lt  = new LegheTable();
        Integer idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
        this.tableClassifica.getItems().clear();
        
        List<FantaSquadra> classifica = new ArrayList<>();
        
        classifica = ct.selectTable(idLega);
        
        this.tableClassifica.setItems(FXCollections.observableArrayList(classifica));
        
    }
    
    /**
     * 
     */
    @FXML
    public void visualizzaPartite() {
        // pulisco la tabella e visualizzo le partite di quella giornata
        
        this.tableFantaPartite.setVisible(false);
        this.tablePartite.setVisible(true);
        this.tablePartite.getItems().clear();
        
        PartiteTable pt = new PartiteTable();
        Integer numero = this.boxGiornate.getSelectionModel().getSelectedItem();
        
        List<Partita> partite = new ArrayList<>();
        partite = pt.selectPartite(numero);
        
        this.tablePartite.setItems(FXCollections.observableArrayList(partite));
        
    }
        
    
    /**
     * 
     */
    @FXML
    public void visualizzaFantaPartite() {
        //pulisco la tabella e visualizzo le fanta partite di quella giornata con anche gol e punteggio
        
        this.tablePartite.setVisible(false);
        this.tableFantaPartite.setVisible(true);
        this.tableFantaPartite.getItems().clear();
        
        FantaPartiteTable fpt = new FantaPartiteTable();
        LegheTable lt  = new LegheTable();
        Integer numero = this.boxGiornate.getSelectionModel().getSelectedItem();
        Integer idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
        List<FantaPartita> fantapartite = new ArrayList<>();
        fantapartite = fpt.selectFantaPartite(numero, idLega);
        
        this.tableFantaPartite.setItems(FXCollections.observableArrayList(fantapartite));
        
        
    }
    
    /**
     * 
     */
    @FXML
    public void inserisciFantaCalciatore() {
        
        if(this.tableCalciatoriRosa.getSelectionModel().getSelectedItem() != null) {
            this.tableCalciatoriFormazione.getItems().add(this.tableCalciatoriRosa.getSelectionModel().getSelectedItem());
            this.tableCalciatoriRosa.getItems().remove(this.tableCalciatoriRosa.getSelectionModel().getSelectedIndex());
        }
        
        
    }
    
    
    /**
     * 
     */
    @FXML
    public void rimuoviFantaCalciatore() {
        if(this.tableCalciatoriFormazione.getSelectionModel().getSelectedItem() != null) {
            this.tableCalciatoriRosa.getItems().add(this.tableCalciatoriFormazione.getSelectionModel().getSelectedItem());
            this.tableCalciatoriFormazione.getItems().remove(this.tableCalciatoriFormazione.getSelectionModel().getSelectedIndex());
        }
        
        // rimuovo da destra e aggiungo a sinistra
    }
    
    /**
     * 
     */
    @FXML
    public void confermaFormazione() {
        //controllo che in tabella  di destra ci siano 1 portiere 4 difensori 3 centrocampisti e 3 attaccanti 
        List<Calciatore> calciatori = new ArrayList<>();
        List<Integer> idFormazioni = new ArrayList<>();
        List<String> squadre = new ArrayList<>();
        PortiereTable pt = new PortiereTable();
        DifensoreTable dt = new DifensoreTable();
        CentrocampistaTable ct = new CentrocampistaTable();
        AttaccanteTable at = new AttaccanteTable();
        FantaFormazioneTable fft = new FantaFormazioneTable();
        Boolean pane = true;
        String ruolo;
        Integer p = 0, d = 0, c = 0, a = 0;
        calciatori = this.tableCalciatoriFormazione.getItems();
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
        
        if (p == 1 && d == 4 && c == 3 && a ==3) {
            //inserimento corretto 
            
            //prendo l'id della fanta-formazione di quella squadra in quella giornata se esiste già
        	 int formazione = fft.selectIdFantaFormazione(this.boxSquadre.getSelectionModel().getSelectedItem(), this.boxGiornate.getSelectionModel().getSelectedItem());	
            //elimino tutti gli inserimenti che hanno quell'id formazione
           fft.deleteAll(formazione); 
            //aggiungo i vari inserimenti con lo stesso id
           
            //per ogni calciatore controllo il ruolo 
            for(Calciatore calciatore : calciatori) {
                ruolo = calciatore.getRuolo();
                if(ruolo.equals("Portiere")) {
                    //inserisco nei portieri
                int id = pt.selectIdPortiere(this.boxSquadre.getSelectionModel().getSelectedItem(), calciatore.getCalciatore());
                pt.insertPortiereFantaFormazione(id, formazione);
                    
                }else if (ruolo.equals("Difensore")) {
                    //inserisco nei difensori
                	int id = dt.selectIdDifensore(this.boxSquadre.getSelectionModel().getSelectedItem(), calciatore.getCalciatore());
                    dt.insertDifensoreFantaFormazione(id, formazione);
                } else if (ruolo.equals("Centrocampista")) {
                    //inserisco nei centrocampisti
                	int id = ct.selectIdCentrocampista(this.boxSquadre.getSelectionModel().getSelectedItem(), calciatore.getCalciatore());
                    ct.insertCentrocampistaFantaFormazione(id, formazione);
                } else {
                    //inserisco in attaccanti
                	int id = at.selectIdAttaccante(this.boxSquadre.getSelectionModel().getSelectedItem(), calciatore.getCalciatore());
                	at.insertAttaccanteFantaFormazione(id, formazione);
                }
            }
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Formazione inserita correttamente!");
            alert.showAndWait();
            this.tableCalciatoriFormazione.getItems().clear();
            //rendi visibile pane sotto
            squadre.clear();
            idFormazioni.clear();
            squadre.add(this.boxSquadre.getItems().get(0));
            squadre.add(this.boxSquadre.getItems().get(1));
            squadre.add(this.boxSquadre.getItems().get(2));
            squadre.add(this.boxSquadre.getItems().get(3));
            squadre.add(this.boxSquadre.getItems().get(4));
            squadre.add(this.boxSquadre.getItems().get(5));
            squadre.add(this.boxSquadre.getItems().get(6));
            squadre.add(this.boxSquadre.getItems().get(7));
            for(String s : squadre) {
                idFormazioni.add(fft.selectIdFantaFormazione(s, this.boxGiornate.getSelectionModel().getSelectedItem()));
            }
            
            for(Integer id : idFormazioni) {
                if(!pt.selectNumOfInserimento(id).equals(1)) {
                    pane = false;
                }
            }
            if(pane) {

                this.tabS1.setText(this.boxSquadre.getItems().get(0));
                this.tabS2.setText(this.boxSquadre.getItems().get(1));
                this.tabS3.setText(this.boxSquadre.getItems().get(2));
                this.tabS4.setText(this.boxSquadre.getItems().get(3));
                this.tabS5.setText(this.boxSquadre.getItems().get(4));
                this.tabS6.setText(this.boxSquadre.getItems().get(5));
                this.tabS7.setText(this.boxSquadre.getItems().get(6));
                this.tabS8.setText(this.boxSquadre.getItems().get(7));
                
               	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(0),this.boxGiornate.getSelectionModel().getSelectedItem());	
               	 int i = pt.selectListFromInserimento(formazione).get(0);
                 this.P1S1.setText(pt.selectFromInserimento(i));
               	 i = dt.selectListFromInserimento(formazione).get(0);
                 this.D1S1.setText(dt.selectFromInserimento(i));
                 i = dt.selectListFromInserimento(formazione).get(1);
                 this.D2S1.setText(dt.selectFromInserimento(i));
                 i = dt.selectListFromInserimento(formazione).get(2);
                 this.D3S1.setText(dt.selectFromInserimento(i));
                 i = dt.selectListFromInserimento(formazione).get(3);
                 this.D4S1.setText(dt.selectFromInserimento(i));
               	 
               	 i = ct.selectListFromInserimento(formazione).get(0);
                 this.C1S1.setText(ct.selectFromInserimento(i));
                 i = ct.selectListFromInserimento(formazione).get(1);
                 this.C2S1.setText(ct.selectFromInserimento(i));
                 i = ct.selectListFromInserimento(formazione).get(2);
                 this.C3S1.setText(ct.selectFromInserimento(i));
                 
               	 i = at.selectListFromInserimento(formazione).get(0);
                 this.A1S1.setText(at.selectFromInserimento(i));
                 i = at.selectListFromInserimento(formazione).get(1);
                 this.A2S1.setText(at.selectFromInserimento(i));
                 i = at.selectListFromInserimento(formazione).get(2);
                 this.A3S1.setText(at.selectFromInserimento(i));

               	 
                  	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(1), this.boxGiornate.getSelectionModel().getSelectedItem());	
                   	 i = pt.selectListFromInserimento(formazione).get(0);
                   	 this.P1S2.setText(pt.selectFromInserimento(i));
                   	 i = dt.selectListFromInserimento(formazione).get(0);
                     this.D1S2.setText(dt.selectFromInserimento(i));
                     i = dt.selectListFromInserimento(formazione).get(1);
                     this.D2S2.setText(dt.selectFromInserimento(i));
                     i = dt.selectListFromInserimento(formazione).get(2);
                     this.D3S2.setText(dt.selectFromInserimento(i));
                     i = dt.selectListFromInserimento(formazione).get(3);
                     this.D4S2.setText(dt.selectFromInserimento(i));
                   	 
                   	 i = ct.selectListFromInserimento(formazione).get(0);
                     this.C1S2.setText(ct.selectFromInserimento(i));
                     i = ct.selectListFromInserimento(formazione).get(1);
                     this.C2S2.setText(ct.selectFromInserimento(i));
                     i = ct.selectListFromInserimento(formazione).get(2);
                     this.C3S2.setText(ct.selectFromInserimento(i));
                     
                   	 i = at.selectListFromInserimento(formazione).get(0);
                     this.A1S2.setText(at.selectFromInserimento(i));
                     i = at.selectListFromInserimento(formazione).get(1);
                     this.A2S2.setText(at.selectFromInserimento(i));
                     i = at.selectListFromInserimento(formazione).get(2);
                     this.A3S2.setText(at.selectFromInserimento(i));

                 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(2), this.boxGiornate.getSelectionModel().getSelectedItem());	
                   	i = pt.selectListFromInserimento(formazione).get(0);
                    this.P1S3.setText(pt.selectFromInserimento(i));
                  	i = dt.selectListFromInserimento(formazione).get(0);
                    this.D1S3.setText(dt.selectFromInserimento(i));
                    i = dt.selectListFromInserimento(formazione).get(1);
                    this.D2S3.setText(dt.selectFromInserimento(i));
                    i = dt.selectListFromInserimento(formazione).get(2);
                    this.D3S3.setText(dt.selectFromInserimento(i));
                    i = dt.selectListFromInserimento(formazione).get(3);
                    this.D4S3.setText(dt.selectFromInserimento(i));
                  	 
                  	i = ct.selectListFromInserimento(formazione).get(0);
                    this.C1S3.setText(ct.selectFromInserimento(i));
                    i = ct.selectListFromInserimento(formazione).get(1);
                    this.C2S3.setText(ct.selectFromInserimento(i));
                    i = ct.selectListFromInserimento(formazione).get(2);
                    this.C3S3.setText(ct.selectFromInserimento(i));
                    
                  	i = at.selectListFromInserimento(formazione).get(0);
                    this.A1S3.setText(at.selectFromInserimento(i));
                    i = at.selectListFromInserimento(formazione).get(1);
                    this.A2S3.setText(at.selectFromInserimento(i));
                    i = at.selectListFromInserimento(formazione).get(2);
                    this.A3S3.setText(at.selectFromInserimento(i));

                formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(3), this.boxGiornate.getSelectionModel().getSelectedItem());	
                   i = pt.selectListFromInserimento(formazione).get(0);
                   this.P1S4.setText(pt.selectFromInserimento(i));
                   i = dt.selectListFromInserimento(formazione).get(0);
                   this.D1S4.setText(dt.selectFromInserimento(i));
                   i = dt.selectListFromInserimento(formazione).get(1);
                   this.D2S4.setText(dt.selectFromInserimento(i));
                   i = dt.selectListFromInserimento(formazione).get(2);
                   this.D3S4.setText(dt.selectFromInserimento(i));
                   i = dt.selectListFromInserimento(formazione).get(3);
                   this.D4S4.setText(dt.selectFromInserimento(i));
                 	 
                   i = ct.selectListFromInserimento(formazione).get(0);
                   this.C1S4.setText(ct.selectFromInserimento(i));
                   i = ct.selectListFromInserimento(formazione).get(1);
                   this.C2S4.setText(ct.selectFromInserimento(i));
                   i = ct.selectListFromInserimento(formazione).get(2);
                   this.C3S4.setText(ct.selectFromInserimento(i));
                   
                   i = at.selectListFromInserimento(formazione).get(0);
                   this.A1S4.setText(at.selectFromInserimento(i));
                   i = at.selectListFromInserimento(formazione).get(1);
                   this.A2S4.setText(at.selectFromInserimento(i));
                   i = at.selectListFromInserimento(formazione).get(2);
                   this.A3S4.setText(at.selectFromInserimento(i));

               	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(4), this.boxGiornate.getSelectionModel().getSelectedItem());	
               	  i = pt.selectListFromInserimento(formazione).get(0);
                  this.P1S5.setText(pt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(0);
                  this.D1S5.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(1);
                  this.D2S5.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(2);
                  this.D3S5.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(3);
                  this.D4S5.setText(dt.selectFromInserimento(i));
                	 
                  i = ct.selectListFromInserimento(formazione).get(0);
                  this.C1S5.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(1);
                  this.C2S5.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(2);
                  this.C3S5.setText(ct.selectFromInserimento(i));
                  
                  i = at.selectListFromInserimento(formazione).get(0);
                  this.A1S5.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(1);
                  this.A2S5.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(2);
                  this.A3S5.setText(at.selectFromInserimento(i));

               	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(5), this.boxGiornate.getSelectionModel().getSelectedItem());	
               	  i = pt.selectListFromInserimento(formazione).get(0);
                  this.P1S6.setText(pt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(0);
                  this.D1S6.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(1);
                  this.D2S6.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(2);
                  this.D3S6.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(3);
                  this.D4S6.setText(dt.selectFromInserimento(i));
                	 
                  i = ct.selectListFromInserimento(formazione).get(0);
                  this.C1S6.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(1);
                  this.C2S6.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(2);
                  this.C3S6.setText(ct.selectFromInserimento(i));
                  
                  i = at.selectListFromInserimento(formazione).get(0);
                  this.A1S6.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(1);
                  this.A2S6.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(2);
                  this.A3S6.setText(at.selectFromInserimento(i));
                  
               	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(6), this.boxGiornate.getSelectionModel().getSelectedItem());	
               	  i = pt.selectListFromInserimento(formazione).get(0);
                  this.P1S7.setText(pt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(0);
                  this.D1S7.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(1);
                  this.D2S7.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(2);
                  this.D3S7.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(3);
                  this.D4S7.setText(dt.selectFromInserimento(i));
                	 
                  i = ct.selectListFromInserimento(formazione).get(0);
                  this.C1S7.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(1);
                  this.C2S7.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(2);
                  this.C3S7.setText(ct.selectFromInserimento(i));
                  
                  i = at.selectListFromInserimento(formazione).get(0);
                  this.A1S7.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(1);
                  this.A2S7.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(2);
                  this.A3S7.setText(at.selectFromInserimento(i));

               	 formazione = fft.selectIdFantaFormazione(this.boxSquadre.getItems().get(7), this.boxGiornate.getSelectionModel().getSelectedItem());	
               	  i = pt.selectListFromInserimento(formazione).get(0);
                  this.P1S8.setText(pt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(0);
                  this.D1S8.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(1);
                  this.D2S8.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(2);
                  this.D3S8.setText(dt.selectFromInserimento(i));
                  i = dt.selectListFromInserimento(formazione).get(3);
                  this.D4S8.setText(dt.selectFromInserimento(i));
                	 
                  i = ct.selectListFromInserimento(formazione).get(0);
                  this.C1S8.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(1);
                  this.C2S8.setText(ct.selectFromInserimento(i));
                  i = ct.selectListFromInserimento(formazione).get(2);
                  this.C3S8.setText(ct.selectFromInserimento(i));
                  
                  i = at.selectListFromInserimento(formazione).get(0);
                  this.A1S8.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(1);
                  this.A2S8.setText(at.selectFromInserimento(i));
                  i = at.selectListFromInserimento(formazione).get(2);
                  this.A3S8.setText(at.selectFromInserimento(i));
                this.paneVoti.setVisible(true);
          
            }
            
        } else {
            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText("Errore nell'inserimento della formazione, controlla i ruoli!");
            alert.showAndWait();
        }
    
    }
    
    /**
     * 
     */
    @FXML
    public void confermaInserimento() {
        //per quella giornata se sono stati inseriti tutti i voti di quella squadra aggiorno i vari inserimenti
        AttaccanteTable at = new AttaccanteTable();
        CentrocampistaTable ct = new CentrocampistaTable();
        DifensoreTable dt = new DifensoreTable();
        PortiereTable pt = new PortiereTable();
        FantaFormazioneTable fft= new FantaFormazioneTable();
        
        	int formazione = fft.selectIdFantaFormazione(this.tabS1.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	int i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S1.getText(), Integer.parseInt(this.gfP1S1.getText()), 
        			Integer.parseInt(this.gsP1S1.getText()), Integer.parseInt(this.cgP1S1.getText()), Integer.parseInt(this.crP1S1.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S1.getText(), Integer.parseInt(this.gfD1S1.getText()), 
        			Integer.parseInt(this.aD1S1.getText()), Integer.parseInt(this.cgD1S1.getText()), Integer.parseInt(this.crD1S1.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S1.getText(), Integer.parseInt(this.gfD2S1.getText()), 
        			Integer.parseInt(this.aD2S1.getText()), Integer.parseInt(this.cgD2S1.getText()), Integer.parseInt(this.crD2S1.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S1.getText(), Integer.parseInt(this.gfD3S1.getText()), 
        			Integer.parseInt(this.aD3S1.getText()), Integer.parseInt(this.cgD3S1.getText()), Integer.parseInt(this.crD3S1.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S1.getText(), Integer.parseInt(this.gfD4S1.getText()), 
        			Integer.parseInt(this.aD4S1.getText()), Integer.parseInt(this.cgD4S1.getText()), Integer.parseInt(this.crD4S1.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S1.getText(), Integer.parseInt(this.gfC1S1.getText()), 
        			Integer.parseInt(this.aC1S1.getText()), Integer.parseInt(this.cgC1S1.getText()), Integer.parseInt(this.crC1S1.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S1.getText(), Integer.parseInt(this.gfC2S1.getText()), 
        			Integer.parseInt(this.aC2S1.getText()), Integer.parseInt(this.cgC2S1.getText()), Integer.parseInt(this.crC2S1.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S1.getText(), Integer.parseInt(this.gfC3S1.getText()), 
        			Integer.parseInt(this.aC3S1.getText()), Integer.parseInt(this.cgC3S1.getText()), Integer.parseInt(this.crC3S1.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S1.getText(), Integer.parseInt(this.gfA1S1.getText()), 
        			Integer.parseInt(this.aA1S1.getText()), Integer.parseInt(this.cgA1S1.getText()), Integer.parseInt(this.crA1S1.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S1.getText(), Integer.parseInt(this.gfA2S1.getText()), 
        			Integer.parseInt(this.aA2S1.getText()), Integer.parseInt(this.cgA2S1.getText()), Integer.parseInt(this.crA2S1.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S1.getText(), Integer.parseInt(this.gfA3S1.getText()), 
        			Integer.parseInt(this.aA3S1.getText()), Integer.parseInt(this.cgA3S1.getText()), Integer.parseInt(this.crA3S1.getText()));	
        	//tab2
        	formazione = fft.selectIdFantaFormazione(this.tabS2.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S2.getText(), Integer.parseInt(this.gfP1S2.getText()), 
        			Integer.parseInt(this.gsP1S2.getText()), Integer.parseInt(this.cgP1S2.getText()), Integer.parseInt(this.crP1S2.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S2.getText(), Integer.parseInt(this.gfD1S2.getText()), 
        			Integer.parseInt(this.aD1S2.getText()), Integer.parseInt(this.cgD1S2.getText()), Integer.parseInt(this.crD1S2.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S2.getText(), Integer.parseInt(this.gfD2S2.getText()), 
        			Integer.parseInt(this.aD2S2.getText()), Integer.parseInt(this.cgD2S2.getText()), Integer.parseInt(this.crD2S2.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S2.getText(), Integer.parseInt(this.gfD3S2.getText()), 
        			Integer.parseInt(this.aD3S2.getText()), Integer.parseInt(this.cgD3S2.getText()), Integer.parseInt(this.crD3S2.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S2.getText(), Integer.parseInt(this.gfD4S2.getText()), 
        			Integer.parseInt(this.aD4S2.getText()), Integer.parseInt(this.cgD4S2.getText()), Integer.parseInt(this.crD4S2.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S2.getText(), Integer.parseInt(this.gfC1S2.getText()), 
        			Integer.parseInt(this.aC1S2.getText()), Integer.parseInt(this.cgC1S2.getText()), Integer.parseInt(this.crC1S2.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S2.getText(), Integer.parseInt(this.gfC2S2.getText()), 
        			Integer.parseInt(this.aC2S2.getText()), Integer.parseInt(this.cgC2S2.getText()), Integer.parseInt(this.crC2S2.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S2.getText(), Integer.parseInt(this.gfC3S2.getText()), 
        			Integer.parseInt(this.aC3S2.getText()), Integer.parseInt(this.cgC3S2.getText()), Integer.parseInt(this.crC3S2.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S2.getText(), Integer.parseInt(this.gfA1S2.getText()), 
        			Integer.parseInt(this.aA1S2.getText()), Integer.parseInt(this.cgA1S2.getText()), Integer.parseInt(this.crA1S2.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S2.getText(), Integer.parseInt(this.gfA2S2.getText()), 
        			Integer.parseInt(this.aA2S2.getText()), Integer.parseInt(this.cgA2S2.getText()), Integer.parseInt(this.crA2S2.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S2.getText(), Integer.parseInt(this.gfA3S2.getText()), 
        			Integer.parseInt(this.aA3S2.getText()), Integer.parseInt(this.cgA3S2.getText()), Integer.parseInt(this.crA3S2.getText()));	
        	
        	//tab3
        	formazione = fft.selectIdFantaFormazione(this.tabS3.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S21.getText(), Integer.parseInt(this.gfP1S21.getText()), 
        			Integer.parseInt(this.gsP1S21.getText()), Integer.parseInt(this.cgP1S21.getText()), Integer.parseInt(this.crP1S21.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S21.getText(), Integer.parseInt(this.gfD1S21.getText()), 
        			Integer.parseInt(this.aD1S21.getText()), Integer.parseInt(this.cgD1S21.getText()), Integer.parseInt(this.crD1S21.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S21.getText(), Integer.parseInt(this.gfD2S21.getText()), 
        			Integer.parseInt(this.aD2S21.getText()), Integer.parseInt(this.cgD2S21.getText()), Integer.parseInt(this.crD2S21.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S21.getText(), Integer.parseInt(this.gfD3S21.getText()), 
        			Integer.parseInt(this.aD3S21.getText()), Integer.parseInt(this.cgD3S21.getText()), Integer.parseInt(this.crD3S21.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S21.getText(), Integer.parseInt(this.gfD4S21.getText()), 
        			Integer.parseInt(this.aD4S21.getText()), Integer.parseInt(this.cgD4S21.getText()), Integer.parseInt(this.crD4S21.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S21.getText(), Integer.parseInt(this.gfC1S21.getText()), 
        			Integer.parseInt(this.aC1S21.getText()), Integer.parseInt(this.cgC1S21.getText()), Integer.parseInt(this.crC1S21.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S21.getText(), Integer.parseInt(this.gfC2S21.getText()), 
        			Integer.parseInt(this.aC2S21.getText()), Integer.parseInt(this.cgC2S21.getText()), Integer.parseInt(this.crC2S21.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S21.getText(), Integer.parseInt(this.gfC3S21.getText()), 
        			Integer.parseInt(this.aC3S21.getText()), Integer.parseInt(this.cgC3S21.getText()), Integer.parseInt(this.crC3S21.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S21.getText(), Integer.parseInt(this.gfA1S21.getText()), 
        			Integer.parseInt(this.aA1S21.getText()), Integer.parseInt(this.cgA1S21.getText()), Integer.parseInt(this.crA1S21.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S21.getText(), Integer.parseInt(this.gfA2S21.getText()), 
        			Integer.parseInt(this.aA2S21.getText()), Integer.parseInt(this.cgA2S21.getText()), Integer.parseInt(this.crA2S21.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S21.getText(), Integer.parseInt(this.gfA3S21.getText()), 
        			Integer.parseInt(this.aA3S21.getText()), Integer.parseInt(this.cgA3S21.getText()), Integer.parseInt(this.crA3S21.getText()));	
        
        	//tab4
        	formazione = fft.selectIdFantaFormazione(this.tabS4.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S211.getText(), Integer.parseInt(this.gfP1S211.getText()), 
        			Integer.parseInt(this.gsP1S211.getText()), Integer.parseInt(this.cgP1S211.getText()), Integer.parseInt(this.crP1S211.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S211.getText(), Integer.parseInt(this.gfD1S211.getText()), 
        			Integer.parseInt(this.aD1S211.getText()), Integer.parseInt(this.cgD1S211.getText()), Integer.parseInt(this.crD1S211.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S211.getText(), Integer.parseInt(this.gfD2S211.getText()), 
        			Integer.parseInt(this.aD2S211.getText()), Integer.parseInt(this.cgD2S211.getText()), Integer.parseInt(this.crD2S211.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S211.getText(), Integer.parseInt(this.gfD3S211.getText()), 
        			Integer.parseInt(this.aD3S211.getText()), Integer.parseInt(this.cgD3S211.getText()), Integer.parseInt(this.crD3S211.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S211.getText(), Integer.parseInt(this.gfD4S211.getText()), 
        			Integer.parseInt(this.aD4S211.getText()), Integer.parseInt(this.cgD4S211.getText()), Integer.parseInt(this.crD4S211.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S211.getText(), Integer.parseInt(this.gfC1S211.getText()), 
        			Integer.parseInt(this.aC1S211.getText()), Integer.parseInt(this.cgC1S211.getText()), Integer.parseInt(this.crC1S211.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S211.getText(), Integer.parseInt(this.gfC2S211.getText()), 
        			Integer.parseInt(this.aC2S211.getText()), Integer.parseInt(this.cgC2S211.getText()), Integer.parseInt(this.crC2S211.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S211.getText(), Integer.parseInt(this.gfC3S211.getText()), 
        			Integer.parseInt(this.aC3S211.getText()), Integer.parseInt(this.cgC3S211.getText()), Integer.parseInt(this.crC3S211.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S211.getText(), Integer.parseInt(this.gfA1S211.getText()), 
        			Integer.parseInt(this.aA1S211.getText()), Integer.parseInt(this.cgA1S211.getText()), Integer.parseInt(this.crA1S211.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S211.getText(), Integer.parseInt(this.gfA2S211.getText()), 
        			Integer.parseInt(this.aA2S211.getText()), Integer.parseInt(this.cgA2S211.getText()), Integer.parseInt(this.crA2S211.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S211.getText(), Integer.parseInt(this.gfA3S211.getText()), 
        			Integer.parseInt(this.aA3S211.getText()), Integer.parseInt(this.cgA3S211.getText()), Integer.parseInt(this.crA3S211.getText()));
        	
        	//tab5
        	formazione = fft.selectIdFantaFormazione(this.tabS5.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S2111.getText(), Integer.parseInt(this.gfP1S2111.getText()), 
        			Integer.parseInt(this.gsP1S2111.getText()), Integer.parseInt(this.cgP1S2111.getText()), Integer.parseInt(this.crP1S2111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S2111.getText(), Integer.parseInt(this.gfD1S2111.getText()), 
        			Integer.parseInt(this.aD1S2111.getText()), Integer.parseInt(this.cgD1S2111.getText()), Integer.parseInt(this.crD1S2111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S2111.getText(), Integer.parseInt(this.gfD2S2111.getText()), 
        			Integer.parseInt(this.aD2S2111.getText()), Integer.parseInt(this.cgD2S2111.getText()), Integer.parseInt(this.crD2S2111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S2111.getText(), Integer.parseInt(this.gfD3S2111.getText()), 
        			Integer.parseInt(this.aD3S2111.getText()), Integer.parseInt(this.cgD3S2111.getText()), Integer.parseInt(this.crD3S2111.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S2111.getText(), Integer.parseInt(this.gfD4S2111.getText()), 
        			Integer.parseInt(this.aD4S2111.getText()), Integer.parseInt(this.cgD4S2111.getText()), Integer.parseInt(this.crD4S2111.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S2111.getText(), Integer.parseInt(this.gfC1S2111.getText()), 
        			Integer.parseInt(this.aC1S2111.getText()), Integer.parseInt(this.cgC1S2111.getText()), Integer.parseInt(this.crC1S2111.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S2111.getText(), Integer.parseInt(this.gfC2S2111.getText()), 
        			Integer.parseInt(this.aC2S2111.getText()), Integer.parseInt(this.cgC2S2111.getText()), Integer.parseInt(this.crC2S2111.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S2111.getText(), Integer.parseInt(this.gfC3S2111.getText()), 
        			Integer.parseInt(this.aC3S2111.getText()), Integer.parseInt(this.cgC3S2111.getText()), Integer.parseInt(this.crC3S2111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S2111.getText(), Integer.parseInt(this.gfA1S2111.getText()), 
        			Integer.parseInt(this.aA1S2111.getText()), Integer.parseInt(this.cgA1S2111.getText()), Integer.parseInt(this.crA1S2111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S2111.getText(), Integer.parseInt(this.gfA2S2111.getText()), 
        			Integer.parseInt(this.aA2S2111.getText()), Integer.parseInt(this.cgA2S2111.getText()), Integer.parseInt(this.crA2S2111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S2111.getText(), Integer.parseInt(this.gfA3S2111.getText()), 
        			Integer.parseInt(this.aA3S2111.getText()), Integer.parseInt(this.cgA3S2111.getText()), Integer.parseInt(this.crA3S2111.getText()));	
        
        	//tab6
        	formazione = fft.selectIdFantaFormazione(this.tabS6.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S21111.getText(), Integer.parseInt(this.gfP1S21111.getText()), 
        			Integer.parseInt(this.gsP1S21111.getText()), Integer.parseInt(this.cgP1S21111.getText()), Integer.parseInt(this.crP1S21111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S21111.getText(), Integer.parseInt(this.gfD1S21111.getText()), 
        			Integer.parseInt(this.aD1S21111.getText()), Integer.parseInt(this.cgD1S21111.getText()), Integer.parseInt(this.crD1S21111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S21111.getText(), Integer.parseInt(this.gfD2S21111.getText()), 
        			Integer.parseInt(this.aD2S21111.getText()), Integer.parseInt(this.cgD2S21111.getText()), Integer.parseInt(this.crD2S21111.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S21111.getText(), Integer.parseInt(this.gfD3S21111.getText()), 
        			Integer.parseInt(this.aD3S21111.getText()), Integer.parseInt(this.cgD3S21111.getText()), Integer.parseInt(this.crD3S21111.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S21111.getText(), Integer.parseInt(this.gfD4S21111.getText()), 
        			Integer.parseInt(this.aD4S21111.getText()), Integer.parseInt(this.cgD4S21111.getText()), Integer.parseInt(this.crD4S21111.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S21111.getText(), Integer.parseInt(this.gfC1S21111.getText()), 
        			Integer.parseInt(this.aC1S21111.getText()), Integer.parseInt(this.cgC1S21111.getText()), Integer.parseInt(this.crC1S21111.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S21111.getText(), Integer.parseInt(this.gfC2S21111.getText()), 
        			Integer.parseInt(this.aC2S21111.getText()), Integer.parseInt(this.cgC2S21111.getText()), Integer.parseInt(this.crC2S21111.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S21111.getText(), Integer.parseInt(this.gfC3S21111.getText()), 
        			Integer.parseInt(this.aC3S21111.getText()), Integer.parseInt(this.cgC3S21111.getText()), Integer.parseInt(this.crC3S21111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S21111.getText(), Integer.parseInt(this.gfA1S21111.getText()), 
        			Integer.parseInt(this.aA1S21111.getText()), Integer.parseInt(this.cgA1S21111.getText()), Integer.parseInt(this.crA1S21111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S21111.getText(), Integer.parseInt(this.gfA2S21111.getText()), 
        			Integer.parseInt(this.aA2S21111.getText()), Integer.parseInt(this.cgA2S21111.getText()), Integer.parseInt(this.crA2S21111.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S21111.getText(), Integer.parseInt(this.gfA3S21111.getText()), 
        			Integer.parseInt(this.aA3S21111.getText()), Integer.parseInt(this.cgA3S21111.getText()), Integer.parseInt(this.crA3S21111.getText()));	
        
        	//tab7
        	formazione = fft.selectIdFantaFormazione(this.tabS7.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S21112.getText(), Integer.parseInt(this.gfP1S21112.getText()), 
        			Integer.parseInt(this.gsP1S21112.getText()), Integer.parseInt(this.cgP1S21112.getText()), Integer.parseInt(this.crP1S21112.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S21112.getText(), Integer.parseInt(this.gfD1S21112.getText()), 
        			Integer.parseInt(this.aD1S21112.getText()), Integer.parseInt(this.cgD1S21112.getText()), Integer.parseInt(this.crD1S21112.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S21112.getText(), Integer.parseInt(this.gfD2S21112.getText()), 
        			Integer.parseInt(this.aD2S21112.getText()), Integer.parseInt(this.cgD2S21112.getText()), Integer.parseInt(this.crD2S21112.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S21112.getText(), Integer.parseInt(this.gfD3S21112.getText()), 
        			Integer.parseInt(this.aD3S21112.getText()), Integer.parseInt(this.cgD3S21112.getText()), Integer.parseInt(this.crD3S21112.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S21112.getText(), Integer.parseInt(this.gfD4S21112.getText()), 
        			Integer.parseInt(this.aD4S21112.getText()), Integer.parseInt(this.cgD4S21112.getText()), Integer.parseInt(this.crD4S21112.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S21112.getText(), Integer.parseInt(this.gfC1S21112.getText()), 
        			Integer.parseInt(this.aC1S21112.getText()), Integer.parseInt(this.cgC1S21112.getText()), Integer.parseInt(this.crC1S21112.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S21112.getText(), Integer.parseInt(this.gfC2S21112.getText()), 
        			Integer.parseInt(this.aC2S21112.getText()), Integer.parseInt(this.cgC2S21112.getText()), Integer.parseInt(this.crC2S21112.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S21112.getText(), Integer.parseInt(this.gfC3S21112.getText()), 
        			Integer.parseInt(this.aC3S21112.getText()), Integer.parseInt(this.cgC3S21112.getText()), Integer.parseInt(this.crC3S21112.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S21112.getText(), Integer.parseInt(this.gfA1S21112.getText()), 
        			Integer.parseInt(this.aA1S21112.getText()), Integer.parseInt(this.cgA1S21112.getText()), Integer.parseInt(this.crA1S21112.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S21112.getText(), Integer.parseInt(this.gfA2S21112.getText()), 
        			Integer.parseInt(this.aA2S21112.getText()), Integer.parseInt(this.cgA2S21112.getText()), Integer.parseInt(this.crA2S21112.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S21112.getText(), Integer.parseInt(this.gfA3S21112.getText()), 
        			Integer.parseInt(this.aA3S21112.getText()), Integer.parseInt(this.cgA3S21112.getText()), Integer.parseInt(this.crA3S21112.getText()));	
        
        	//tab8
        	formazione = fft.selectIdFantaFormazione(this.tabS8.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
        	i = pt.selectListFromInserimento(formazione).get(0);
        	pt.updateInserimento(i, this.vP1S21113.getText(), Integer.parseInt(this.gfP1S21113.getText()), 
        			Integer.parseInt(this.gsP1S21113.getText()), Integer.parseInt(this.cgP1S21113.getText()), Integer.parseInt(this.crP1S21113.getText()));
        	i = dt.selectListFromInserimento(formazione).get(0);
        	dt.updateInserimento(i, this.vD1S21113.getText(), Integer.parseInt(this.gfD1S21113.getText()), 
        			Integer.parseInt(this.aD1S21113.getText()), Integer.parseInt(this.cgD1S21113.getText()), Integer.parseInt(this.crD1S21113.getText()));
        	i = dt.selectListFromInserimento(formazione).get(1);
        	dt.updateInserimento(i, this.vD2S21113.getText(), Integer.parseInt(this.gfD2S21113.getText()), 
        			Integer.parseInt(this.aD2S21113.getText()), Integer.parseInt(this.cgD2S21113.getText()), Integer.parseInt(this.crD2S21113.getText()));
        	i = dt.selectListFromInserimento(formazione).get(2);
        	dt.updateInserimento(i, this.vD3S21113.getText(), Integer.parseInt(this.gfD3S21113.getText()), 
        			Integer.parseInt(this.aD3S21113.getText()), Integer.parseInt(this.cgD3S21113.getText()), Integer.parseInt(this.crD3S21113.getText()));	
        	i = dt.selectListFromInserimento(formazione).get(3);
        	dt.updateInserimento(i, this.vD4S21113.getText(), Integer.parseInt(this.gfD4S21113.getText()), 
        			Integer.parseInt(this.aD4S21113.getText()), Integer.parseInt(this.cgD4S21113.getText()), Integer.parseInt(this.crD4S21113.getText()));
        	i = ct.selectListFromInserimento(formazione).get(0);
        	ct.updateInserimento(i, this.vC1S21113.getText(), Integer.parseInt(this.gfC1S21113.getText()), 
        			Integer.parseInt(this.aC1S21113.getText()), Integer.parseInt(this.cgC1S21113.getText()), Integer.parseInt(this.crC1S21113.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(1);
        	ct.updateInserimento(i, this.vC2S21113.getText(), Integer.parseInt(this.gfC2S21113.getText()), 
        			Integer.parseInt(this.aC2S21113.getText()), Integer.parseInt(this.cgC2S21113.getText()), Integer.parseInt(this.crC2S21113.getText()));	
        	i = ct.selectListFromInserimento(formazione).get(2);
        	ct.updateInserimento(i, this.vC3S21113.getText(), Integer.parseInt(this.gfC3S21113.getText()), 
        			Integer.parseInt(this.aC3S21113.getText()), Integer.parseInt(this.cgC3S21113.getText()), Integer.parseInt(this.crC3S21113.getText()));	
        	i = at.selectListFromInserimento(formazione).get(0);
        	at.updateInserimento(i, this.vA1S21113.getText(), Integer.parseInt(this.gfA1S21113.getText()), 
        			Integer.parseInt(this.aA1S21113.getText()), Integer.parseInt(this.cgA1S21113.getText()), Integer.parseInt(this.crA1S21113.getText()));	
        	i = at.selectListFromInserimento(formazione).get(1);
        	at.updateInserimento(i, this.vA2S21113.getText(), Integer.parseInt(this.gfA2S21113.getText()), 
        			Integer.parseInt(this.aA2S21113.getText()), Integer.parseInt(this.cgA2S21113.getText()), Integer.parseInt(this.crA2S21113.getText()));	
        	i = at.selectListFromInserimento(formazione).get(2);
        	at.updateInserimento(i, this.vA3S21113.getText(), Integer.parseInt(this.gfA3S21113.getText()), 
        			Integer.parseInt(this.aA3S21113.getText()), Integer.parseInt(this.cgA3S21113.getText()), Integer.parseInt(this.crA3S21113.getText()));	
        
    }
    
    
    /**
     * 
     */
    @FXML
    public void simulaGiornata() {
        //se non ci sono formazioni per quella giornata genera alert
        
        //se ci sono, per ogni inserimento della stessa formazione fai la somma di tutti i fantavoto(da calcolare) e trovi il punteggio di quella formazione,
        //così per ogni formazione
    	calcolaPunteggio();
    	this.paneFormazioni.setVisible(false);
    	this.paneVoti.setVisible(false);
    }
    
    
    /**
     * Show the current view.
     */
    public void show() {
        this.environment.displayScreen(FXMLScreens.MAIN);
    }
    
    /**
     * 
     */
    @FXML
    public void goToCreazione() {
        this.environment.displayScreen(FXMLScreens.CREAZIONE);
    }
    
    
    private void calcolaPunteggio() {
    	
    	FantaPartiteTable fpt = new FantaPartiteTable();
    	LegheTable lt = new LegheTable();
    	FantaSquadreTable fst = new FantaSquadreTable();
    	FantaFormazioneTable fft = new FantaFormazioneTable();
    	AttaccanteTable at = new AttaccanteTable();
    	CentrocampistaTable ct = new CentrocampistaTable();
    	DifensoreTable dt = new DifensoreTable();
    	PortiereTable pt = new PortiereTable();
    	int idLega = lt.selectIDLega(this.boxLeghe.getSelectionModel().getSelectedItem());
    	
    f1S1 = (Double.parseDouble(vP1S1.getText())) +  (Integer.parseInt(gfP1S1.getText())*3) - Integer.parseInt(gsP1S1.getText()) 
    		+ Integer.parseInt(aP1S1.getText()) - (Double.parseDouble(cgP1S1.getText())*0.5) - Integer.parseInt(crP1S1.getText());
    f2S1 = (Double.parseDouble(vD1S1.getText())) +  (Integer.parseInt(gfD1S1.getText())*3) - Integer.parseInt(gsD1S1.getText()) 
    		+ Integer.parseInt(aD1S1.getText()) - (Double.parseDouble(cgD1S1.getText())*0.5) - Integer.parseInt(crD1S1.getText());
    f3S1 = (Double.parseDouble(vD2S1.getText())) +  (Integer.parseInt(gfD2S1.getText())*3) - Integer.parseInt(gsD2S1.getText()) 
    		+ Integer.parseInt(aD2S1.getText()) - (Double.parseDouble(cgD2S1.getText())*0.5) - Integer.parseInt(crD2S1.getText());
    f4S1 = (Double.parseDouble(vD3S1.getText())) +  (Integer.parseInt(gfD3S1.getText())*3) - Integer.parseInt(gsD3S1.getText()) 
    		+ Integer.parseInt(aD3S1.getText()) - (Double.parseDouble(cgD3S1.getText())*0.5) - Integer.parseInt(crD3S1.getText());
    f5S1 = (Double.parseDouble(vD4S1.getText())) +  (Integer.parseInt(gfD4S1.getText())*3) - Integer.parseInt(gsD4S1.getText()) 
    		+ Integer.parseInt(aD4S1.getText()) - (Double.parseDouble(cgD4S1.getText())*0.5) - Integer.parseInt(crD4S1.getText());
    f6S1 = (Double.parseDouble(vC1S1.getText())) +  (Integer.parseInt(gfC1S1.getText())*3) - Integer.parseInt(gsC1S1.getText()) 
    		+ Integer.parseInt(aC1S1.getText()) - (Double.parseDouble(cgC1S1.getText())*0.5) - Integer.parseInt(crC1S1.getText());
    f7S1 = (Double.parseDouble(vC2S1.getText())) +  (Integer.parseInt(gfC2S1.getText())*3) - Integer.parseInt(gsC2S1.getText()) 
    		+ Integer.parseInt(aC2S1.getText()) - (Double.parseDouble(cgC2S1.getText())*0.5) - Integer.parseInt(crC2S1.getText());
    f8S1 = (Double.parseDouble(vC3S1.getText())) +  (Integer.parseInt(gfC3S1.getText())*3) - Integer.parseInt(gsC3S1.getText()) 
    		+ Integer.parseInt(aC3S1.getText()) - (Double.parseDouble(cgC3S1.getText())*0.5) - Integer.parseInt(crC3S1.getText());
    f9S1 = (Double.parseDouble(vA1S1.getText())) +  (Integer.parseInt(gfA1S1.getText())*3) - Integer.parseInt(gsA1S1.getText()) 
    		+ Integer.parseInt(aA1S1.getText()) - (Double.parseDouble(cgA1S1.getText())*0.5) - Integer.parseInt(crA1S1.getText());
    f10S1 = (Double.parseDouble(vA2S1.getText())) +  (Integer.parseInt(gfA2S1.getText())*3) - Integer.parseInt(gsA2S1.getText()) 
    		+ Integer.parseInt(aA2S1.getText()) - (Double.parseDouble(cgA2S1.getText())*0.5) - Integer.parseInt(crA2S1.getText());
    f11S1 = (Double.parseDouble(vA3S1.getText())) +  (Integer.parseInt(gfA3S1.getText())*3) - Integer.parseInt(gsA3S1.getText()) 
    		+ Integer.parseInt(aA3S1.getText()) - (Double.parseDouble(cgA3S1.getText())*0.5) - Integer.parseInt(crA3S1.getText());
    punteggio1 = f1S1+f2S1+f3S1+f4S1+f5S1+f6S1+f7S1+f8S1+f9S1+f10S1+f11S1;

    if (punteggio1-60 <0) {
    	gol1 = 0;
    } else {
    	gol1 = (int)(punteggio1-60)/6;
    }

    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS1.getText())) {
    		fpt.updateCasa(this.tabS1.getText(), gol1, Double.toString(punteggio1), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS1.getText(), gol1, Double.toString(punteggio1), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    }  
    
    f1S2 = (Double.parseDouble(vP1S2.getText())) +  (Integer.parseInt(gfP1S2.getText())*3) - Integer.parseInt(gsP1S2.getText()) 
    		+ Integer.parseInt(aP1S2.getText()) - (Double.parseDouble(cgP1S2.getText())*0.5) - Integer.parseInt(crP1S2.getText());
    f2S2 = (Double.parseDouble(vD1S2.getText())) +  (Integer.parseInt(gfD1S2.getText())*3) - Integer.parseInt(gsD1S2.getText()) 
    		+ Integer.parseInt(aD1S2.getText()) - (Double.parseDouble(cgD1S2.getText())*0.5) - Integer.parseInt(crD1S2.getText());
    f3S2 = (Double.parseDouble(vD2S2.getText())) +  (Integer.parseInt(gfD2S2.getText())*3) - Integer.parseInt(gsD2S2.getText()) 
    		+ Integer.parseInt(aD2S2.getText()) - (Double.parseDouble(cgD2S2.getText())*0.5) - Integer.parseInt(crD2S2.getText());
    f4S2 = (Double.parseDouble(vD3S2.getText())) +  (Integer.parseInt(gfD3S2.getText())*3) - Integer.parseInt(gsD3S2.getText()) 
    		+ Integer.parseInt(aD3S2.getText()) - (Double.parseDouble(cgD3S2.getText())*0.5) - Integer.parseInt(crD3S2.getText());
    f5S2 = (Double.parseDouble(vD4S2.getText())) +  (Integer.parseInt(gfD4S2.getText())*3) - Integer.parseInt(gsD4S2.getText()) 
    		+ Integer.parseInt(aD4S2.getText()) - (Double.parseDouble(cgD4S2.getText())*0.5) - Integer.parseInt(crD4S2.getText());
    f6S2 = (Double.parseDouble(vC1S2.getText())) +  (Integer.parseInt(gfC1S2.getText())*3) - Integer.parseInt(gsC1S2.getText()) 
    		+ Integer.parseInt(aC1S2.getText()) - (Double.parseDouble(cgC1S2.getText())*0.5) - Integer.parseInt(crC1S2.getText());
    f7S2 = (Double.parseDouble(vC2S2.getText())) +  (Integer.parseInt(gfC2S2.getText())*3) - Integer.parseInt(gsC2S2.getText()) 
    		+ Integer.parseInt(aC2S2.getText()) - (Double.parseDouble(cgC2S2.getText())*0.5) - Integer.parseInt(crC2S2.getText());
    f8S2 = (Double.parseDouble(vC3S2.getText())) +  (Integer.parseInt(gfC3S2.getText())*3) - Integer.parseInt(gsC3S2.getText()) 
    		+ Integer.parseInt(aC3S2.getText()) - (Double.parseDouble(cgC3S2.getText())*0.5) - Integer.parseInt(crC3S2.getText());
    f9S2 = (Double.parseDouble(vA1S2.getText())) +  (Integer.parseInt(gfA1S2.getText())*3) - Integer.parseInt(gsA1S2.getText()) 
    		+ Integer.parseInt(aA1S2.getText()) - (Double.parseDouble(cgA1S2.getText())*0.5) - Integer.parseInt(crA1S2.getText());
    f10S2 = (Double.parseDouble(vA2S2.getText())) +  (Integer.parseInt(gfA2S2.getText())*3) - Integer.parseInt(gsA2S2.getText()) 
    		+ Integer.parseInt(aA2S2.getText()) - (Double.parseDouble(cgA2S2.getText())*0.5) - Integer.parseInt(crA2S2.getText());
    f11S2 = (Double.parseDouble(vA3S2.getText())) +  (Integer.parseInt(gfA3S2.getText())*3) - Integer.parseInt(gsA3S2.getText()) 
    		+ Integer.parseInt(aA3S2.getText()) - (Double.parseDouble(cgA3S2.getText())*0.5) - Integer.parseInt(crA3S2.getText());
    punteggio2 = f1S2+f2S2+f3S2+f4S2+f5S2+f6S2+f7S2+f8S2+f9S2+f10S2+f11S2;
    
    if (punteggio2-60 <0) {
    	gol2 = 0;
    } else {
    	gol2 = (int)(punteggio2-60)/6;
    }
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS2.getText())) {
    		fpt.updateCasa(this.tabS2.getText(), gol2, Double.toString(punteggio2), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS2.getText(), gol2, Double.toString(punteggio2), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    
    f1S21 = (Double.parseDouble(vP1S21.getText())) +  (Integer.parseInt(gfP1S21.getText())*3) - Integer.parseInt(gsP1S21.getText()) 
    		+ Integer.parseInt(aP1S21.getText()) - (Double.parseDouble(cgP1S21.getText())*0.5) - Integer.parseInt(crP1S21.getText());
    f2S21 = (Double.parseDouble(vD1S21.getText())) +  (Integer.parseInt(gfD1S21.getText())*3) - Integer.parseInt(gsD1S21.getText()) 
    		+ Integer.parseInt(aD1S21.getText()) - (Double.parseDouble(cgD1S21.getText())*0.5) - Integer.parseInt(crD1S21.getText());
    f3S21 = (Double.parseDouble(vD2S21.getText())) +  (Integer.parseInt(gfD2S21.getText())*3) - Integer.parseInt(gsD2S21.getText()) 
    		+ Integer.parseInt(aD2S21.getText()) - (Double.parseDouble(cgD2S21.getText())*0.5) - Integer.parseInt(crD2S21.getText());
    f4S21 = (Double.parseDouble(vD3S21.getText())) +  (Integer.parseInt(gfD3S21.getText())*3) - Integer.parseInt(gsD3S21.getText()) 
    		+ Integer.parseInt(aD3S21.getText()) - (Double.parseDouble(cgD3S21.getText())*0.5) - Integer.parseInt(crD3S21.getText());
    f5S21 = (Double.parseDouble(vD4S21.getText())) +  (Integer.parseInt(gfD4S21.getText())*3) - Integer.parseInt(gsD4S21.getText()) 
    		+ Integer.parseInt(aD4S21.getText()) - (Double.parseDouble(cgD4S21.getText())*0.5) - Integer.parseInt(crD4S21.getText());
    f6S21 = (Double.parseDouble(vC1S21.getText())) +  (Integer.parseInt(gfC1S21.getText())*3) - Integer.parseInt(gsC1S21.getText()) 
    		+ Integer.parseInt(aC1S21.getText()) - (Double.parseDouble(cgC1S21.getText())*0.5) - Integer.parseInt(crC1S21.getText());
    f7S21 = (Double.parseDouble(vC2S21.getText())) +  (Integer.parseInt(gfC2S21.getText())*3) - Integer.parseInt(gsC2S21.getText()) 
    		+ Integer.parseInt(aC2S21.getText()) - (Double.parseDouble(cgC2S21.getText())*0.5) - Integer.parseInt(crC2S21.getText());
    f8S21 = (Double.parseDouble(vC3S21.getText())) +  (Integer.parseInt(gfC3S21.getText())*3) - Integer.parseInt(gsC3S21.getText()) 
    		+ Integer.parseInt(aC3S21.getText()) - (Double.parseDouble(cgC3S21.getText())*0.5) - Integer.parseInt(crC3S21.getText());
    f9S21 = (Double.parseDouble(vA1S21.getText())) +  (Integer.parseInt(gfA1S21.getText())*3) - Integer.parseInt(gsA1S21.getText()) 
    		+ Integer.parseInt(aA1S21.getText()) - (Double.parseDouble(cgA1S21.getText())*0.5) - Integer.parseInt(crA1S21.getText());
    f10S21 = (Double.parseDouble(vA2S21.getText())) +  (Integer.parseInt(gfA2S21.getText())*3) - Integer.parseInt(gsA2S21.getText()) 
    		+ Integer.parseInt(aA2S21.getText()) - (Double.parseDouble(cgA2S21.getText())*0.5) - Integer.parseInt(crA2S21.getText());
    f11S21 = (Double.parseDouble(vA3S21.getText())) +  (Integer.parseInt(gfA3S21.getText())*3) - Integer.parseInt(gsA3S21.getText()) 
    		+ Integer.parseInt(aA3S21.getText()) - (Double.parseDouble(cgA3S21.getText())*0.5) - Integer.parseInt(crA3S21.getText());
    punteggio21 = f1S21+f2S21+f3S21+f4S21+f5S21+f6S21+f7S21+f8S21+f9S21+f10S21+f11S21;
    
    if (punteggio21-60 <0) {
    	gol21 = 0;
    } else {
    	gol21 = (int)(punteggio21-60)/6;
    }
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS3.getText())) {
    		fpt.updateCasa(this.tabS3.getText(), gol21, Double.toString(punteggio21), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS3.getText(), gol21, Double.toString(punteggio21), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    
    f1S211 = (Double.parseDouble(vP1S211.getText())) +  (Integer.parseInt(gfP1S211.getText())*3) - Integer.parseInt(gsP1S211.getText()) 
    		+ Integer.parseInt(aP1S211.getText()) - (Double.parseDouble(cgP1S211.getText())*0.5) - Integer.parseInt(crP1S211.getText());
    f2S211 = (Double.parseDouble(vD1S211.getText())) +  (Integer.parseInt(gfD1S211.getText())*3) - Integer.parseInt(gsD1S211.getText()) 
    		+ Integer.parseInt(aD1S211.getText()) - (Double.parseDouble(cgD1S211.getText())*0.5) - Integer.parseInt(crD1S211.getText());
    f3S211 = (Double.parseDouble(vD2S211.getText())) +  (Integer.parseInt(gfD2S211.getText())*3) - Integer.parseInt(gsD2S211.getText()) 
    		+ Integer.parseInt(aD2S211.getText()) - (Double.parseDouble(cgD2S211.getText())*0.5) - Integer.parseInt(crD2S211.getText());
    f4S211 = (Double.parseDouble(vD3S211.getText())) +  (Integer.parseInt(gfD3S211.getText())*3) - Integer.parseInt(gsD3S211.getText()) 
    		+ Integer.parseInt(aD3S211.getText()) - (Double.parseDouble(cgD3S211.getText())*0.5) - Integer.parseInt(crD3S211.getText());
    f5S211 = (Double.parseDouble(vD4S211.getText())) +  (Integer.parseInt(gfD4S211.getText())*3) - Integer.parseInt(gsD4S211.getText()) 
    		+ Integer.parseInt(aD4S211.getText()) - (Double.parseDouble(cgD4S211.getText())*0.5) - Integer.parseInt(crD4S211.getText());
    f6S211 = (Double.parseDouble(vC1S211.getText())) +  (Integer.parseInt(gfC1S211.getText())*3) - Integer.parseInt(gsC1S211.getText()) 
    		+ Integer.parseInt(aC1S211.getText()) - (Double.parseDouble(cgC1S211.getText())*0.5) - Integer.parseInt(crC1S211.getText());
    f7S211 = (Double.parseDouble(vC2S211.getText())) +  (Integer.parseInt(gfC2S211.getText())*3) - Integer.parseInt(gsC2S211.getText()) 
    		+ Integer.parseInt(aC2S211.getText()) - (Double.parseDouble(cgC2S211.getText())*0.5) - Integer.parseInt(crC2S211.getText());
    f8S211 = (Double.parseDouble(vC3S211.getText())) +  (Integer.parseInt(gfC3S211.getText())*3) - Integer.parseInt(gsC3S211.getText()) 
    		+ Integer.parseInt(aC3S211.getText()) - (Double.parseDouble(cgC3S211.getText())*0.5) - Integer.parseInt(crC3S211.getText());
    f9S211 = (Double.parseDouble(vA1S211.getText())) +  (Integer.parseInt(gfA1S211.getText())*3) - Integer.parseInt(gsA1S211.getText()) 
    		+ Integer.parseInt(aA1S211.getText()) - (Double.parseDouble(cgA1S211.getText())*0.5) - Integer.parseInt(crA1S211.getText());
    f10S211 = (Double.parseDouble(vA2S211.getText())) +  (Integer.parseInt(gfA2S211.getText())*3) - Integer.parseInt(gsA2S211.getText()) 
    		+ Integer.parseInt(aA2S211.getText()) - (Double.parseDouble(cgA2S211.getText())*0.5) - Integer.parseInt(crA2S211.getText());
    f11S211 = (Double.parseDouble(vA3S211.getText())) +  (Integer.parseInt(gfA3S211.getText())*3) - Integer.parseInt(gsA3S211.getText()) 
    		+ Integer.parseInt(aA3S211.getText()) - (Double.parseDouble(cgA3S211.getText())*0.5) - Integer.parseInt(crA3S211.getText());
    punteggio211 = f1S211+f2S211+f3S211+f4S211+f5S211+f6S211+f7S211+f8S211+f9S211+f10S211+f11S211;
    
    if (punteggio211-60 <0) {
    	gol211 = 0;
    } else {
    	gol211 = (int)(punteggio211-60)/6;
    }
    
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS4.getText())) {
    		fpt.updateCasa(this.tabS4.getText(), gol211, Double.toString(punteggio211), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS4.getText(), gol211, Double.toString(punteggio211), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    
    f1S2111 = (Double.parseDouble(vP1S2111.getText())) +  (Integer.parseInt(gfP1S2111.getText())*3) - Integer.parseInt(gsP1S2111.getText()) 
    		+ Integer.parseInt(aP1S2111.getText()) - (Double.parseDouble(cgP1S2111.getText())*0.5) - Integer.parseInt(crP1S2111.getText());
    f2S2111 = (Double.parseDouble(vD1S2111.getText())) +  (Integer.parseInt(gfD1S2111.getText())*3) - Integer.parseInt(gsD1S2111.getText()) 
    		+ Integer.parseInt(aD1S2111.getText()) - (Double.parseDouble(cgD1S2111.getText())*0.5) - Integer.parseInt(crD1S2111.getText());
    f3S2111 = (Double.parseDouble(vD2S2111.getText())) +  (Integer.parseInt(gfD2S2111.getText())*3) - Integer.parseInt(gsD2S2111.getText()) 
    		+ Integer.parseInt(aD2S2111.getText()) - (Double.parseDouble(cgD2S2111.getText())*0.5) - Integer.parseInt(crD2S2111.getText());
    f4S2111 = (Double.parseDouble(vD3S2111.getText())) +  (Integer.parseInt(gfD3S2111.getText())*3) - Integer.parseInt(gsD3S2111.getText()) 
    		+ Integer.parseInt(aD3S2111.getText()) - (Double.parseDouble(cgD3S2111.getText())*0.5) - Integer.parseInt(crD3S2111.getText());
    f5S2111 = (Double.parseDouble(vD4S2111.getText())) +  (Integer.parseInt(gfD4S2111.getText())*3) - Integer.parseInt(gsD4S2111.getText()) 
    		+ Integer.parseInt(aD4S2111.getText()) - (Double.parseDouble(cgD4S2111.getText())*0.5) - Integer.parseInt(crD4S2111.getText());
    f6S2111 = (Double.parseDouble(vC1S2111.getText())) +  (Integer.parseInt(gfC1S2111.getText())*3) - Integer.parseInt(gsC1S2111.getText()) 
    		+ Integer.parseInt(aC1S2111.getText()) - (Double.parseDouble(cgC1S2111.getText())*0.5) - Integer.parseInt(crC1S2111.getText());
    f7S2111 = (Double.parseDouble(vC2S2111.getText())) +  (Integer.parseInt(gfC2S2111.getText())*3) - Integer.parseInt(gsC2S2111.getText()) 
    		+ Integer.parseInt(aC2S2111.getText()) - (Double.parseDouble(cgC2S2111.getText())*0.5) - Integer.parseInt(crC2S2111.getText());
    f8S2111 = (Double.parseDouble(vC3S2111.getText())) +  (Integer.parseInt(gfC3S2111.getText())*3) - Integer.parseInt(gsC3S2111.getText()) 
    		+ Integer.parseInt(aC3S2111.getText()) - (Double.parseDouble(cgC3S2111.getText())*0.5) - Integer.parseInt(crC3S2111.getText());
    f9S2111 = (Double.parseDouble(vA1S2111.getText())) +  (Integer.parseInt(gfA1S2111.getText())*3) - Integer.parseInt(gsA1S2111.getText()) 
    		+ Integer.parseInt(aA1S2111.getText()) - (Double.parseDouble(cgA1S2111.getText())*0.5) - Integer.parseInt(crA1S2111.getText());
    f10S2111 = (Double.parseDouble(vA2S2111.getText())) +  (Integer.parseInt(gfA2S2111.getText())*3) - Integer.parseInt(gsA2S2111.getText()) 
    		+ Integer.parseInt(aA2S2111.getText()) - (Double.parseDouble(cgA2S2111.getText())*0.5) - Integer.parseInt(crA2S2111.getText());
    f11S2111 = (Double.parseDouble(vA3S2111.getText())) +  (Integer.parseInt(gfA3S2111.getText())*3) - Integer.parseInt(gsA3S2111.getText()) 
    		+ Integer.parseInt(aA3S2111.getText()) - (Double.parseDouble(cgA3S2111.getText())*0.5) - Integer.parseInt(crA3S2111.getText());
    punteggio2111 = f1S2111+f2S2111+f3S2111+f4S2111+f5S2111+f6S2111+f7S2111+f8S2111+f9S2111+f10S2111+f11S2111;
    
    if (punteggio2111-60 <0) {
    	gol2111 = 0;
    } else {
    	gol2111 = (int)(punteggio2111-60)/6;
    }
    
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS5.getText())) {
    		fpt.updateCasa(this.tabS5.getText(), gol2111, Double.toString(punteggio2111), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS5.getText(), gol2111, Double.toString(punteggio2111), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    
    f1S21111 = (Double.parseDouble(vP1S21111.getText())) +  (Integer.parseInt(gfP1S21111.getText())*3) - Integer.parseInt(gsP1S21111.getText()) 
    		+ Integer.parseInt(aP1S21111.getText()) - (Double.parseDouble(cgP1S21111.getText())*0.5) - Integer.parseInt(crP1S21111.getText());
    f2S21111 = (Double.parseDouble(vD1S21111.getText())) +  (Integer.parseInt(gfD1S21111.getText())*3) - Integer.parseInt(gsD1S21111.getText()) 
    		+ Integer.parseInt(aD1S21111.getText()) - (Double.parseDouble(cgD1S21111.getText())*0.5) - Integer.parseInt(crD1S21111.getText());
    f3S21111 = (Double.parseDouble(vD2S21111.getText())) +  (Integer.parseInt(gfD2S21111.getText())*3) - Integer.parseInt(gsD2S21111.getText()) 
    		+ Integer.parseInt(aD2S21111.getText()) - (Double.parseDouble(cgD2S21111.getText())*0.5) - Integer.parseInt(crD2S21111.getText());
    f4S21111 = (Double.parseDouble(vD3S21111.getText())) +  (Integer.parseInt(gfD3S21111.getText())*3) - Integer.parseInt(gsD3S21111.getText()) 
    		+ Integer.parseInt(aD3S21111.getText()) - (Double.parseDouble(cgD3S21111.getText())*0.5) - Integer.parseInt(crD3S21111.getText());
    f5S21111 = (Double.parseDouble(vD4S21111.getText())) +  (Integer.parseInt(gfD4S21111.getText())*3) - Integer.parseInt(gsD4S21111.getText()) 
    		+ Integer.parseInt(aD4S21111.getText()) - (Double.parseDouble(cgD4S21111.getText())*0.5) - Integer.parseInt(crD4S21111.getText());
    f6S21111 = (Double.parseDouble(vC1S21111.getText())) +  (Integer.parseInt(gfC1S21111.getText())*3) - Integer.parseInt(gsC1S21111.getText()) 
    		+ Integer.parseInt(aC1S21111.getText()) - (Double.parseDouble(cgC1S21111.getText())*0.5) - Integer.parseInt(crC1S21111.getText());
    f7S21111 = (Double.parseDouble(vC2S21111.getText())) +  (Integer.parseInt(gfC2S21111.getText())*3) - Integer.parseInt(gsC2S21111.getText()) 
    		+ Integer.parseInt(aC2S21111.getText()) - (Double.parseDouble(cgC2S21111.getText())*0.5) - Integer.parseInt(crC2S21111.getText());
    f8S21111 = (Double.parseDouble(vC3S21111.getText())) +  (Integer.parseInt(gfC3S21111.getText())*3) - Integer.parseInt(gsC3S21111.getText()) 
    		+ Integer.parseInt(aC3S21111.getText()) - (Double.parseDouble(cgC3S21111.getText())*0.5) - Integer.parseInt(crC3S21111.getText());
    f9S21111 = (Double.parseDouble(vA1S21111.getText())) +  (Integer.parseInt(gfA1S21111.getText())*3) - Integer.parseInt(gsA1S21111.getText()) 
    		+ Integer.parseInt(aA1S21111.getText()) - (Double.parseDouble(cgA1S21111.getText())*0.5) - Integer.parseInt(crA1S21111.getText());
    f10S21111 = (Double.parseDouble(vA2S21111.getText())) +  (Integer.parseInt(gfA2S21111.getText())*3) - Integer.parseInt(gsA2S21111.getText()) 
    		+ Integer.parseInt(aA2S21111.getText()) - (Double.parseDouble(cgA2S21111.getText())*0.5) - Integer.parseInt(crA2S21111.getText());
    f11S21111 = (Double.parseDouble(vA3S21111.getText())) +  (Integer.parseInt(gfA3S21111.getText())*3) - Integer.parseInt(gsA3S21111.getText()) 
    		+ Integer.parseInt(aA3S21111.getText()) - (Double.parseDouble(cgA3S21111.getText())*0.5) - Integer.parseInt(crA3S21111.getText());
    punteggio21111 = f1S21111+f2S21111+f3S21111+f4S21111+f5S21111+f6S21111+f7S21111+f8S21111+f9S21111+f10S21111+f11S21111;
    
    if (punteggio21111-60 <0) {
    	gol21111 = 0;
    } else {
    	gol21111 = (int)(punteggio21111-60)/6;
    }
    
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS6.getText())) {
    		fpt.updateCasa(this.tabS6.getText(), gol21111, Double.toString(punteggio21111), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS6.getText(), gol21111, Double.toString(punteggio21111), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    
    f1S21112 = (Double.parseDouble(vP1S21112.getText())) +  (Integer.parseInt(gfP1S21112.getText())*3) - Integer.parseInt(gsP1S21112.getText()) 
    		+ Integer.parseInt(aP1S21112.getText()) - (Double.parseDouble(cgP1S21112.getText())*0.5) - Integer.parseInt(crP1S21112.getText());
    f2S21112 = (Double.parseDouble(vD1S21112.getText())) +  (Integer.parseInt(gfD1S21112.getText())*3) - Integer.parseInt(gsD1S21112.getText()) 
    		+ Integer.parseInt(aD1S21112.getText()) - (Double.parseDouble(cgD1S21112.getText())*0.5) - Integer.parseInt(crD1S21112.getText());
    f3S21112 = (Double.parseDouble(vD2S21112.getText())) +  (Integer.parseInt(gfD2S21112.getText())*3) - Integer.parseInt(gsD2S21112.getText()) 
    		+ Integer.parseInt(aD2S21112.getText()) - (Double.parseDouble(cgD2S21112.getText())*0.5) - Integer.parseInt(crD2S21112.getText());
    f4S21112 = (Double.parseDouble(vD3S21112.getText())) +  (Integer.parseInt(gfD3S21112.getText())*3) - Integer.parseInt(gsD3S21112.getText()) 
    		+ Integer.parseInt(aD3S21112.getText()) - (Double.parseDouble(cgD3S21112.getText())*0.5) - Integer.parseInt(crD3S21112.getText());
    f5S21112 = (Double.parseDouble(vD4S21112.getText())) +  (Integer.parseInt(gfD4S21112.getText())*3) - Integer.parseInt(gsD4S21112.getText()) 
    		+ Integer.parseInt(aD4S21112.getText()) - (Double.parseDouble(cgD4S21112.getText())*0.5) - Integer.parseInt(crD4S21112.getText());
    f6S21112 = (Double.parseDouble(vC1S21112.getText())) +  (Integer.parseInt(gfC1S21112.getText())*3) - Integer.parseInt(gsC1S21112.getText()) 
    		+ Integer.parseInt(aC1S21112.getText()) - (Double.parseDouble(cgC1S21112.getText())*0.5) - Integer.parseInt(crC1S21112.getText());
    f7S21112 = (Double.parseDouble(vC2S21112.getText())) +  (Integer.parseInt(gfC2S21112.getText())*3) - Integer.parseInt(gsC2S21112.getText()) 
    		+ Integer.parseInt(aC2S21112.getText()) - (Double.parseDouble(cgC2S21112.getText())*0.5) - Integer.parseInt(crC2S21112.getText());
    f8S21112 = (Double.parseDouble(vC3S21112.getText())) +  (Integer.parseInt(gfC3S21112.getText())*3) - Integer.parseInt(gsC3S21112.getText()) 
    		+ Integer.parseInt(aC3S21112.getText()) - (Double.parseDouble(cgC3S21112.getText())*0.5) - Integer.parseInt(crC3S21112.getText());
    f9S21112 = (Double.parseDouble(vA1S21112.getText())) +  (Integer.parseInt(gfA1S21112.getText())*3) - Integer.parseInt(gsA1S21112.getText()) 
    		+ Integer.parseInt(aA1S21112.getText()) - (Double.parseDouble(cgA1S21112.getText())*0.5) - Integer.parseInt(crA1S21112.getText());
    f10S21112 = (Double.parseDouble(vA2S21112.getText())) +  (Integer.parseInt(gfA2S21112.getText())*3) - Integer.parseInt(gsA2S21112.getText()) 
    		+ Integer.parseInt(aA2S21112.getText()) - (Double.parseDouble(cgA2S21112.getText())*0.5) - Integer.parseInt(crA2S21112.getText());
    f11S21112 = (Double.parseDouble(vA3S21112.getText())) +  (Integer.parseInt(gfA3S21112.getText())*3) - Integer.parseInt(gsA3S21112.getText()) 
    		+ Integer.parseInt(aA3S21112.getText()) - (Double.parseDouble(cgA3S21112.getText())*0.5) - Integer.parseInt(crA3S21112.getText());
    punteggio21112 = f1S21112+f2S21112+f3S21112+f4S21112+f5S21112+f6S21112+f7S21112+f8S21112+f9S21112+f10S21112+f11S21112;
    
    if (punteggio21112-60 <0) {
    	gol21112 = 0;
    } else {
    	gol21112 = (int)(punteggio21112-60)/6;
    }
    
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS7.getText())) {
    		fpt.updateCasa(this.tabS7.getText(), gol21112, Double.toString(punteggio21112), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS7.getText(), gol21112, Double.toString(punteggio21112), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
    f1S21113 = (Double.parseDouble(vP1S21113.getText())) +  (Integer.parseInt(gfP1S21113.getText())*3) - Integer.parseInt(gsP1S21113.getText()) 
    		+ Integer.parseInt(aP1S21113.getText()) - (Double.parseDouble(cgP1S21113.getText())*0.5) - Integer.parseInt(crP1S21113.getText());
    f2S21113 = (Double.parseDouble(vD1S21113.getText())) +  (Integer.parseInt(gfD1S21113.getText())*3) - Integer.parseInt(gsD1S21113.getText()) 
    		+ Integer.parseInt(aD1S21113.getText()) - (Double.parseDouble(cgD1S21113.getText())*0.5) - Integer.parseInt(crD1S21113.getText());
    f3S21113 = (Double.parseDouble(vD2S21113.getText())) +  (Integer.parseInt(gfD2S21113.getText())*3) - Integer.parseInt(gsD2S21113.getText()) 
    		+ Integer.parseInt(aD2S21113.getText()) - (Double.parseDouble(cgD2S21113.getText())*0.5) - Integer.parseInt(crD2S21113.getText());
    f4S21113 = (Double.parseDouble(vD3S21113.getText())) +  (Integer.parseInt(gfD3S21113.getText())*3) - Integer.parseInt(gsD3S21113.getText()) 
    		+ Integer.parseInt(aD3S21113.getText()) - (Double.parseDouble(cgD3S21113.getText())*0.5) - Integer.parseInt(crD3S21113.getText());
    f5S21113 = (Double.parseDouble(vD4S21113.getText())) +  (Integer.parseInt(gfD4S21113.getText())*3) - Integer.parseInt(gsD4S21113.getText()) 
    		+ Integer.parseInt(aD4S21113.getText()) - (Double.parseDouble(cgD4S21113.getText())*0.5) - Integer.parseInt(crD4S21113.getText());
    f6S21113 = (Double.parseDouble(vC1S21113.getText())) +  (Integer.parseInt(gfC1S21113.getText())*3) - Integer.parseInt(gsC1S21113.getText()) 
    		+ Integer.parseInt(aC1S21113.getText()) - (Double.parseDouble(cgC1S21113.getText())*0.5) - Integer.parseInt(crC1S21113.getText());
    f7S21113 = (Double.parseDouble(vC2S21113.getText())) +  (Integer.parseInt(gfC2S21113.getText())*3) - Integer.parseInt(gsC2S21113.getText()) 
    		+ Integer.parseInt(aC2S21113.getText()) - (Double.parseDouble(cgC2S21113.getText())*0.5) - Integer.parseInt(crC2S21113.getText());
    f8S21113 = (Double.parseDouble(vC3S21113.getText())) +  (Integer.parseInt(gfC3S21113.getText())*3) - Integer.parseInt(gsC3S21113.getText()) 
    		+ Integer.parseInt(aC3S21113.getText()) - (Double.parseDouble(cgC3S21113.getText())*0.5) - Integer.parseInt(crC3S21113.getText());
    f9S21113 = (Double.parseDouble(vA1S21113.getText())) +  (Integer.parseInt(gfA1S21113.getText())*3) - Integer.parseInt(gsA1S21113.getText()) 
    		+ Integer.parseInt(aA1S21113.getText()) - (Double.parseDouble(cgA1S21113.getText())*0.5) - Integer.parseInt(crA1S21113.getText());
    f10S21113 = (Double.parseDouble(vA2S21113.getText())) +  (Integer.parseInt(gfA2S21113.getText())*3) - Integer.parseInt(gsA2S21113.getText()) 
    		+ Integer.parseInt(aA2S21113.getText()) - (Double.parseDouble(cgA2S21113.getText())*0.5) - Integer.parseInt(crA2S21113.getText());
    f11S21113 = (Double.parseDouble(vA3S21113.getText())) +  (Integer.parseInt(gfA3S21113.getText())*3) - Integer.parseInt(gsA3S21113.getText()) 
    		+ Integer.parseInt(aA3S21113.getText()) - (Double.parseDouble(cgA3S21113.getText())*0.5) - Integer.parseInt(crA3S21113.getText());
    punteggio21113 = f1S21113+f2S21113+f3S21113+f4S21113+f5S21113+f6S21113+f7S21113+f8S21113+f9S21113+f10S21113+f11S21113;
    
    if (punteggio21113-60 <0) {
    	gol21113 = 0;
    } else {
    	gol21113 = (int)(punteggio21113-60)/6;
    }
    
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getFantaSquadraCasa().equals(this.tabS8.getText())) {
    		fpt.updateCasa(this.tabS8.getText(), gol21113, Double.toString(punteggio21113), this.boxGiornate.getSelectionModel().getSelectedItem());
    	} else {
    		fpt.updateTrasferta(this.tabS8.getText(), gol21113, Double.toString(punteggio21113), this.boxGiornate.getSelectionModel().getSelectedItem());
    	}
    } 
       
    for (FantaPartita f : fpt.selectFantaPartite(this.boxGiornate.getSelectionModel().getSelectedItem(), idLega)) {
    	if (f.getGolCasa() > f.getGolTrasferta()) {
    		fst.updateVittora(f.getFantaSquadraCasa(), idLega, f.getPunteggioCasa());
    		fst.updateSconfitta(f.getFantaSquadraTrasferta(), idLega, f.getPunteggioTrasferta());
    	} else if (f.getGolCasa().equals(f.getGolTrasferta())) {
    		fst.updatePareggio(f.getFantaSquadraCasa(), idLega, f.getPunteggioCasa());
    		fst.updatePareggio(f.getFantaSquadraTrasferta(), idLega, f.getPunteggioTrasferta());
    	} else {
    		fst.updateVittora(f.getFantaSquadraTrasferta(), idLega, f.getPunteggioTrasferta());
    		fst.updateSconfitta(f.getFantaSquadraCasa(), idLega, f.getPunteggioCasa());
    	}
    }
    
    //tab1
    int formazione = fft.selectIdFantaFormazione(this.tabS1.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S1.getText()), Integer.parseInt(aA1S1.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S1.getText()), Integer.parseInt(aA2S1.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S1.getText()), Integer.parseInt(aA3S1.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S1.getText()), Integer.parseInt(aC1S1.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S1.getText()), Integer.parseInt(aC2S1.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S1.getText()), Integer.parseInt(aC3S1.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S1.getText()), Integer.parseInt(aD1S1.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S1.getText()), Integer.parseInt(aD2S1.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S1.getText()), Integer.parseInt(aD3S1.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S1.getText()), Integer.parseInt(aD4S1.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S1.getText()), Integer.parseInt(gsP1S1.getText()));
    
    //tab2
    formazione = fft.selectIdFantaFormazione(this.tabS2.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S2.getText()), Integer.parseInt(aA1S2.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S2.getText()), Integer.parseInt(aA2S2.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S2.getText()), Integer.parseInt(aA3S2.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S2.getText()), Integer.parseInt(aC1S2.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S2.getText()), Integer.parseInt(aC2S2.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S2.getText()), Integer.parseInt(aC3S2.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S2.getText()), Integer.parseInt(aD1S2.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S2.getText()), Integer.parseInt(aD2S2.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S2.getText()), Integer.parseInt(aD3S2.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S2.getText()), Integer.parseInt(aD4S2.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S2.getText()), Integer.parseInt(gsP1S2.getText()));
    
  //tab3
    formazione = fft.selectIdFantaFormazione(this.tabS3.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S21.getText()), Integer.parseInt(aA1S21.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S21.getText()), Integer.parseInt(aA2S21.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S21.getText()), Integer.parseInt(aA3S21.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S21.getText()), Integer.parseInt(aC1S21.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S21.getText()), Integer.parseInt(aC2S21.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S21.getText()), Integer.parseInt(aC3S21.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S21.getText()), Integer.parseInt(aD1S21.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S21.getText()), Integer.parseInt(aD2S21.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S21.getText()), Integer.parseInt(aD3S21.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S21.getText()), Integer.parseInt(aD4S21.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S21.getText()), Integer.parseInt(gsP1S21.getText()));
    
    //tab4
    formazione = fft.selectIdFantaFormazione(this.tabS4.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S211.getText()), Integer.parseInt(aA1S211.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S211.getText()), Integer.parseInt(aA2S211.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S211.getText()), Integer.parseInt(aA3S211.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S211.getText()), Integer.parseInt(aC1S211.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S211.getText()), Integer.parseInt(aC2S211.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S211.getText()), Integer.parseInt(aC3S211.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S211.getText()), Integer.parseInt(aD1S211.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S211.getText()), Integer.parseInt(aD2S211.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S211.getText()), Integer.parseInt(aD3S211.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S211.getText()), Integer.parseInt(aD4S211.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S211.getText()), Integer.parseInt(gsP1S211.getText()));
    
    //tab5
    formazione = fft.selectIdFantaFormazione(this.tabS5.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S2111.getText()), Integer.parseInt(aA1S2111.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S2111.getText()), Integer.parseInt(aA2S2111.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S2111.getText()), Integer.parseInt(aA3S2111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S2111.getText()), Integer.parseInt(aC1S2111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S2111.getText()), Integer.parseInt(aC2S2111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S2111.getText()), Integer.parseInt(aC3S2111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S2111.getText()), Integer.parseInt(aD1S2111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S2111.getText()), Integer.parseInt(aD2S2111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S2111.getText()), Integer.parseInt(aD3S2111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S2111.getText()), Integer.parseInt(aD4S2111.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S2111.getText()), Integer.parseInt(gsP1S2111.getText()));
    
    //tab6
    formazione = fft.selectIdFantaFormazione(this.tabS6.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S21111.getText()), Integer.parseInt(aA1S21111.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S21111.getText()), Integer.parseInt(aA2S21111.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S21111.getText()), Integer.parseInt(aA3S21111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S21111.getText()), Integer.parseInt(aC1S21111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S21111.getText()), Integer.parseInt(aC2S21111.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S21111.getText()), Integer.parseInt(aC3S21111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S21111.getText()), Integer.parseInt(aD1S21111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S21111.getText()), Integer.parseInt(aD2S21111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S21111.getText()), Integer.parseInt(aD3S21111.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S21111.getText()), Integer.parseInt(aD4S21111.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S21111.getText()), Integer.parseInt(gsP1S21111.getText()));
    
    //tab7
    formazione = fft.selectIdFantaFormazione(this.tabS7.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S21112.getText()), Integer.parseInt(aA1S21112.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S21112.getText()), Integer.parseInt(aA2S21112.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S21112.getText()), Integer.parseInt(aA3S21112.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S21112.getText()), Integer.parseInt(aC1S21112.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S21112.getText()), Integer.parseInt(aC2S21112.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S21112.getText()), Integer.parseInt(aC3S21112.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S21112.getText()), Integer.parseInt(aD1S21112.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S21112.getText()), Integer.parseInt(aD2S21112.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S21112.getText()), Integer.parseInt(aD3S21112.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S21112.getText()), Integer.parseInt(aD4S21112.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S21112.getText()), Integer.parseInt(gsP1S21112.getText()));
    
    //tab8
    formazione = fft.selectIdFantaFormazione(this.tabS8.getText(), this.boxGiornate.getSelectionModel().getSelectedItem());
    at.updateAttaccante(at.selectInserimenti(formazione).get(0).getAttaccante(), Integer.parseInt(gfA1S21113.getText()), Integer.parseInt(aA1S21113.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(1).getAttaccante(), Integer.parseInt(gfA2S21113.getText()), Integer.parseInt(aA2S21113.getText()));
    at.updateAttaccante(at.selectInserimenti(formazione).get(2).getAttaccante(), Integer.parseInt(gfA3S21113.getText()), Integer.parseInt(aA3S21113.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(0).getCentrocampista(), Integer.parseInt(gfC1S21113.getText()), Integer.parseInt(aC1S21113.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(1).getCentrocampista(), Integer.parseInt(gfC2S21113.getText()), Integer.parseInt(aC2S21113.getText()));
    ct.updateCentrocampista(ct.selectInserimenti(formazione).get(2).getCentrocampista(), Integer.parseInt(gfC3S21113.getText()), Integer.parseInt(aC3S21113.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(0).getDifensore(), Integer.parseInt(gfD1S21113.getText()), Integer.parseInt(aD1S21113.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(1).getDifensore(), Integer.parseInt(gfD2S21113.getText()), Integer.parseInt(aD2S21113.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(2).getDifensore(), Integer.parseInt(gfD3S21113.getText()), Integer.parseInt(aD3S21113.getText()));
    dt.updateDifensore(dt.selectInserimenti(formazione).get(3).getDifensore(), Integer.parseInt(gfD4S21113.getText()), Integer.parseInt(aD4S21113.getText()));
    pt.updatePortiere(pt.selectInserimenti(formazione).get(0).getPortiere(), Integer.parseInt(gfP1S21113.getText()), Integer.parseInt(gsP1S21113.getText()));
    
    }

}
