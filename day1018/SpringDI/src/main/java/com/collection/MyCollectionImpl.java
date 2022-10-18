package com.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyCollectionImpl implements MyCollection {

	// 주입받을 데이터
	int[] array;
	List<String> list;
	Set<String> set;
	Map<String, String> map;
	
	public void setArray(int[] array) {
		this.array = array;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public void arrayInfo() {
		for(int i : array) {
			System.out.println(i);
		}
	}

	@Override
	public void listInfo() {
		for(String i : list) {
			System.out.println(i);
		}
	}

	@Override
	public void setInfo() {
		for(String i : set) {
			System.out.println(i);
		}
	}

	@Override
	public void mapInfo() {
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}

}
