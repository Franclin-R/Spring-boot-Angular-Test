package com.javafranclin.dtos;

import java.util.Set;

import com.javafranclin.entites.ImageModel;

import lombok.Data;

@Data
public class ProduitsDto {

	private Long produitId;
	private String nomProduit;
	private String descriptionProduit;
	private double prixProduit;
	private Integer quantiteProduit;
	private Set<ImageModel> productImages;
}
