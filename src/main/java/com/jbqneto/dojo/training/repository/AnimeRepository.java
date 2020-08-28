package com.jbqneto.dojo.training.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbqneto.dojo.training.domain.Anime;

@Repository
public class AnimeRepository {
	
	public List<Anime> listAll() {
		return List.of(
				new Anime(1, "Naruto"),
				new Anime(2, "Boruto"),
				new Anime(3, "Samurai X")
				);
	}

}
