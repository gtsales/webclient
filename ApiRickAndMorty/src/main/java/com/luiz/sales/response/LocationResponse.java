package com.luiz.sales.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class LocationResponse {

	private String id;
	private String name;
	private String type;
	private List<String> residents;
	private String url;
}
