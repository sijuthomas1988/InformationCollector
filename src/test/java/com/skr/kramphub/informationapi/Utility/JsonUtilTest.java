package com.skr.kramphub.informationapi.Utility;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonUtilTest {

    @Test
    public void fetchValuesFromJson_Success() throws IOException {
        List<String> attributes = new ArrayList<>();
        attributes.add("title");
        attributes.add("printType");
        attributes.add("authors");

        List<String> path = new ArrayList<>();
        path.add("volumeInfo");
        String root = "items";
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("input.json");
        String jsonFile = IOUtils.toString(in, "UTF-8");
        List<Map<String, Object>> listOfMap = JsonUtil.fetchValuesFromJson(jsonFile, attributes, root, path);
        assertNotNull(listOfMap);
        assertEquals(listOfMap.get(0).values().toArray()[0], "BOOK");
    }

    @Test(expected = JSONException.class)
    public void fetchValuesFromJson_Failure() throws IOException {
        List<String> attributes = new ArrayList<>();
        attributes.add("title");
        attributes.add("printType");
        attributes.add("authors");

        List<String> path = new ArrayList<>();
        path.add("volumeInfo");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("input.json");
        String jsonFile = IOUtils.toString(in, "UTF-8");
        List<Map<String, Object>> listOfMap = JsonUtil.fetchValuesFromJson(jsonFile, attributes, null, path);
    }
}