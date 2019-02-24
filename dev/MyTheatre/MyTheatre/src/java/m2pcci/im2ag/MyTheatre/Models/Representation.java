/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2pcci.im2ag.MyTheatre.Models;

/**
 *
 * @author sedirih
 */
public class Representation {
    String dateRep;
    int noSepctacle;
    int nbrePlace;
    int nbrPlacesRestantes;

    public Representation(String dateRep, int noSepctacle, int nbrePlace) {
        this.dateRep = dateRep;
        this.noSepctacle = noSepctacle;
        this.nbrePlace = nbrePlace;
    }
     public Representation(String dateRep, int noSepctacle) {
        this.dateRep = dateRep;
        this.noSepctacle = noSepctacle;
      
    }

    public String getDateRep() {
        return dateRep;
    }

    public int getNoSpectacle() {
        return noSepctacle;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }
  
    @Override
    public String toString() {
        return "Representation{" + "dateRep=" + dateRep + ", noSepctacle=" + noSepctacle + ", nbrePlace=" + nbrePlace + '}';
    }
    
    
    
}
