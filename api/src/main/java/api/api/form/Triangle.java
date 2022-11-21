package api.api.form;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Triangle extends Form {

    double base;
    double cote;

    private int list_form;


    public Triangle( double base, double cote, int list_form) {
       this.base = base;
       this.cote = cote;
       this.list_form = list_form;
    }

    public Triangle() {

    }

    @Override
    @Transient
   public double getAir() {
        return (base * getHauteur()) / 2;
    }

    
    @Override
    @Transient
    public double getPerimetre() {
        return base + cote * 2;
    }

    public double getCote() {
        return cote;
    }

    public double getBase() {
        return  base;
    }


    @Transient
    public double getHauteur(){
        double hauteur = Math.sqrt((cote*cote)-(base/2*base/2));
        return hauteur;
    }

    public void setCote(double cote) {
        this.cote = cote;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
   @Override
   public String toString(){
    return "-------------------"+ "\n" +"Triangle : " + "\n" + "côté = " + getCote() + " cm"+ "\n" + "base = " + getBase() + " cm" + "\n" +"périmètre = " + getPerimetre() + " cm" + "\n" +"air = " + getAir() + " cm²" + "\n" +"             +            "+ "\n" +"           +   +           "+ "\n" +"          +     +           "+ "\n" +"         +       +           "+ "\n" +"        +         +           "+ "\n" +"       +           +           "+ "\n" +"      +++++++++++++++           ";
   }

}