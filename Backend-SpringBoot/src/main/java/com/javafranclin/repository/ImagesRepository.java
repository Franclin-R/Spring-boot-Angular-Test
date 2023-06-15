package com.javafranclin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafranclin.entites.ImageModel;

public interface ImagesRepository extends JpaRepository<ImageModel, Long> {

}
