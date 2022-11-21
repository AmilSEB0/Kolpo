package api.api.form;
import java.util.List;


public class CalculForm3d {
    private List<Form3d> forme;

    public CalculForm3d(List<Form3d> forme) {
        this.setForme(forme);
    }

    public void setForme(List<Form3d> forme) {
        this.forme = forme;
    }

    public List<Form3d> getFormes() {
        return this.forme;
    }

    public double getVolumeTotal() {
        double total_volume = 0;
        for (Form3d forme : this.getFormes()) {
            total_volume += forme.getVolume();
        }
        return total_volume;
    }


    public String toString() {
        return "Volume totale des formes : " + this.getVolumeTotal()+" cm³";
    }
    
}
