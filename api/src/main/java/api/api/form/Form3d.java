package api.api.form;

public class Form3d {
    Form forme;
    double profondeur;
    double param1;
    double param2;
    String nom;

    


    public Form3d(String nom, Form forme, double profondeur,double param1, double param2) {
        this.forme = forme;
        this.profondeur = profondeur;
        this.param1 = param1;
        this.param2 = param2;
        this.nom = nom;
    }

    public Form getForme() {
        return this.forme;
    }

    public double getProfondeur() {
        return this.profondeur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setForme(Form forme) {
        this.forme = forme;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }




   
    public double getVolume() {
        if (param1 > 0 && param2 == 0 ){
            return 4/3*Math.PI*param1*param1*param1;
        }else if (param1 > 0 && param2 > 0){
            double hypbase = Math.sqrt(param2*param2 + param2*param2)/2;
            double hyphauteur = Math.sqrt((param2 * param2) - (hypbase * hypbase) );
            return (param1 * param1 * hyphauteur)/3 ;
        }else{
            return this.getForme().getAir() * this.getProfondeur();
        }
    }

    public String toString() {
        System.out.println( this.forme.toString());
        return getNom()+"\n"+"la profondeur est = "+ getProfondeur()+ " cm"+ "\n" +"volume = " + this.getVolume() +" cm³"+ "\n"+"Fermer les yeux et imaginer la forme 3D" + "\n";
    }
}
