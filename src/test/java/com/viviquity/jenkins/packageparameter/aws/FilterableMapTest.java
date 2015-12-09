package com.viviquity.jenkins.packageparameter.aws;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for FiltereableMap class.
 */
public class FilterableMapTest {

    private Map<String, String> givenMap;

    @Before
    public void setUp() {
        this.givenMap = Maps.newHashMap();
        this.givenMap.put("Random=1", "Random=1");
        this.givenMap.put("Random=2", "Random=2");
        this.givenMap.put("Other=3", "Other=3");
        this.givenMap.put("Other=4", "Other=4");
        this.givenMap.put("ToFormat=ShouldReturnOnlyThis", "ToFormat=ShouldReturnOnlyThis");
    }

    @Test
    public void shouldFilterValuesThatContainsAGivenValue() {
        // given
        String givenValue = "Random";
        Map<String, String> expectedMap = Maps.newHashMap();
        expectedMap.put("Random=1", "1");
        expectedMap.put("Random=2", "2");
        // when
        Map<String, String> returnedMap = new FilterableMap(this.givenMap).filterBy(givenValue);
        // then
        assertEquals(expectedMap, returnedMap);
    }

    @Test
    public void shouldFormatValuesOfFilteredMap() {
        // given
        String givenValue = "ToFormat";
        Map<String, String> expectedMap = Maps.newHashMap();
        expectedMap.put("ToFormat=ShouldReturnOnlyThis", "ShouldReturnOnlyThis");
        // when
        Map<String, String> returnedMap = new FilterableMap(this.givenMap).filterBy(givenValue);
        // then
        assertEquals(expectedMap, returnedMap);
    }

}