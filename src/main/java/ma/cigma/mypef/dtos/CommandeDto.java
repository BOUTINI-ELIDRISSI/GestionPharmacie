package ma.cigma.mypef.dtos;

import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

public class CommandeDto {
    private long code;
    private Date date_Cmd;
    private float prix_total;
    private UtilisateurDto utilisateur;
    private ClientDto client;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDate_Cmd() {
        return date_Cmd;
    }

    public void setDate_Cmd(Date date_Cmd) {
        this.date_Cmd = date_Cmd;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public UtilisateurDto getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDto utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "CommandeDto{" +
                "code=" + code +
                ", date_Cmd=" + date_Cmd +
                ", prix_total=" + prix_total +
                ", utilisateur=" + utilisateur +
                ", client=" + client +
                '}';
    }
}
