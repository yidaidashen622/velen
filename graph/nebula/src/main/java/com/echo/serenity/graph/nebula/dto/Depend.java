package com.echo.serenity.graph.nebula.dto;

import java.util.Properties;

/**
 * Created by xushu.
 */
public class Depend {

    private static final String TEMPLATE = "'%s' -> '%s':('%s')'";

    private String inId;
    private String outId;
    private String label;

    public Depend() {

    }

    public Depend(String inId, String outId, Properties properties) {
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format(TEMPLATE, inId, outId, label);
    }
}
