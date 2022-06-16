/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.loupgarou.entities;

/**
 *
 * @author Tom
 */
public class Villageois {
    
    private long id;
    private String nom;
    private boolean isLoupGarou;
    private Profession profession;
    private boolean isAlive;
    private boolean isSleeping;
    private boolean isMayor;

    public Villageois() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isIsLoupGarou() {
        return isLoupGarou;
    }

    public void setIsLoupGarou(boolean isLoupGarou) {
        this.isLoupGarou = isLoupGarou;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isIsSleeping() {
        return isSleeping;
    }

    public void setIsSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public boolean isIsMayor() {
        return isMayor;
    }

    public void setIsMayor(boolean isMayor) {
        this.isMayor = isMayor;
    }

    @Override
    public String toString() {
        return "Villageois{" + "id=" + id + ", nom=" + nom + ", isLoupGarou=" + isLoupGarou + ", profession=" + profession + ", isAlive=" + isAlive + ", isSleeping=" + isSleeping + ", isMayor=" + isMayor + '}';
    }

   
    
}
