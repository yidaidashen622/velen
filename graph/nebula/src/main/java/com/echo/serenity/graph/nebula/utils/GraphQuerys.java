package com.echo.serenity.graph.nebula.utils;

import static com.echo.serenity.graph.nebula.constant.Constants.DELETE_EDGE;
import static com.echo.serenity.graph.nebula.constant.Constants.DELETE_VERTEX;
import static com.echo.serenity.graph.nebula.constant.Constants.INSERT_EDGE;
import static com.echo.serenity.graph.nebula.constant.Constants.INSERT_VERTEX;

import java.util.Properties;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.graph.nebula.constant.enums.GraphEntityTag;
import com.echo.serenity.graph.nebula.constant.enums.GraphRelationTag;
import com.echo.serenity.graph.nebula.dto.Depend;
import com.echo.serenity.graph.nebula.dto.Metric;

/**
 * Created by xushu.
 */
public class GraphQuerys {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQuerys.class);

    public static String buildInsertVertexQuery(Properties properties) {
        GraphEntityTag tag = GraphEntityTag.valueOf(properties.getProperty("tag"));
        switch (tag) {
            case METRIC:
                return buildInsertVertexQuery(tag, new Metric(properties));
            default:
                throw new RuntimeException();
        }
    }

    public static String buildDeleteVertexQuery(String vertexId) {
        String name = GraphEntityTag.parseGraphEntityTagById(vertexId).getName();
        return String.format(DELETE_VERTEX, name, vertexId);
    }

    public static String buildInsertEdgeQuery(String inId, String outId, Properties properties) {
        return buildInsertEdgeQuery(GraphRelationTag.DEPEND, new Depend(inId, outId, properties));
    }

    public static String buildDeleteEdgeQuery(String edgeId) {
        String name = GraphRelationTag.parseGraphRelationTagById(edgeId).getName();
        return String.format(DELETE_EDGE, name, edgeId);
    }

    private static String buildInsertEdgeQuery(GraphRelationTag graphRelationTag, Object object) {
        StringJoiner joiner = new StringJoiner(",").add(object.toString());
        String name = graphRelationTag.getName();
        String properties = graphRelationTag.getProperties();
        return String.format(INSERT_EDGE, name, properties, joiner);
    }

    private static String buildInsertVertexQuery(GraphEntityTag graphEntityTag, Object object) {
        StringJoiner joiner = new StringJoiner(",").add(object.toString());
        String name = graphEntityTag.getName();
        String properties = graphEntityTag.getProperties();
        return String.format(INSERT_VERTEX, name, properties, joiner);
    }


}
