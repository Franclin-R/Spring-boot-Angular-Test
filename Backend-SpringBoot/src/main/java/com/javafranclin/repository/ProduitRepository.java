package com.javafranclin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javafranclin.entites.Produits;

public interface ProduitRepository extends JpaRepository<Produits, Long> {
	
	Page<Produits> findAll(Pageable pageable);
	
	Page<Produits> findByNomProduitContainingIgnoreCaseOrDescriptionProduitContainingIgnoreCase(
			String key1, String key2, Pageable pageable);

}
