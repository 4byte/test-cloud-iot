package com.ex.microservices.lab.statistics.statisticsservice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class NameService {
	private Map<String, Long> namesMap;

	public NameService() {
		namesMap = new HashMap<>();
	}

	public Map<String, Long> getNamesMap() {
		return namesMap;
	}

	public void setNamesMap(Map<String, Long> namesMap) {
		this.namesMap = namesMap;
	}

	/**
	 * yaroslav implementation
	 *
	 * @param name
	 */
	public void addName(String name) {
		namesMap.put(name, namesMap.getOrDefault(name, 0L) + 1);
		System.out.println("Refreshed " + name);
	}

	/**
	 * George's impl
	 */
	public void gAddName(String name) {
		namesMap.put(name,Optional.ofNullable(namesMap.get(name)).map(a -> a + 1).orElse(1L));
	}
}
