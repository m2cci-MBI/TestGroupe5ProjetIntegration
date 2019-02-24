/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2pcci.im2ag.MyTheatre.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sediri
 */
public class Spectacle implements Iterable<Representation> {

    public int numS;
    public String nomS;
    public List<Representation> lesRep;

    public Spectacle(int numS, String nomS) {
        this.numS = numS;
        this.nomS = nomS;
        lesRep = new ArrayList<>();

    }

    public void addRepresentation(Representation rep) {
        lesRep.add(rep);
    }

    public int getNbRepresentations() {
        return lesRep.size();
    }

    public int getNumS() {
        return numS;
    }

    public List<Representation> getLesRep() {
        return lesRep;
    }

    @Override
    public String toString() {
        return "Spectacle{" + "numS=" + numS + ", nomS=" + nomS + '}';
    }

    @Override
    public Iterator<Representation> iterator() {
        return lesRep.iterator();
    }

    public Representation getRepresentation(int index) {
        return lesRep.get(index);
    }

    public String getNomS() {
        return nomS;
    }

}
