package com.echo.serenity.graph.api.model;

import com.echo.serenity.graph.api.enums.EdgeDirection;

/**
 * Created by xushu.
 */
public interface Vertex<V, E> extends Element {

    Iterable<Edge<V, E>> getEdges(EdgeDirection direction, String edgeLabel);

    Iterable<Edge<V, E>> getEdges(EdgeDirection direction);

    <T> void addProperty(String propertyName, T value);

    <T> void addListProperty(String propertyName, T value);

    V getV();

}
