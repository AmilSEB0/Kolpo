package api.api.dao;
import api.api.form.Rectangle;
import api.api.form.Cercle;
import api.api.form.Triangle;
import api.api.form.Carre;
import api.api.form.Form;



public class FormDTO {
    public String type;
    public double largeur;
    public double longueur;
    public double base;
    public double cote;
    public double rayon;
    public int liste;




    public static Form toEntity2D(FormDTO dto) {
        Form f = null;
        if(dto.longueur != 0 && dto.largeur != 0){
            f =  new Rectangle(dto.longueur,dto.largeur, dto.liste);
        } else if(dto.cote != 0 && dto.base != 0){
            f = new Triangle(dto.base, dto.cote, dto.liste);
        } else if(dto.rayon != 0){
            f = new Cercle(dto.rayon, dto.liste);
        } else if(dto.cote != 0 && dto.base == 0){
            f = new Carre(dto.cote, dto.liste);
        }
        return f;
    }
}
