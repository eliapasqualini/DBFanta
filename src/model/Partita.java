package model;

public class Partita {
    
    private String squadraCasa;
    private String squadraTrasferta;
    private Integer campionato;
    private Integer giornata;
    
    public Partita() {}
    
    public String getSquadraCasa() {
        return this.squadraCasa;
    }
    
    public String getSquadraTrasferta() {
        return this.squadraTrasferta;
    }
    
    public Integer getCampionato() {
        return this.campionato;
    }
    
    public Integer getGiornata() {
        return this.giornata;
    }
    
    public void setSquadraCasa(String squadra) {
        this.squadraCasa = squadra;
    }
    
    public void setSquadraTrasferta(String squadra) {
        this.squadraTrasferta = squadra;
    }
    
    public void setCampionato(Integer campionato) {
        this.campionato = campionato;
    }
    
    public void setGiornata(Integer giornata) {
        this.giornata = giornata;
    }

}
