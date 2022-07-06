package com.platzi.movie.data;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.platzi.movie.model.Genre;
import com.platzi.movie.model.Movie;

public class MovieRepositoryIntegrationTest {
  
  private MovieRepositoryJdbc movieRepositoryJdbc;
  private DataSource dataSource;

  @Before
  public void setUp() throws ScriptException, SQLException {
    dataSource =
      new DriverManagerDataSource("jdbc:h2:mem:testdb;MODE=MySQL", "sa", "sa");
    ScriptUtils.executeSqlScript(
      dataSource.getConnection(),
      new ClassPathResource("test-data.sql")
    );
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
  }

  @After
  public void tearDown() throws SQLException {
    final Statement s = dataSource.getConnection().createStatement();
    s.executeUpdate("drop all objects delete files");
  }

  @Test
  public void loadAllMovies() throws ScriptException, SQLException {
    Collection<Movie> movies = movieRepositoryJdbc.findAll();
    assertEquals(
      Arrays.asList(
        new Movie(1, "Dark Knight", 152, Genre.ACTION),
        new Movie(2, "Memento", 113, Genre.THRILLER),
        new Movie(3, "Matrix", 136, Genre.ACTION)
      ), movies);
  }

  @Test
  public void loadMovieById() {
    Movie movie = movieRepositoryJdbc.findById(2);
    assertEquals(
      new Movie(2, "Memento", 113, Genre.THRILLER),
      movie
    );
  }

  @Test
  public void insertAMovie() {
    Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
    movieRepositoryJdbc.saveOrUpdate(movie);
    Movie movieFromDb = movieRepositoryJdbc.findById(4);
    assertEquals(new Movie(4, "Super 8", 112, Genre.THRILLER), movieFromDb);

  }

}