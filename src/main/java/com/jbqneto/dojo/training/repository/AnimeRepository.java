package com.jbqneto.dojo.training.repository;

import java.util.ArrayList;
import java.util.List;

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

	public Anime findById(int id) {
		return animes.stream()
				.filter(anime -> anime.getId() == id)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found"));
	}
	
	public Anime update(Anime anime) {
		int pos = -1;
		for (int i=0; i < animes.size(); i++) {
			if (animes.get(i).getId() == anime.getId())
				pos = i;
		}
		
		if (pos == -1)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime not found");
		
		animes.set(pos, anime);
		
		return anime;
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
