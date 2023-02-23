package com.developer.exercice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;


@Entity
@Data
@Builder
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_categories")
    private Categorie categorie;
    @Column(name = "nomP")
    private String nom;
    @Column(name="qtP")
    private int quantite;
    @Column(name="Disponible")
    private Boolean disponible;
    @Column(name="dateCP")
    private LocalDate dateCreation;
    @Column(name="dateMP")
    private LocalDate dateModif;

    public Produit(Long id, Categorie cat, String nom, int qt, Boolean disponible, LocalDate dateCreation, LocalDate dateModif) {
        this.id = id;
        this.categorie = cat;
        this.nom = nom;
        quantite = qt;
        this.disponible = disponible;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
    }

    public Produit() {

    }
}
