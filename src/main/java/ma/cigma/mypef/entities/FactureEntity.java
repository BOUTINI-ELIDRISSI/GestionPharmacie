package ma.cigma.mypef.entities;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;


@Entity
public class FactureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private Date date_Fact;
    private float prix_total;
    @ManyToOne
    private UtilisateurEntity utilisateur;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDate_Fact() {
        return date_Fact;
    }

    public void setDate_Fact(Date date_Fact) {
        this.date_Fact = date_Fact;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

}
