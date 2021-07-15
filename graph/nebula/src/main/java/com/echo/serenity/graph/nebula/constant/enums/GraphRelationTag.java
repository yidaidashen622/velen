package com.echo.serenity.graph.nebula.constant.enums;

/**
 * Created by xushu.
 */
public enum GraphRelationTag {

    DEPEND("depend", "");

    private final String name;
    private final String properties;

    GraphRelationTag(String name, String properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getProperties() {
        return properties;
    }

    public static GraphRelationTag parseGraphRelationTagById(String edgeId) {
        return DEPEND;
    }
}
