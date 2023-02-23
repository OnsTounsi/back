package com.developer.exercice.service;

import com.developer.exercice.entities.Categorie;
import com.developer.exercice.repositories.CategorieRepository;
import com.developer.exercice.repositories.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public List<Categorie> findAll(){
    return categorieRepository.findAll();}

    @Override
    public Optional<Categorie> findById(Long id) {

        return categorieRepository.findById(id);
    }

    @Override
    public Categorie ajout(Categorie c) {

      c.setDateCreation(LocalDate.now());
      return categorieRepository.save(c);
    }

    @Override
    public boolean supprimer(Long id) {
        categorieRepository.deleteById(id);

        return true;
    }

    @Override
    public Categorie modif(Long id, Categorie c) {
        Categorie existingCategorie = categorieRepository.findById(id).orElse(null);
        if (existingCategorie != null) {
            existingCategorie.setNom(c.getNom());
            existingCategorie.setQuantite(c.getQuantite());
            existingCategorie.setDateModif(LocalDate.now());
            return categorieRepository.save(existingCategorie);
        }

        return null;
    }

}
