package com.jbqneto.dojo.training.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.domain.Anime;
import com.jbqneto.dojo.training.repository.AnimeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/animes")
public class AnimeController {

	private final AnimeRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Anime>> list() {
		return ResponseEntity.ok(repository.listAll());
	}
	
	@GetMapping("/{animeId}")
	public ResponseEntity<Anime> findById(@PathVariable int animeId) {
		Anime anime = repository.findById(animeId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found."));
		
		return ResponseEntity.ok(anime);
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime) {
		return new ResponseEntity<Anime>(repository.save(anime), HttpStatus.CREATED);
	}
	
}
