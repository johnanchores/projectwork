package dev2426.ITSProjectWork.model;

import java.util.Objects;

public class TirocinioGUI {
    private Azienda azienda;
    private Tirocinio tirocinio;

    public TirocinioGUI() {
    }

    public TirocinioGUI(Azienda azienda, Tirocinio tirocinio) {
        this.azienda = azienda;
        this.tirocinio = tirocinio;
    }

    public Azienda getAzienda() {
        return this.azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    public Tirocinio getTirocinio() {
        return this.tirocinio;
    }

    public void setTirocinio(Tirocinio tirocinio) {
        this.tirocinio = tirocinio;
    }

    public TirocinioGUI azienda(Azienda azienda) {
        setAzienda(azienda);
        return this;
    }

    public TirocinioGUI tirocinio(Tirocinio tirocinio) {
        setTirocinio(tirocinio);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TirocinioGUI)) {
            return false;
        }
        TirocinioGUI tirocinioGUI = (TirocinioGUI) o;
        return Objects.equals(azienda, tirocinioGUI.azienda) && Objects.equals(tirocinio, tirocinioGUI.tirocinio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(azienda, tirocinio);
    }

    @Override
    public String toString() {
        return "{" +
                " azienda='" + getAzienda() + "'" +
                ", tirocinio='" + getTirocinio() + "'" +
                "}";
    }

}
