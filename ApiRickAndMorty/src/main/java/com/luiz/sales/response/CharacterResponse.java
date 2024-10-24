package com.luiz.sales.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CharacterResponse {

	private String id;
	private String name;
	private String status;
	private String species;
	private String image;
	private List<String> episode;
}
