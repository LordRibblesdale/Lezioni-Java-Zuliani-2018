import java.io.*;

class Creatura implements Serializable {
    private String nome, razza, descrizione;
    private int forza, destrezza, intelligenza;
    private boolean alleato;

    Creatura(String nome, String razza, String descrizione, int forza, int destrezza, int intelligenza, boolean alleato) {
        this.nome = nome;
        this.razza = razza;
        this.descrizione = descrizione;
        this.forza = forza;
        this.destrezza = destrezza;
        this.intelligenza = intelligenza;
        this.alleato = alleato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getDestrezza() {
        return destrezza;
    }

    public void setDestrezza(int destrezza) {
        this.destrezza = destrezza;
    }

    public int getIntelligenza() {
        return intelligenza;
    }

    public void setIntelligenza(int intelligenza) {
        this.intelligenza = intelligenza;
    }

    public boolean isAlleato() {
        return alleato;
    }

    public void setAlleato(boolean alleato) {
        this.alleato = alleato;
    }
}
