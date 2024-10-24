package com.luiz.sales.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.luiz.sales.response.CharacterResponse;
import com.luiz.sales.response.EpisodeResponse;
import com.luiz.sales.response.ListOfEpisodesResponse;
import com.luiz.sales.response.LocationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

	private final WebClient webClient;

    RickAndMortyClient(WebClient.Builder builder) {
    	
    	webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }
	
	public Mono<CharacterResponse> findCharacterById(String id){
		
		log.info("buscando o personagem com id [{}]", id);
		
		return webClient
				.get()
				.uri("/character/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(CharacterResponse.class);
	}
	
	public Mono<LocationResponse> findLocationById(String id){
		
		log.info("buscando a localização com id [{}]", id);
		
		return webClient
				.get()
				.uri("/location/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(LocationResponse.class);
	}
	
	public Mono<EpisodeResponse> findEpisodeById(String id){
		
		log.info("buscando a episodio com id [{}]", id);
		
		return webClient
				.get()
				.uri("/episode/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(EpisodeResponse.class);
	}
	
public Flux<ListOfEpisodesResponse> findAllEpisodes(){
		
		log.info("buscando todos os episodios");
		
		return webClient
				.get()
				.uri("/episode/")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToFlux(ListOfEpisodesResponse.class);
	}
}
