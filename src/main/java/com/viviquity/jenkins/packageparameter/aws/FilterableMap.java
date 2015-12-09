package com.viviquity.jenkins.packageparameter.aws;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Domain specific class responsible for filter map values by a given value.
 */
public class FilterableMap {
    private final Map<String, String> map;

    public FilterableMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> filterBy(String value) {
        return map.entrySet()
                .stream()
                .filter(e -> e.getKey().contains(value))
                .collect(toMap(Map.Entry::getKey, e -> e.getValue().split("=")[1]));
    }
}
