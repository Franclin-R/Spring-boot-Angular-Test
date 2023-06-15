package com.javafranclin.sevices.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javafranclin.dtos.ProduitsDto;
import com.javafranclin.entites.Produits;
import com.javafranclin.enums.ErrorCodes;
import com.javafranclin.exception.InvalidEntityException;
import com.javafranclin.mappers.MapperProduits;
import com.javafranclin.repository.ProduitRepository;
import com.javafranclin.sevices.ProduitsService;
import com.javafranclin.validation.ValidationProduits;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProduitsImpl implements ProduitsService {

	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public ProduitsDto saveProduits(ProduitsDto dto) {
		List<String> errors = ValidationProduits.valider(dto);
		if (!errors.isEmpty()) {
			log.warn("Les champs de produit n'est pas valide ", errors);
			throw new InvalidEntityException("l'article n'est pas valid", ErrorCodes.PRODUIT_NOT_VALID, errors);
		}
			Produits produit = MapperProduits.toEntity(dto);
			Produits produitTosave = produitRepository.save(produit);
			return MapperProduits.fromEntity(produitTosave);
	}

	@Override
	public List<ProduitsDto> listeProduits(int pageNumber, String searchKey) {
		Pageable pageable = PageRequest.of(pageNumber, 4);
		
		if (searchKey.equals("")) {
			Page<Produits> liste = produitRepository.findAll(pageable);
			return liste.stream().map(lt -> MapperProduits.fromEntity(lt)).collect(Collectors.toList());
		} else {
			Page<Produits> liste = produitRepository.findByNomProduitContainingIgnoreCaseOrDescriptionProduitContainingIgnoreCase(searchKey, searchKey,
					pageable);
			return liste.stream().map(lt -> MapperProduits.fromEntity(lt)).collect(Collectors.toList());
		}
	}

	@Override
	public void deleteProduit(Long id) {
		if (id == null) {
			log.warn("ID PRODUIT IS NULL");
			return;
		}
		produitRepository.deleteById(id);
	}
	
	@Override
	public ProduitsDto getByIdProduit(Long idProduit) {
		if(idProduit == null) {
			log.warn("L'ID de produit est null");
			return null;
		}
		
		Produits produit = produitRepository.findById(idProduit).get();
		ProduitsDto produitDto = MapperProduits.fromEntity(produit);
		
		return produitDto;
	}

}
