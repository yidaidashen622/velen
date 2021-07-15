package com.echo.serenity.graph.api.model;

/**
 * Created by xushu.
 */
public interface Edge<V, E> extends Element {

    Vertex<V, E> getInVertex();

    Vertex<V, E> getOutVertex();

    E getE();
}
