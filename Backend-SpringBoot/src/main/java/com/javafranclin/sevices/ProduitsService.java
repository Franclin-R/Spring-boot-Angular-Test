package com.javafranclin.sevices;

import java.util.List;

import com.javafranclin.dtos.ProduitsDto;

public interface ProduitsService {
	
	ProduitsDto saveProduits(ProduitsDto dto);
	
	List<ProduitsDto> listeProduits(int pageNumber, String searchKey);
	
	ProduitsDto getByIdProduit(Long idProduit);
	
	void deleteProduit(Long id);

}
