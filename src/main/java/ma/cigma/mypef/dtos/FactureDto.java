package ma.cigma.mypef.dtos;

import ma.cigma.mypef.entities.SortieEntity;
import ma.cigma.mypef.entities.UtilisateurEntity;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

public class FactureDto {
    private long code;
    private Date datefact;
    private float prix_total;
    private UtilisateurEntity utilisateur;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDatefact() {
        return datefact;
    }

    public void setDatefact(Date datefact) {
        this.datefact = datefact;
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


    @Override
    public String toString() {
        return "FactureDto{" +
                "code=" + code +
                ", datefact=" + datefact +
                ", prix_total=" + prix_total +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
