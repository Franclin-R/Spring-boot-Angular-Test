package com.javafranclin.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.javafranclin.dtos.ProduitsDto;

public class ValidationProduits {

	public static List<String> valider(ProduitsDto dto) {
		List<String> errors = new ArrayList<>();

		if (dto == null) {
			errors.add("Veillez reseigne le nom de produit");
			errors.add("Veillez reseigne la description de produit");
			errors.add("Veillez reseigne le prix discounte de produit");
			errors.add("Veillez reseigne le prix actuelle de produit");
			return errors;
		}

		if (!StringUtils.hasLength(dto.getNomProduit())) {
			errors.add("Veillez reseigne le nom de produit");
		}
		if (!StringUtils.hasLength(dto.getDescriptionProduit())) {
			errors.add("Veillez reseigne la description de produit");
		}
		if (dto.getPrixProduit() == 0) {
			errors.add("Veillez reseigne le prix de produit");
		}
		if (dto.getQuantiteProduit() == 0) {
			errors.add("Veillez reseigne la quantite de produit");
		}
		return errors;
	}
}
