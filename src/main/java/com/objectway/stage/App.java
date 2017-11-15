package com.objectway.stage;

import com.objectway.stage.crud.ActorCrud;
import com.objectway.stage.crud.ActorCrudImpl;
import com.objectway.stage.crud.MovieCrud;
import com.objectway.stage.crud.MovieCrudImpl;
import com.objectway.stage.model.Actor;
import com.objectway.stage.model.Movie;

import java.util.Date;

public class App {

    public static void main(String[] args) {

        ActorCrud actorCrud = new ActorCrudImpl();
        MovieCrud movieCrud = new MovieCrudImpl();

        for (int i = 0; i < 1; i++) {
            Movie movie1 = new Movie("Movie1", new Date(), 100l, 200l);
            Movie movie2 = new Movie("Movie2", new Date(), 300l, 400l);

            Actor actor1 = new Actor("Actor1", new Date(), 21l);
            Actor actor2 = new Actor("Actor2", new Date(), 22l);

            movie1.addActor(actor1);
            actor1.addMovie(movie1);

//            movie1.addActor(actor2);
//            actor2.addMovie(movie1);

            actorCrud.saveActor(actor1);
            movieCrud.saveMovie(movie1);
//            movieCrud.saveMovie(movie2);

//            actorCrud.saveActor(actor2);


        }

        EntityManagerUtil.close();


    }


}
