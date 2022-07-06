package com.platzi.movie.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.platzi.movie.data.MovieRepository;
import com.platzi.movie.model.Genre;
import com.platzi.movie.model.Movie;

public class MovieService {

  private MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public Collection<Movie> findMoviesByGenre(Genre genre) {
    return movieRepository.findAll().stream()
    .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
  }

  public Collection<Movie> findMoviesByLength(int length) {
    return movieRepository.findAll().stream()
    .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
  }

}