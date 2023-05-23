package ma.cigma.mypef.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SortieKeyEntity implements Serializable {
    @Column(name = "medicament_id")
    private long medicamentid;
    @Column(name = "facture_code")
    private long facturecode;

    public long getMedicamentid() {
        return medicamentid;
    }

    public void setMedicamentid(long medicamentid) {
        this.medicamentid = medicamentid;
    }

    public long getFacturecode() {
        return facturecode;
    }

    public void setFacturecode(long facturecode) {
        this.facturecode = facturecode;
    }

    public SortieKeyEntity(long medicamentid, long facturecode) {
        this.medicamentid = medicamentid;
        this.facturecode = facturecode;
    }

    public SortieKeyEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortieKeyEntity that = (SortieKeyEntity) o;
        return medicamentid == that.medicamentid && facturecode == that.facturecode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicamentid, facturecode);
    }
}
