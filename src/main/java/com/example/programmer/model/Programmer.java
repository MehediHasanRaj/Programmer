package com.example.programmer.model;

import jakarta.persistence.*;

@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pId;
    @Column(name = "Programmer Name") // we can rename by using
    private String pName;
    private String pLan;

    public Programmer(){
        super();
    }

    public Programmer(int pId, String pName, String pLan) {
        this.pId = pId;
        this.pName = pName;
        this.pLan = pLan;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpLan() {
        return pLan;
    }

    public void setpLan(String pLan) {
        this.pLan = pLan;
    }
}
