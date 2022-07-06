package com.platzi.movie.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.platzi.movie.data.MovieRepository;
import com.platzi.movie.model.Genre;
import com.platzi.movie.model.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
  
  @Mock
  private MovieRepository movieRepository;

  @Before
  public void setup() {
    when(movieRepository.findAll()).thenReturn(
      Arrays.asList(
        new Movie(1, "Dark Knight", 152, Genre.ACTION),
        new Movie(2, "Memento", 113, Genre.THRILLER),
        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
        new Movie(4, "Super 8", 112, Genre.THRILLER),
        new Movie(5, "Scream", 111, Genre.HORROR),
        new Movie(6, "Home Alone", 103, Genre.COMEDY),
        new Movie(7, "Matrix", 136, Genre.ACTION)
      )
    );
  }

  public List<Integer> getIds(Collection<Movie> movies) {
    return movies.stream().map(Movie::getId).collect(Collectors.toList());
  }
  
  @Test
  public void returnMoviesByGenre() {
    setup();
    MovieService movieService = new MovieService(movieRepository);
    Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
    List<Integer> movieIds = getIds(movies);
    assertEquals(Arrays.asList(3, 6), movieIds);
  }

  @Test
  public void returnMoviesByLength() {
    MovieService movieService = new MovieService(movieRepository);
    Collection<Movie> movies = movieService.findMoviesByLength(119);
    List<Integer> movieIds = getIds(movies);
    assertEquals(Arrays.asList(2, 3, 4, 5, 6), movieIds);
  }
  
}
