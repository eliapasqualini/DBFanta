package model;

public class Attaccante {
    
    private Integer idFantaCalciatore;
    private Integer fantaLega;
    private Integer calciatore;
    private Integer gol;
    private Integer assist;
    private String fantaSquadra;
    
    public Attaccante() {}
    
    public Integer getFantaCalciatore() {
        return this.idFantaCalciatore;
    }
    
    public Integer getFantaLega() {
        return this.fantaLega;
    }
    
    public Integer getCalciatore() {
        return this.calciatore;
    }
    
    public Integer getGol() {
        return this.gol;
    }
    
    public Integer getAssist() {
        return this.assist;
    }
    
    public String getFantaSquadra() {
        return this.fantaSquadra;
    }

    public void setFantaCalciatore(Integer id) {
        this.idFantaCalciatore = id;
    }
    
    public void setFantaLega(Integer id) {
        this.fantaLega = id;
    }
    
    public void setGol(Integer value) {
        this.gol = value;
    }
    
    public void setAssist(Integer value) {
        this.assist = value;
    }
    
    public void setFantaSquadra(String fantasquadra) {
        this.fantaSquadra = fantasquadra;
    }
}
