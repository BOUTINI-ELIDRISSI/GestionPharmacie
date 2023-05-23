package ma.cigma.mypef.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LigneKeyEntity implements Serializable {
    @Column(name = "med_id")
    private long medid;
    @Column(name = "cmd_code")
    private long cmdcode;

    public long getMedid() {
        return medid;
    }

    public void setMedid(long medid) {
        this.medid = medid;
    }

    public long getCmdcode() {
        return cmdcode;
    }

    public void setCmdcode(long cmdcode) {
        this.cmdcode = cmdcode;
    }

    public LigneKeyEntity(long medid, long cmdcode) {
        this.medid = medid;
        this.cmdcode = cmdcode;
    }

    public LigneKeyEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneKeyEntity that = (LigneKeyEntity) o;
        return medid == that.medid && cmdcode == that.cmdcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medid, cmdcode);
    }
}
