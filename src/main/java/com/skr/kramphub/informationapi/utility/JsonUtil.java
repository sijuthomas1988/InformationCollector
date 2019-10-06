package com.skr.kramphub.informationapi.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json Utility class
 */
public class JsonUtil {

    /**
     * Method that parses json object
     *
     * @param inputJson
     *     json string that needs to be parsed
     * @param params
     *     nodes that needs too be parsed and value to be extracted
     * @param root
     *     value of root node of the json
     * @param args
     *     path that needs to be obtained to fetch the node values
     * @return list of map object of extracted nodes and values
     */
    public static List<Map<String, Object>> fetchValuesFromJson(String inputJson, List<String> params, String root, List<String> args) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(inputJson);
        JSONArray jsonArray = jsonObject.getJSONArray(root);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            for(String s: args) {
                if(jsonObject1.has(s) && jsonObject1.get(s) instanceof JSONObject) {
                    jsonObject1 = jsonObject1.getJSONObject(s);
                }
            }
            Map<String, Object> stringMap = new HashMap<>();
            for(String s1 : params) {
                if(jsonObject1.has(s1) && jsonObject1.get(s1) instanceof JSONArray) {
                    JSONArray jsonArray1 = jsonObject1.getJSONArray(s1);
                    List<String> stringList = new ArrayList<>();
                    for(int j=0; j<jsonArray1.length();j++) {
                        stringList.add(String.valueOf(jsonArray1.get(j)));
                    }
                    stringMap.put(s1, stringList);
                } else {
                    if(jsonObject1.has(s1)) {
                        stringMap.put(s1, jsonObject1.get(s1).toString());
                    }
                }
            }
            mapList.add(stringMap);
        }
        return mapList;
    }
}