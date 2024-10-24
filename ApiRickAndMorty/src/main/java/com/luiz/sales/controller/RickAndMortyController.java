package com.luiz.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.sales.client.RickAndMortyClient;
import com.luiz.sales.response.CharacterResponse;
import com.luiz.sales.response.EpisodeResponse;
import com.luiz.sales.response.ListOfEpisodesResponse;
import com.luiz.sales.response.LocationResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class RickAndMortyController {

	@Autowired
	RickAndMortyClient rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
		
		return rickAndMortyClient.findCharacterById(id);
	}
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id){
		
		return rickAndMortyClient.findLocationById(id);
	}
	
	@GetMapping("/episode/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
		
		return rickAndMortyClient.findEpisodeById(id);
	}
	
	@GetMapping("/episodes")
	public Flux<ListOfEpisodesResponse> getAllEpisodes(){
		
		return rickAndMortyClient.findAllEpisodes();
	}
}
