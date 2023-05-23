package ma.cigma.mypef.dtos;


public class LigneKeyDto {
    private long medid;
    private long cmdcode;

    public LigneKeyDto(long medid, long cmdcode) {
        this.medid = medid;
        this.cmdcode = cmdcode;
    }

    public LigneKeyDto() {
    }

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
}
