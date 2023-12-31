package com.javafranclin.entites;

import java.util.Set;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "produits")
public class Produits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long produitId;

	private String nomProduit;

	@Column(length = 2000)
	private String descriptionProduit;

	private double prixProduit;

	private Integer quantiteProduit;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "product_images", joinColumns = {

			@JoinColumn(name = "product_id") }, inverseJoinColumns = {

					@JoinColumn(name = "image_id") })

	private Set<ImageModel> productImages;

}
