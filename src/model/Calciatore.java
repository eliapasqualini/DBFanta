package model;

public class Calciatore {
    
    private Integer idCalciatore;
    private String nome;
    private String cognome;
    private String ruolo;
    private String squadra;
    
    public Calciatore() {}
    
    public Integer getCalciatore() {
        return this.idCalciatore;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getCognome() {
        return this.cognome;
    }
        
    public String getRuolo() {
        return this.ruolo;
    }
    
    public String getSquadra() {
        return this.squadra;
    }
    
    public void setCalciatore(Integer id) {
        this.idCalciatore = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
   
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }
    
    public String toString() {
    	return this.nome+" "+this.cognome;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((idCalciatore == null) ? 0 : idCalciatore.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
        result = prime * result + ((squadra == null) ? 0 : squadra.hashCode());
        return result;
    }

    public boolean equals(Object o){
        if (o == null || !(o instanceof Calciatore)){
        return false; }
        return this.nome.equals(((Calciatore)o).nome) && 
                this.cognome == ((Calciatore)o).cognome;
        }

}
