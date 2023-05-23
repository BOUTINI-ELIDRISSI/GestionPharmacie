package ma.cigma.mypef.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EntreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantite;
    private Date date_entree;
    private Date date_expiration;
    private float prix_achat;
    private float prix_vente;
    @ManyToOne
    private MedicamentEntity medicament;
    @ManyToOne
    private FournisseurEntity fournisseur;
    @ManyToOne
    private UtilisateurEntity utilisateur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(float prix_achat) {
        this.prix_achat = prix_achat;
    }

    public float getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(float prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Date getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public MedicamentEntity getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentEntity medicament) {
        this.medicament = medicament;
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }
    public FournisseurEntity getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurEntity fournisseur) {
        this.fournisseur = fournisseur;
    }

}
