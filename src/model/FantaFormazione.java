package model;

public class FantaFormazione {

    private Integer idFantaFormazione;
    private String fantaSquadra;
    private Integer giornata;
    
    public FantaFormazione() {}
    
    public Integer getFantaFormazione() {
        return this.idFantaFormazione;
    }
    
    public String getFantaSquadra() {
        return this.fantaSquadra;
    }
    
    public Integer getGiornata() {
        return this.giornata;
    }
    
    public void setFantaFormazione(Integer id) {
        this.idFantaFormazione = id;
    }
    
    public void setFantaSquadra(String nome) {
        this.fantaSquadra = nome;
    }
    
    public void setGiornata(Integer value) {
        this.giornata = value;
    }
}
