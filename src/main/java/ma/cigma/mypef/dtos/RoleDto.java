package ma.cigma.mypef.dtos;

public class RoleDto {
    private long id;
    private String nom;

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

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
