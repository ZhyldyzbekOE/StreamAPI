package com.company.models;
import com.company.enums.AbonentStatus;
public class Person implements Comparable<Person>{

    private String name;
    private AbonentStatus abonentStatus;
    private double moneyOnPhone;

    public Person(String name, AbonentStatus abonentStatus, double moneyOnPhone) {
        this.name = name;
        this.abonentStatus = abonentStatus;
        this.moneyOnPhone = moneyOnPhone;
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

    public double getMoneyOnPhone() {
        return moneyOnPhone;
    }

    public void setMoneyOnPhone(double moneyOnPhone) {
        this.moneyOnPhone = moneyOnPhone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", abonentStatus=" + abonentStatus +
                ", moneyOnPhone=" + moneyOnPhone +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.getMoneyOnPhone() == o.getMoneyOnPhone()){
            if (this.getAbonentStatus().equals(o.abonentStatus)){
                return 0;
            }
        }if(this.getMoneyOnPhone() > o.getMoneyOnPhone()){
            if (this.getAbonentStatus().equals(AbonentStatus.ACTIVE)){
                return -1;
            }
        }
        return 1;

    }
}

