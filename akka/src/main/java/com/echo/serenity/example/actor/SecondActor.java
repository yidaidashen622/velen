package com.echo.serenity.example.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.example.model.SecondActorRequest;

import akka.actor.AbstractActor;
import akka.actor.Props;

/**
 * Created by xushu.
 */
public class SecondActor extends AbstractActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirstActor.class);

    public static Props props() {
        return Props.create(SecondActor.class, SecondActor::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SecondActorRequest.class, this::processRequest)
                .build();
    }

    private void processRequest(SecondActorRequest request) {
        System.out.println("second actor process request done. ");
    }
}
