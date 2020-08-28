package com.jbqneto.dojo.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jbqneto.dojo.training.domain.Anime;

@Repository
public class AnimeRepository {
	
	private static List<Anime> animes = List.of(
			new Anime(1, "Naruto"),
			new Anime(2, "Boruto"),
			new Anime(3, "Samurai X")
			);
	
	public List<Anime> listAll() {
		return animes;
	}

	public Optional<Anime> findById(int id) {
		return animes.stream()
				.filter(anime -> anime.getId() == id)
				.findFirst();
	}

}
