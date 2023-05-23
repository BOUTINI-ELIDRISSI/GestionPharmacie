package ma.cigma.mypef.entities;

import javax.persistence.*;

@Entity
public class LigneEntity {
    @EmbeddedId
    private LigneKeyEntity id;
    @ManyToOne
    @MapsId("medid")
    @JoinColumn(name = "med_id")
    private MedicamentEntity medicament;
    @ManyToOne
    @MapsId("cmdcode")
    @JoinColumn(name = "cmd_code")
    private CommandeEntity commande;
    private int quantite;

    public LigneKeyEntity getId() {
        return id;
    }

    public void setId(LigneKeyEntity id) {
        this.id = id;
    }

    public MedicamentEntity getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentEntity medicament) {
        this.medicament = medicament;
    }

    public CommandeEntity getCommande() {
        return commande;
    }

    public void setCommande(CommandeEntity commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
