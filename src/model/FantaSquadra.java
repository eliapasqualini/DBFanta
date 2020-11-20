package model;

public class FantaSquadra {
    
    private String nome;
    private Integer fantaAllenatore;
    private Integer fantaLega;
    private Integer partiteGiocate;
    private Integer vittorie;
    private Integer pareggi;
    private Integer sconfitte;
    private Integer punti;
    private String punteggio;
    
    public FantaSquadra() {}
     
    public String getNome() {
        return this.nome;
    }
    
    public Integer getFantaAllenatore() {
        return this.fantaAllenatore;
    }
    
    public Integer getFantaLega() {
        return this.fantaLega;
    }
    
    public Integer getPartiteGiocate() {
        return this.partiteGiocate;
    }
    
    public Integer getVittorie() {
        return this.vittorie;
    }
    
    public Integer getPareggi() {
        return this.pareggi;
    }
    
    public Integer getSconfitte() {
        return this.sconfitte;
    }
    
    public Integer getPunti() {
        return this.punti;
    }

    public String getPunteggio() {
        return this.punteggio;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public void setFantaAllenatore(Integer id) {
        this.fantaAllenatore = id;
    }
    
    public void setFantaLega(Integer id) {
        this.fantaLega = id;
    }
    
    public void setPartiteGiocate(Integer value) {
        this.partiteGiocate = value;
    }
    
    public void setVittorie(Integer value) {
        this.vittorie = value;
    }
    
    public void setPareggi(Integer value) {
        this.pareggi = value;
    }
    
    public void setSconfitte(Integer value) {
        this.sconfitte = value;
    }
    
    public void setPunti(Integer value) {
        this.punti = value;
    }
    
    public void setPunteggio(String value) {
        this.punteggio = value;
    }
    
    public String toString() {
		return this.nome+" "+this.partiteGiocate+" "+this.vittorie+" "+this.pareggi+
				" "+this.sconfitte+" "+this.punti+" "+this.punteggio+"\n";
    	
    }

}
