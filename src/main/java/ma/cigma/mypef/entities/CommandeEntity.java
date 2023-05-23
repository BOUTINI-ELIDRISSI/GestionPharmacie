package ma.cigma.mypef.entities;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Entity
public class CommandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private Date date_Cmd;
    private float prix_total;
    @ManyToOne
    private UtilisateurEntity utilisateur;
    @ManyToOne
    private ClientEntity client;

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

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }


}
