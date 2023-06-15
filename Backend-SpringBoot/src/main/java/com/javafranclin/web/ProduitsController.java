package com.javafranclin.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javafranclin.dtos.ProduitsDto;
import com.javafranclin.entites.ImageModel;
import com.javafranclin.sevices.ProduitsService;

@RestController
@CrossOrigin
public class ProduitsController {

	@Autowired
	private ProduitsService produitsService;

	@PostMapping(value = "/produits/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ProduitsDto saveProduits(@RequestPart("produits") ProduitsDto dto, @RequestPart("imageFile") MultipartFile[] file) {
		
		try {
			Set<ImageModel> images = uploadImage(file);
			dto.setProductImages(images);
			return produitsService.saveProduits(dto);
		} catch (Exception e) { 
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> imageModels = new HashSet<>();

		for (MultipartFile file : multipartFiles) {
			ImageModel imageModel = new ImageModel(
					file.getOriginalFilename(),
					file.getContentType(), 
					file.getBytes());
			imageModels.add(imageModel);
		}
		return imageModels;
	}

	@GetMapping(value = "/produits")
	public List<ProduitsDto> listeProduits(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "") String searchKey) {
		return produitsService.listeProduits(pageNumber, searchKey);
	}

	@GetMapping(value = "/produits/getById/{idProduit}")
	public ProduitsDto getProduitById(@PathVariable("idProduit") Long idProduit) {
		return produitsService.getByIdProduit(idProduit);
	}

	@DeleteMapping(value = "/produits/delete/{id}")
	public void deleteProduit(@PathVariable(name = "id") Long id) {
		produitsService.deleteProduit(id);
	}
}
