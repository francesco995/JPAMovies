package com.objectway.stage.crud;

import com.objectway.stage.model.Movie;

import java.util.List;

public interface MovieCrud {

    List<Movie> findAllMovies();

    Movie saveMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Movie findMovieById(int id);

}
