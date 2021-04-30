package com.company.models;

import com.company.enums.AbonentStatus;

import java.util.List;

public class People {

    private String name;
    private AbonentStatus abonentStatus;
    private List<String> abonentTelephones;

    public People(String name, AbonentStatus abonentStatus, List<String> abonentTelephones) {
        this.name = name;
        this.abonentStatus = abonentStatus;
        this.abonentTelephones = abonentTelephones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbonentStatus getAbonentStatus() {
        return abonentStatus;
    }

    public void setAbonentStatus(AbonentStatus abonentStatus) {
        this.abonentStatus = abonentStatus;
    }

    public List<String> getAbonentTelephones() {
        return abonentTelephones;
    }

    public void setAbonentTelephones(List<String> abonentTelephones) {
        this.abonentTelephones = abonentTelephones;
    }
}