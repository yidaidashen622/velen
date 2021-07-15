package com.echo.serenity.graph.api.model;

import java.util.Properties;

/**
 * Created by xushu.
 */
public interface Graph<V, E> {

    boolean addEdge(Vertex<V, E> outVertex, Vertex<V, E> inVertex, Properties properties);

    boolean addVertex(Properties properties);

    boolean removeEdge(Edge<V, E> edge);

    boolean removeVertex(Vertex<V, E> vertex);

    Edge<V, E> getEdge(String edgeId);

    Vertex<V, E> getVertex(String vertexId);
}
