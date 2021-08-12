package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Produit implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "designation", unique = true)
    private String designation;

    @Column(name = "prix_achat")
    public BigDecimal prixAchat;

    @Column(name = "prix_vente")
    public BigDecimal prixVente;

    @Column(name = "qte_stock")
    public int qteStock;

    @Column(name = "labo")
    private String labo;

    @Column(name = "principe_actif")
    public String principeActif;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Categorie categorie;

    @OneToMany(mappedBy = "produit")
    private Set<CommandeProduit> produitsCommandees;


    @OneToMany(mappedBy = "produit")
    private Set<VenteProduit> produitsVendues;


    public Produit() {

    }

    public Produit(long id, String designation, float prixAchat, float prixVente, int qteStock, String labo, String principeActif, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.qteStock = qteStock;
        this.labo = labo;
        this.principeActif = principeActif;
        this.categorie = categorie;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesig() {
        return this.designation;
    }

    public void setDesig(String desig) {
        this.designation = desig;
    }

    public float getPrixAchat() {
        return this.prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public float getPrvente() {
        return this.prixVente;
    }

    public void setPrvente(float prvente) {
        this.prixVente = prvente;
    }

    public int getQteStock() {
        return this.qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public String getLabo() {
        return this.labo;
    }

    public void setLabo(String labo) {
        this.labo = labo;
    }

    public String getPrincipeActif() {
        return this.principeActif;
    }

    public void setPrincipeActif(String principeActif) {
        this.principeActif = principeActif;
    }

    public Categorie getCategorie() {
        return this.categorie;

    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}
