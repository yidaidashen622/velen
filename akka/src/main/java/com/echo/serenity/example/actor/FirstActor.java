package com.echo.serenity.example.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.example.model.FirstActorRequest;
import com.echo.serenity.example.model.SecondActorRequest;

import akka.actor.AbstractActorWithTimers;
import akka.actor.Props;

/**
 * Created by xushu.
 */
public class FirstActor extends AbstractActorWithTimers {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstActor.class);

    public static Props props() {
        return Props.create(FirstActor.class, FirstActor::new);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(FirstActorRequest.class, this::processRequest)
                .build();
    }

    private void processRequest(FirstActorRequest s1Request) {
        System.out.println("first actor process request done. ");
        getContext().getParent().tell(new SecondActorRequest(), self());
    }

}
