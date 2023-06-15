package com.javafranclin.mappers;

import com.javafranclin.dtos.ProduitsDto;
import com.javafranclin.entites.Produits;

public class MapperProduits {

	public static ProduitsDto fromEntity(Produits produits) {
		ProduitsDto dto = new ProduitsDto();
		dto.setProduitId(produits.getProduitId());
		dto.setNomProduit(produits.getNomProduit());
		dto.setDescriptionProduit(produits.getDescriptionProduit());
		dto.setPrixProduit(produits.getPrixProduit());
		dto.setQuantiteProduit(produits.getQuantiteProduit());
		dto.setProductImages(produits.getProductImages());

		return dto;
	}

	public static Produits toEntity(ProduitsDto dto) {
		Produits produits = new Produits();
		produits.setProduitId(dto.getProduitId());
		produits.setNomProduit(dto.getNomProduit());
		produits.setDescriptionProduit(dto.getDescriptionProduit());
		produits.setPrixProduit(dto.getPrixProduit());
		produits.setQuantiteProduit(dto.getQuantiteProduit());
		produits.setProductImages(dto.getProductImages());
		return produits;
	}

}
