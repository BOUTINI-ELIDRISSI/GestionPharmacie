package ma.cigma.mypef.dtos;


import java.util.Date;

public class EntreeDto {
    private long id;
    private int quantite;
    private Date date_entree;
    private Date date_expiration;
    private float prix_achat;
    private float prix_vente;
    private MedicamentDto medicament;
    private FournisseurDto fournisseur;
    private UtilisateurDto utilisateur;

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

    public MedicamentDto getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDto medicament) {
        this.medicament = medicament;
    }

    public FournisseurDto getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur) {
        this.fournisseur = fournisseur;
    }

    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "EntreeDto{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", date_entree=" + date_entree +
                ", date_expiration=" + date_expiration +
                ", prix_achat=" + prix_achat +
                ", prix_vente=" + prix_vente +
                ", medicament=" + medicament +
                ", fournisseur=" + fournisseur +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
