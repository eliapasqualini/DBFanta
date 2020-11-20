package model;

public class FantaPartita {
    
    private String fantaSquadraCasa;
    private String fantaSquadraTrasferta;
    private Integer giornata;
    private Integer golCasa;
    private Integer golTrasferta;
    private String punteggioCasa;
    private String punteggioTrasferta;
    private Integer fantaFormazioneCasa;
    private Integer fantaFormazioneTrasferta;
    
    public FantaPartita() {}
    
    public String getFantaSquadraCasa() {
        return this.fantaSquadraCasa;
    }
    
    public String getFantaSquadraTrasferta() {
        return this.fantaSquadraTrasferta;
    }
    
    public Integer getGiornata() {
        return this.giornata;
    }
    
    public Integer getGolCasa() {
        return this.golCasa;
    }
    
    public Integer getGolTrasferta() {
        return this.golTrasferta;
    }
    
    public String getPunteggioCasa() {
        return this.punteggioCasa;
    }
    
    public String getPunteggioTrasferta() {
        return this.punteggioTrasferta;
    }
    
    public Integer getFantaFormazioneCasa() {
        return this.fantaFormazioneCasa;
    }
    
    public Integer getFantaFormazioneTrasferta() {
        return this.fantaFormazioneTrasferta;
    }
    
    public void setFantaSquadraCasa(String nome) {
        this.fantaSquadraCasa = nome;
    }
    
    public void setFantaSquadraTrasferta(String nome) {
        this.fantaSquadraTrasferta = nome;
    }
    
    public void setGiornata(Integer value) {
        this.giornata = value;
    }
    
    public void setGolCasa(Integer value) {
        this.golCasa = value;
    }
    
    public void setGolTrasferta(Integer value) {
        this.golTrasferta = value;
    }
    
    public void setPunteggioCasa(String i) {
        this.punteggioCasa = i;
    }
    
    public void setPunteggioTrasferta(String value) {
        this.punteggioTrasferta = value;
    }
    
    public void setFantaFormazioneCasa(Integer id) {
        this.fantaFormazioneCasa = id;
    }
    
    public void setFantaFormazioneTrasferta(Integer id) {
        this.fantaFormazioneTrasferta = id;
    }

}
