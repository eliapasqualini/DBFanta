package model;

public class FantaLega {
    
    private Integer idLega;
    private String nome;
    private Integer campionato;
    
    public FantaLega() {}
    
    public Integer getLega() {
        return this.idLega;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Integer getCampionato() {
        return this.campionato;
    }

    public void setLega(Integer id) {
        this.idLega = id;
    }
    
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public void setCampionato(Integer id) {
        this.campionato = id;
    }

}
