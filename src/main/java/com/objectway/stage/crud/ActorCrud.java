package com.objectway.stage.crud;

import com.objectway.stage.model.Actor;

import java.util.List;

public interface ActorCrud {

    List<Actor> findAllActors();

    Actor saveActor(Actor actor);

    Actor updateActor(Actor actor);

    Actor findActorById(int id);

}
