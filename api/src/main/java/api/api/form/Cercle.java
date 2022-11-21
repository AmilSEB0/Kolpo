package api.api.form;


import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Cercle extends Form {


  //  @Column(name = "rayon")
    double rayon;

    private int list_form;

    public Cercle( double rayon, int list_form) {
        this.rayon = rayon;
        this.list_form = list_form;
    }

    public Cercle() {

    }

    @Override
    @Transient
       public double getPerimetre(){
        return 2 * rayon * Math.PI;
       }

       @Override
       @Transient
        public double getAir() {
            return 4*Math.PI*rayon*rayon;
        }

        public double getRayon() {
            return rayon;
        }
    
        public void setRayon(double rayon) {
            this.rayon = rayon;
        }

       @Override
       public String toString(){
        return "-------------------"+ "\n" +"Cercle : " + "\n" +"rayon = " + getRayon() + " cm" +"\n" +"périmètre = " + getPerimetre() + " cm"+ "\n" +"air = " + getAir() + " cm²" + "\n" +"             +            "+ "\n" +"       +           +           "+ "\n" +"   +                   +           "+ "\n" +"  +                      +           "+ "\n" +" +                        +           "+ "\n" +"+                          +           "+ "\n" +"+                          +           "+ "\n" +" +                        +           "+ "\n" +"  +                      +           "+ "\n" +"   +                   +           "+ "\n" +"       +           +           "+ "\n" +"             +            ";
       }

}

