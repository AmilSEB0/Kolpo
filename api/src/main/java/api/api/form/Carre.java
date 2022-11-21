package api.api.form;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Carre extends Form {

   
    double cote;

    private int list_form;

    public Carre(double cote, int list_form){
        this.cote = cote;
        this.list_form = list_form;
    }

    public Carre() {

    }

    @Override
    @Transient
    public double getPerimetre() {
        return 4 * cote;
    }

    @Override
    @Transient
    public double getAir() {
        return  cote * cote;
    }

    
    public double getProfondeur() {
        return  cote;
    }
    
     public void setProfondeur(double carre_cote) {
        this.cote = carre_cote;
    }


    public double getCote() {
        return cote;
    }

    public void setCote(double longueur) {
        this.cote = longueur;
    }
    

    @Override
   public String toString(){
    return "-------------------"+ "\n" +"Carré :" + "\n" +"côté = " + cote + "cm"+ "\n" +"périmètre = " + getPerimetre() + "cm"+ "\n" +"air = " + getAir() + "cm²"+ "\n" +"      ++++++++++++++++           "+ "\n" +"      +              +           "+ "\n" +"      +              +           "+ "\n" +"      +              +           "+ "\n" +"      +              +           "+ "\n" +"      +              +           "+ "\n" +"      +              +           "+ "\n" +"      ++++++++++++++++           ";
   }

}