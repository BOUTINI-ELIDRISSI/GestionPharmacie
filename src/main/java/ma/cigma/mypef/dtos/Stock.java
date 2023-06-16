package ma.cigma.mypef.dtos;

import java.util.Date;

public class Stock {
    private long medicament_id;
    private String medicament_Libelle;
    private Date date_expiration;
    private String fournisseur;
    private int qte;

    public Stock(long medicament_id, String medicament_Libelle, Date date_expiration, String fournisseur, int qte) {
        this.medicament_id = medicament_id;
        this.medicament_Libelle = medicament_Libelle;
        this.date_expiration = date_expiration;
        this.fournisseur = fournisseur;
        this.qte = qte;
    }

    public long getMedicament_id() {
        return medicament_id;
    }

    public void setMedicament_id(long medicament_id) {
        this.medicament_id = medicament_id;
    }

    public String getMedicament_Libelle() {
        return medicament_Libelle;
    }

    public void setMedicament_Libelle(String medicament_Libelle) {
        this.medicament_Libelle = medicament_Libelle;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
