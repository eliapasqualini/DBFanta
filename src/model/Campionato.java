package model;

public class Campionato {
    
    private Integer idCampionato;
    private String nome;
    
    public Campionato() {}
    
    public Integer getCampionato() {
        return this.idCampionato;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setCampionato(Integer id) {
        this.idCampionato = id;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
}
