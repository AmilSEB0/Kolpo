package api.api.form;
import javax.persistence.*;

@Entity
public abstract class Form {

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Form() {
    }
    public Form(int id) {
        this.id = id;
    }



   public abstract String toString();
    @Transient
   public abstract double getPerimetre();
    @Transient
   public abstract double getAir();

}

