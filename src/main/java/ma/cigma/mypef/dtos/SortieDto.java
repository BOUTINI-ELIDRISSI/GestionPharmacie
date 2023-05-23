package ma.cigma.mypef.dtos;

import ma.cigma.mypef.entities.FactureEntity;
import ma.cigma.mypef.entities.MedicamentEntity;
import ma.cigma.mypef.entities.SortieKeyEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class SortieDto {
    private SortieKeyDto id;
    private MedicamentDto medicament;
    private FactureDto facture;
    private int quantite;

    public SortieKeyDto getId() {
        return id;
    }

    public void setId(SortieKeyDto id) {
        this.id = id;
    }

    public MedicamentDto getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDto medicament) {
        this.medicament = medicament;
    }

    public FactureDto getFacture() {
        return facture;
    }

    public void setFacture(FactureDto facture) {
        this.facture = facture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "SortieDto{" +
                "id=" + id +
                ", medicament=" + medicament +
                ", facture=" + facture +
                ", quantite=" + quantite +
                '}';
    }
}
