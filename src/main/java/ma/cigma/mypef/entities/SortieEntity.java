package ma.cigma.mypef.entities;

import javax.persistence.*;

@Entity
public class SortieEntity {
    @EmbeddedId
    private SortieKeyEntity id;
    @ManyToOne
    @MapsId("medicamentid")
    @JoinColumn(name = "medicament_id")
    private MedicamentEntity medicament;
    @ManyToOne
    @MapsId("facturecode")
    @JoinColumn(name = "facture_code")
    private FactureEntity facture;

    private int quantite;

    public SortieKeyEntity getId() {
        return id;
    }

    public void setId(SortieKeyEntity id) {
        this.id = id;
    }

    public MedicamentEntity getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentEntity medicament) {
        this.medicament = medicament;
    }

    public FactureEntity getFacture() {
        return facture;
    }

    public void setFacture(FactureEntity facture) {
        this.facture = facture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
