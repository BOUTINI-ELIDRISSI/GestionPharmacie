package ma.cigma.mypef.entities;

import javax.persistence.*;


@Entity
public class MedicamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private String Description;
    private String[] maladies;
    private boolean ordonnance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String[] getMaladies() {
        return maladies;
    }

    public void setMaladies(String[] maladies) {
        this.maladies = maladies;
    }

    public boolean isOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(boolean ordonnance) {
        this.ordonnance = ordonnance;
    }

}
