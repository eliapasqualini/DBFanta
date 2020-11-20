package model;

public class Portiere {
    
    private Integer idFantaCalciatore;
    private Integer fantaLega;
    private Integer calciatore;
    private Integer golSubiti;
    private Integer rigoriParati;
    private String fantaSquadra;
    
    public Portiere() {}
    
    public Integer getFantaCalciatore() {
        return this.idFantaCalciatore;
    }
    
    public Integer getFantaLega() {
        return this.fantaLega;
    }
    
    public Integer getCalciatore() {
        return this.calciatore;
    }
    
    public Integer getGolSubiti() {
        return this.golSubiti;
    }
    
    public Integer getRigoriParati() {
        return this.rigoriParati;
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
    
    public void setGolSubiti(Integer value) {
        this.golSubiti = value;
    }
    
    public void setRigoriParati(Integer value) {
        this.rigoriParati = value;
    }
    
    public void setFantaSquadra(String fantasquadra) {
        this.fantaSquadra = fantasquadra;
    }

}
