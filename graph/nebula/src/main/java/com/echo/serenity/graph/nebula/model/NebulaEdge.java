package com.echo.serenity.graph.nebula.model;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.graph.api.model.Edge;
import com.echo.serenity.graph.api.model.Vertex;
import com.vesoft.nebula.client.graph.data.Relationship;
import com.vesoft.nebula.client.graph.net.Session;

/**
 * Created by xushu.
 */
public class NebulaEdge extends NebulaElement<Relationship> implements Edge<NebulaVertex, NebulaEdge> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NebulaEdge.class);

    private final Session session;

    public NebulaEdge(Relationship element, Session session) {
        super(element);
        this.session = session;
    }

    @Override
    public String getId() {
        return element.srcId() + " -> " + element.dstId();
    }

    @Override
    public Collection<? extends String> getPropertyKeys() {
        try {
            return element.keys();
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
    public Vertex<NebulaVertex, NebulaEdge> getInVertex() {
        return null;
    }

    @Override
    public Vertex<NebulaVertex, NebulaEdge> getOutVertex() {
        return null;
    }

    @Override
    public NebulaEdge getE() {
        return null;
    }
}
