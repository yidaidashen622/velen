package com.echo.serenity.example;

import com.echo.serenity.example.actor.Master;
import com.echo.serenity.example.model.FirstActorRequest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * Created by xushu.
 */
public class ActorHierarchyExperiments {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("serenity");
        ActorRef master = actorSystem.actorOf(Master.props(), "master");
        master.tell(new FirstActorRequest(), null);
    }
}

