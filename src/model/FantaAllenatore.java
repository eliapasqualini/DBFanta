package model;

public class FantaAllenatore {
    
    private Integer idAllenatore;
    private String nome;
    private String cognome;
    
    public FantaAllenatore() {}
    
    public Integer getAllenatore() {
        return this.idAllenatore;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCognome() {
        return this.cognome;
    }

    public void setAllenatore(Integer id) {
        this.idAllenatore = id;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}
