package com.echo.serenity.graph.api.model;

import java.util.Collection;

/**
 * Created by xushu.
 */
public interface Element {

    String getId();

    Collection<? extends String> getPropertyKeys();

    <T> T getProperty(String propertyName, Class<T> type);

}
