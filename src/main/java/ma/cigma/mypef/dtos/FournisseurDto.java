package ma.cigma.mypef.dtos;

public class FournisseurDto {
    private long id;
    private String nom;
    private String tele_F;
    private String email_F;
    private String adresse_F;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @Override
    public String toString() {
        return "FournisseurDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tele_F='" + tele_F + '\'' +
                ", email_F='" + email_F + '\'' +
                ", adresse_F='" + adresse_F + '\'' +
                '}';
    }
}
