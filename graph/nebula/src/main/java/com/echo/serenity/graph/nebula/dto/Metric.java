package com.echo.serenity.graph.nebula.dto;

import java.util.Properties;

/**
 * Created by xushu.
 */
public class Metric {

    private static final String TEMPLATE = "'%s':('%s')'";

    private String urn;

    public Metric() {
    }

    public Metric(Properties properties) {

    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    @Override
    public String toString() {
        return String.format(TEMPLATE, urn, urn);
    }
}
