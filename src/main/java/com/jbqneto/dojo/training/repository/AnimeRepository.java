package com.jbqneto.dojo.training.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.jbqneto.dojo.training.domain.Anime;

@Repository
public class AnimeRepository {
	
	private static List<Anime> animes = new ArrayList<Anime>(List.of(
			new Anime(1, "Naruto"),
			new Anime(2, "Boruto"),
			new Anime(3, "Samurai X")
			));
	
	public List<Anime> listAll() {
		return animes;
	}

	public Optional<Anime> findById(int id) {
		return animes.stream()
				.filter(anime -> anime.getId() == id)
				.findFirst();
	}
	
	public void delete(int id) {
		Anime anime = animes.stream()
			.filter(filteredAnime -> filteredAnime.getId() == id)
			.findFirst()
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not found"));
		
		animes.remove(anime);
	}
	
	public Anime save(Anime anime) {
		Anime latest = animes.get(animes.size() -1);
		anime.setId(latest.getId() + 1);
		animes.add(anime);
		return anime;
	}

}
