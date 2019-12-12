package org.personal.myStore.core;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Environment {
    private static final String CONF_FILE = "config.json";
    private static Environment instance;
    private DocumentContext jsonContext;

    /**
     * Gets environment instance.
     * @return the our instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * Reads the JSON file.
     */
    private Environment() {
        JSONParser parser = new JSONParser();
        try (InputStream inputStream = new FileInputStream(CONF_FILE)) {
            Reader fileReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
            jsonContext = JsonPath.parse(jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets property.
     * @param key type String
     * @return property.
     */
    public String getValue(final String key) {
        return  jsonContext.read(key);
    }
}
