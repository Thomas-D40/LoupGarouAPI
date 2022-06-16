/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.loupgarou.entities;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Tom
 */
public class Annuaire {
    
    private ArrayList<Villageois> listOfVillageois = new ArrayList<>();
    private long lastId = 1;

    public Annuaire() {
    }

    public ArrayList<Villageois> getListOfVillageois() {
        return listOfVillageois;
    }
    
    public Optional<Villageois> getVillageoisById(long id){
        for (Villageois v:listOfVillageois) {
            if (v.getId() == id) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }
    
    public void addVillageois(Villageois villageois) {
        villageois.setId(lastId);
        lastId ++;
        listOfVillageois.add(villageois);        
    }
    
    public void updateVillageois(Villageois villageois) {
        for (Villageois v:listOfVillageois) {
            if (v.getId() == villageois.getId()) {
              listOfVillageois.set(listOfVillageois.indexOf(v), villageois);
            }
        }
        
        
    }
    
    public void deleteVillageoisById(long id) {
        
        for (Villageois v:listOfVillageois) {
            if (v.getId() == id) {
              listOfVillageois.remove(v);
              break;
            }
        }        
    }

    public void setListOfVillageois(ArrayList<Villageois> listOfVillageois) {
        this.listOfVillageois = listOfVillageois;
    }

    public long getLastId() {
        return lastId;
    }

    public void setLastId(long lastId) {
        this.lastId = lastId;
    }
    
    
    
}
