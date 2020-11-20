package model;

public class Partecipazione {
    
    private Integer campionato;
    private Integer lega;
    
    public Partecipazione() {}
    
    public Integer getCampionato() {
        return this.campionato;
    }

    public Integer getLega() {
        return this.lega;
    }
    
    public void setCampionato(Integer id) {
        this.campionato = id;
    }
    
    public void setLega(Integer id) {
        this.lega = id;
    }
}


