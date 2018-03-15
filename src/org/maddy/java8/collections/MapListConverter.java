package org.maddy.java8.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapListConverter {
/*
	Map<Integer, String> map = lstModels.stream().collect(
	        Collectors.toMap(Model::getId, Model::getData));*/
	
	public static List<Model> convertMapToListWithJava8(Map<Integer, String> map) {

		List<Model> result = map.entrySet().stream().map(entry -> new Model(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());

		return result;
	}

	public static Map<Integer, String> convertListToMapWithJava8(List<Model> lstModels) {
		// Map<Long, String> map = lstModels.stream().collect(
		// Collectors.toMap(model -> model.getId(), model -> model.getData()));

		Map<Integer, String> map = lstModels.stream().collect(Collectors.toMap(Model::getId, Model::getData));

		return map;
	}

	public static void main(String[] args) {
		List<Model> modelLst = new ArrayList<Model>();
		modelLst.add(new Model(1, "one"));
		modelLst.add(new Model(2, "two"));
		modelLst.add(new Model(3, "three"));

		// Convert List to Map
		Map<Integer, String> map = MapListConverter.convertListToMapWithJava8(modelLst);
		System.out.println("#Result convert List to Map!");
		System.out.println(map);

		// Convert Map to List
		List<Model> newModelLst = MapListConverter.convertMapToListWithJava8(map);
		System.out.println("#Result convert Map to List!");
		newModelLst.forEach(System.out::println);
	}


	
}
 class Model {
	private Integer id;
	private String data;
	
	public Model(Integer id, String data){
		this.id = id;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		String info = String.format("Model info: id = %d, data = %s", id, data);
		return info;
	}
}