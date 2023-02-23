package com.developer.exercice.controllers;

import com.developer.exercice.entities.Produit;
import com.developer.exercice.repositories.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/produit")
public class ProduitController {
    private final ProduitService produitService;
    @Autowired
    public ProduitController(ProduitService produitService) {

        this.produitService = produitService;
    }

    @GetMapping("/{id}")
    public Optional<Produit> findById(@PathVariable("id") Long id) {

        return produitService.findById(id);
    }
    @GetMapping
    public List<Produit> findAll() {

    return produitService.findAll();
    }
    @GetMapping("/categorie/{id}")
    public ResponseEntity<List<Produit>> getProductsByCategory(@PathVariable Long id) {
      List<Produit> produits = produitService.afficherProduitByCategorie(id);
    if (produits.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(produits, HttpStatus.OK);
    }
    @PostMapping("add/{id}")
    public Produit crate(@RequestBody Produit p,@PathVariable long id) {

        return produitService.create(p,id);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable("id") Long id) {

        produitService.supprimer(id);
    }
    @PutMapping("/{id}/{idCat}")
    public Produit modif(@PathVariable("id") Long id,@RequestBody Produit produit,@PathVariable("idCat") Long idCat) {

        return produitService.modif(id,produit,idCat);
    }
}
