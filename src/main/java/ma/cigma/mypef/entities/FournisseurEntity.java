package ma.cigma.mypef.entities;

import javax.persistence.*;

@Entity
public class FournisseurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom_F;
    private String tele_F;
    private String email_F;
    private String adresse_F;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom_F() {
        return nom_F;
    }

    public void setNom_F(String nom_F) {
        this.nom_F = nom_F;
    }

    public String getTele_F() {
        return tele_F;
    }

    public void setTele_F(String tele_F) {
        this.tele_F = tele_F;
    }

    public String getEmail_F() {
        return email_F;
    }

    public void setEmail_F(String email_F) {
        this.email_F = email_F;
    }

    public String getAdresse_F() {
        return adresse_F;
    }

    public void setAdresse_F(String adresse_F) {
        this.adresse_F = adresse_F;
    }

}
