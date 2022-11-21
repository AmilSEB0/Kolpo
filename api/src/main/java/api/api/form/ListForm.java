package api.api.form;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ListForm {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_form", referencedColumnName = "id")
    private List<Form> formes = new ArrayList<>();
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    private String nom;

    public ListForm(List<Form> formes, String nom) {
        this.formes = formes;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public ListForm(List<Form> form) {
        this.setFormes(form);
    }

    public ListForm() {

    }

    public void setFormes(List<Form> form) {
        this.formes = form;
    }

    public List<Form> getFormes() {
        return this.formes;
    }

    public double getPerimetreTotal() {
        double total_perimetre = 0;
        for (Form forme : this.getFormes()) {
            total_perimetre += forme.getPerimetre();
        }
        return total_perimetre;
    }

    public double getAirTotal() {
        double total_air = 0;
        for (Form forme : this.getFormes()) {
            total_air += forme.getAir();
        }
        return total_air;
    }
    public int getnombre_de_rectangle(){
        int nombre_de_rectangle = 0;
        for (Form form : formes){
            String FormName = form.toString();
            if (FormName.contains("Rectangle")){
                nombre_de_rectangle += 1;
            }
        }
        return nombre_de_rectangle;
    }
    public int getnombre_de_cercle(){
        int nombre_de_cercle = 0;
        for (Form form : formes){
            String FormName = form.toString();
            if (FormName.contains("Cercle")){
                nombre_de_cercle += 1;
            }
        }
        return nombre_de_cercle;
    }
    public int getnombre_de_triangle(){
        int nombre_de_triangle = 0;
        for (Form form : formes){
            String FormName = form.toString();
            if (FormName.contains("Triangle")){
                nombre_de_triangle += 1;
            }
        }
        return nombre_de_triangle;
    }
    public int getnombre_de_carre(){
        int nombre_de_carre = 0;
        for (Form form : formes){
            String FormName = form.toString();
            if (FormName.contains("Carré")){
                nombre_de_carre += 1;
            }
        }
        return nombre_de_carre;
    }



    public String toString() {
        return "Périmètre total des formes : " + this.getPerimetreTotal() + " cm" + "\n" + "Aire totale des formes : " + this.getAirTotal() + " cm²" ;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
