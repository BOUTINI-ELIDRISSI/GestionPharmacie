package ma.cigma.mypef.dtos;

import ma.cigma.mypef.entities.CommandeEntity;
import ma.cigma.mypef.entities.LigneKeyEntity;
import ma.cigma.mypef.entities.MedicamentEntity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class LigneDto {
    private LigneKeyDto id;
    private MedicamentDto medicament;
    private CommandeDto commande;
    private int quantite;

    public LigneKeyDto getId() {
        return id;
    }

    public void setId(LigneKeyDto id) {
        this.id = id;
    }

    public MedicamentDto getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDto medicament) {
        this.medicament = medicament;
    }

    public CommandeDto getCommande() {
        return commande;
    }

    public void setCommande(CommandeDto commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "LigneDto{" +
                "id=" + id +
                ", medicament=" + medicament +
                ", commande=" + commande +
                ", quantite=" + quantite +
                '}';
    }
}
