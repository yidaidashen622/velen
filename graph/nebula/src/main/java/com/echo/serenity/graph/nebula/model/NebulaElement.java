package com.echo.serenity.graph.nebula.model;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.graph.api.model.Element;
import com.vesoft.nebula.client.graph.data.BaseDataObject;

/**
 * Created by xushu.
 */
public class NebulaElement<T extends BaseDataObject> implements Element {

    private static final Logger LOGGER = LoggerFactory.getLogger(NebulaElement.class);

    protected final T element;

    public NebulaElement(T element) {
        this.element = element;
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<? extends String> getPropertyKeys() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T getProperty(String propertyName, Class<T> type) {
        throw new UnsupportedOperationException();
    }
}
