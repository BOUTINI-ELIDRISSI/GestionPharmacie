package ma.cigma.mypef.dtos;

public class SortieKeyDto {
    private long medicamentid;
    private long facturecode;

    public SortieKeyDto(long medicamentid, long facturecode) {
        this.medicamentid = medicamentid;
        this.facturecode = facturecode;
    }

    public SortieKeyDto() {
    }

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
}
