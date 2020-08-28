package com.jbqneto.dojo.training.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbqneto.dojo.training.domain.Anime;
import com.jbqneto.dojo.training.repository.AnimeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class AnimeController {

	private final AnimeRepository repository;
	
	@GetMapping("/animes")
	public ResponseEntity<List<Anime>> list() {
		
		return ResponseEntity.ok(repository.listAll());
	}
	
}
