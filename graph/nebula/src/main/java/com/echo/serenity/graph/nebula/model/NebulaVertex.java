package com.echo.serenity.graph.nebula.model;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.graph.api.enums.EdgeDirection;
import com.echo.serenity.graph.api.model.Edge;
import com.echo.serenity.graph.api.model.Vertex;
import com.vesoft.nebula.client.graph.data.Node;
import com.vesoft.nebula.client.graph.net.Session;

/**
 * Created by xushu.
 */
public class NebulaVertex extends NebulaElement<Node> implements Vertex<NebulaVertex, NebulaEdge> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NebulaVertex.class);

    protected final String tag;
    private final Session session;

    public NebulaVertex(String tag, Node element, Session session) {
        super(element);
        this.tag = tag;
        this.session = session;
    }

    @Override
    public String getId() {
        try {
            return element.getId().asString();
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<? extends String> getPropertyKeys() {
        try {
            return element.keys(tag);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T getProperty(String propertyName, Class<T> type) {
        return null;
    }

    @Override
    public Iterable<Edge<NebulaVertex, NebulaEdge>> getEdges(EdgeDirection direction, String edgeLabel) {
        return null;
    }

    @Override
    public Iterable<Edge<NebulaVertex, NebulaEdge>> getEdges(EdgeDirection direction) {
        return null;
    }

    @Override
    public <T> void addProperty(String propertyName, T value) {

    }

    @Override
    public <T> void addListProperty(String propertyName, T value) {

    }

    @Override
    public NebulaVertex getV() {
        return null;
    }


}
