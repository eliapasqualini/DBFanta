package model;

public class InserimentoPortiere {
    
    private Integer portiere;
    private Integer fantaFormazione;
    private String voto;
    private Integer golSubiti;
    private Integer rigoriParati;
    private Integer cartelliniGialli;
    private Integer cartelliniRossi;
    
    public InserimentoPortiere() {}
    
    public Integer getPortiere() {
        return this.portiere;
    }
    
    public Integer getFantaFormazione() {
        return this.fantaFormazione;
    }
    
    public String getVoto() {
        return this.voto;
    }
    
    public Integer getGolSubiti() {
        return this.golSubiti;
    }
    
    public Integer getRigoriParati() {
        return this.rigoriParati;
    }
    
    public Integer getCartelliniGialli() {
        return this.cartelliniGialli;
    }
    
    public Integer getCartelliniRossi() {
        return this.cartelliniRossi;
    }
    
    public void setPortiere(Integer id) {
        this.portiere = id;
    }
    
    public void setFantaFormazione(Integer id) {
        this.fantaFormazione = id;
    }
    
    public void setVoto(String value) {
        this.voto = value;
    }
    
    public void setGolSubiti(Integer value) {
        this.golSubiti = value;
    }
    
    public void setRigoriParati(Integer value) {
        this.rigoriParati = value;
    }
    
    public void setCartelliniGialli(Integer value) {
        this.cartelliniGialli = value;
    }
    
    public void setCartelliniRossi(Integer value) {
        this.cartelliniRossi = value;
    }

}
