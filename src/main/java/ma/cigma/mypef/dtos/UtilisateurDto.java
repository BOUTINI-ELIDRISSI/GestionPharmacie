package ma.cigma.mypef.dtos;


public class UtilisateurDto {
    private long id;
    private String nom;
    private String email;
    private String  mot_de_passe;
    private RoleDto role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto  role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UtilisateurDto{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", role=" + role +
                '}';
    }
}
