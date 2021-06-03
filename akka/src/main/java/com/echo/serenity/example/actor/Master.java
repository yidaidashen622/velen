package com.echo.serenity.example.actor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.echo.serenity.example.model.FirstActorRequest;
import com.echo.serenity.example.model.SecondActorRequest;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Created by xushu.
 */
public class Master extends AbstractActor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Master.class);

    private ActorRef firstActor;
    private ActorRef secondActor;


    public static Props props(){
        return Props.create(Master.class, Master::new);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();
        initActors();
    }

    /*

     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(FirstActorRequest.class, this::handleS1)
                .match(SecondActorRequest.class, this::handleS2)
                .matchAny(o -> LOGGER.error("received unknown message, {}", o))
                .build();
    }

    private void initActors() {
        firstActor = getContext().actorOf(FirstActor.props(), "s1");
        secondActor = getContext().actorOf(SecondActor.props(), "s2");
    }

    private void handleS1(FirstActorRequest request) {
        firstActor.tell(request, getSelf());
    }

    private void handleS2(SecondActorRequest request) {
        secondActor.tell(request, getSelf());
    }
}
