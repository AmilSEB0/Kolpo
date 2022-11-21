package api.api.form;


import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Rectangle extends Form {


    double longueur;

    double largeur;

    private int list_form;

    public Rectangle(double longueur,double largeur, int list_form){
    this.longueur = longueur;
    this.largeur = largeur;
    this.list_form = list_form;
    }

    public Rectangle() {

    }

    @Override
    @Transient
    public double getPerimetre() {
        return  2 * (longueur + largeur);
    }

    @Override
    @Transient
    public double getAir() {
        return  longueur * largeur ;
    }


    public double getLargeur() {
        return largeur;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    @Override
   public String toString(){
    return "-------------------"+ "\n" +"Rectangle :" + "\n" +"largeur = " + getLargeur() + " cm" + "\n" + "longueur = " + getLongueur() + " cm" + "\n" + "périmètre = " + getPerimetre() + " cm"  + "\n" + "air = " + getAir()  + " cm²" + "\n" +"      +++++++++++++++           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +             +           "+ "\n" +"      +++++++++++++++           ";
   }

}
