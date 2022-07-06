package com.platzi.movie.data;

import java.util.Collection;

import com.platzi.movie.model.Movie;

public interface MovieRepository {
  
  Movie findById(long id);
  Collection<Movie> findAll();
  void saveOrUpdate(Movie movie);

}