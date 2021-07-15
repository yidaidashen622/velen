package com.echo.serenity.graph.nebula.model;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.graph.api.model.Edge;
import com.echo.serenity.graph.api.model.Graph;
import com.echo.serenity.graph.api.model.Vertex;
import com.echo.serenity.graph.nebula.utils.GraphQuerys;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.IOErrorException;
import com.vesoft.nebula.client.graph.net.Session;

/**
 * Created by xushu.
 */
public class NebulaGraph implements Graph<NebulaVertex, NebulaEdge> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NebulaGraph.class);

    private final Session session;

    public NebulaGraph(Session session) {
        this.session = session;
    }

    @Override
    public boolean addEdge(Vertex<NebulaVertex, NebulaEdge> outVertex, Vertex<NebulaVertex, NebulaEdge> inVertex, Properties properties) {
        String inId = inVertex.getId();
        String outId = outVertex.getId();
        String query = GraphQuerys.buildInsertEdgeQuery(inId, outId, properties);
        return updateGraph(query);
    }

    @Override
    public boolean addVertex(Properties properties) {
        String query = GraphQuerys.buildInsertVertexQuery(properties);
        return updateGraph(query);
    }

    @Override
    public boolean removeEdge(Edge<NebulaVertex, NebulaEdge> edge) {
        String query = GraphQuerys.buildDeleteEdgeQuery(edge.getId());
        return updateGraph(query);
    }

    @Override
    public boolean removeVertex(Vertex<NebulaVertex, NebulaEdge> vertex) {
        String query = GraphQuerys.buildDeleteVertexQuery(vertex.getId());
        return updateGraph(query);
    }

    @Override
    public Edge<NebulaVertex, NebulaEdge> getEdge(String edgeId) {
        return null;
    }

    @Override
    public Vertex<NebulaVertex, NebulaEdge> getVertex(String vertexId) {
        return null;
    }

    @Override
    public Iterable<Vertex<NebulaVertex, NebulaEdge>> query(String vertexId, List<String> tags) {
        return null;
    }

    private boolean updateGraph(String query){
        try {
            ResultSet resultSet = session.execute(query);
            return resultSet.isSucceeded();
        } catch (IOErrorException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }
}
