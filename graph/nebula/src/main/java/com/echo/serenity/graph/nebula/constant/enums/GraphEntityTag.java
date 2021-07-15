package com.echo.serenity.graph.nebula.constant.enums;

/**
 * Created by xushu.
 */
public enum GraphEntityTag {

    METRIC("metric", "urn");

    private final String name;
    private final String properties;

    GraphEntityTag(String name, String properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getProperties() {
        return properties;
    }

    public static GraphEntityTag parseGraphEntityTagById(String vertexId) {
        return METRIC;
    }
}
