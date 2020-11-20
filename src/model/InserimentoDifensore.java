package model;

public class InserimentoDifensore {

    private Integer difensore;
    private Integer fantaFormazione;
    private String voto;
    private Integer gol;
    private Integer assist;
    private Integer cartelliniGialli;
    private Integer cartelliniRossi;
    
    public InserimentoDifensore() {}
    
    public Integer getDifensore() {
        return this.difensore;
    }
    
    public Integer getFantaFormazione() {
        return this.fantaFormazione;
    }
    
    public String getVoto() {
        return this.voto;
    }
    
    public Integer getGol() {
        return this.gol;
    }
    
    public Integer getAssist() {
        return this.assist;
    }
    
    public Integer getCartelliniGialli() {
        return this.cartelliniGialli;
    }
    
    public Integer getCartelliniRossi() {
        return this.cartelliniRossi;
    }
    
    public void setDifensore(Integer id) {
        this.difensore = id;
    }
    
    public void setFantaFormazione(Integer id) {
        this.fantaFormazione = id;
    }
    
    public void setVoto(String value) {
        this.voto = value;
    }
    
    public void setGol(Integer value) {
        this.gol = value;
    }
    
    public void setAssist(Integer value) {
        this.assist = value;
    }
    
    public void setCartelliniGialli(Integer value) {
        this.cartelliniGialli = value;
    }
    
    public void setCartelliniRossi(Integer value) {
        this.cartelliniRossi = value;
    }
}
