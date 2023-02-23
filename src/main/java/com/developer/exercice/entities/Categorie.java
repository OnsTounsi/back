package com.developer.exercice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomC")
    private String nom;
    @Column(name = "qtC")
    private int quantite;
    @Column(name = "dateCC")
    private LocalDate dateCreation;
    @Column(name = "dateMC")
    private LocalDate dateModif;

    @JsonManagedReference
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produit;

    public Categorie(Long id, String nom, int qt, LocalDate dateCreation, LocalDate dateModif, List<Produit> produit) {
        this.id = id;
        this.nom = nom;
        quantite = qt;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
        this.produit = produit;
    }

    public Categorie() {

    }
}
