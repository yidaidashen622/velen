package com.echo.serenity.graph.nebula.constant;

/**
 * Created by xushu.
 * Nebula Graph SQL : https://docs.nebula-graph.io/2.0.1/3.ngql-guide/1.nGQL-overview/1.overview/
 */
public class Constants {

    public static final String INSERT_EDGE = "INSERT EDGE %s(%s) VALUES %s;";

    public static final String DELETE_EDGE = "DELETE EDGE %s %s;";

    public static final String INSERT_VERTEX = "INSERT VERTEX %s(%s) VALUES %s";

    public static final String DELETE_VERTEX = "DELETE VERTEX %s %s";
}
