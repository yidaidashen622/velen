package com.echo.serenity.graph.nebula.config;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vesoft.nebula.client.graph.NebulaPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.net.NebulaPool;

/**
 * Created by xushu.
 */
@Configuration
public class NebulaConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(NebulaConfig.class);

    private static final HostAddress HOST_1 = new HostAddress("127.0.0.1", 9669);
    private static final HostAddress HOST_2 = new HostAddress("127.0.0.1", 9669);

    @Bean
    public NebulaPoolConfig nebulaPoolConfig() {
        NebulaPoolConfig nebulaPoolConfig = new NebulaPoolConfig();
        nebulaPoolConfig.setMaxConnSize(100);
        return nebulaPoolConfig;
    }

    @Bean
    public NebulaPool nebulaPool(NebulaPoolConfig nebulaPoolConfig) {
        try {
            List<HostAddress> addresses = Arrays.asList(HOST_1, HOST_2);
            NebulaPool pool = new NebulaPool();
            pool.init(addresses, nebulaPoolConfig);
            return pool;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
