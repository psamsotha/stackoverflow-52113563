package com.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auftrag")
public class Auftrag {

    private int id;
    private int nr;
    private String Auftragsname;

    public Auftrag() {

    }

    public Auftrag(int id, int nr, String auftragsname) {
        super();
        this.id = id;
        this.nr = nr;
        Auftragsname = auftragsname;
    }


    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public int getNr() {
        return nr;
    }

    @XmlElement
    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getAuftragsname() {
        return Auftragsname;
    }

    @XmlElement
    public void setAuftragsname(String auftragsname) {
        Auftragsname = auftragsname;
    }


    @Override
    public String toString() {
        return "Auftrag{" +
                "id=" + id +
                ", nr=" + nr +
                ", Auftragsname='" + Auftragsname + '\'' +
                '}';
    }
}
