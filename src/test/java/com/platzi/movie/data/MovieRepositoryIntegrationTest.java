package com.platzi.movie.data;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.platzi.movie.model.Genre;
import com.platzi.movie.model.Movie;

public class MovieRepositoryIntegrationTest {
  
  @Test
  public void loadAllMovies() throws ScriptException, SQLException {
    DataSource dataSource =
      new DriverManagerDataSource("jdbc:h2:mem:testdb;MODE=MySQL", "sa", "sa");
    ScriptUtils.executeSqlScript(
      dataSource.getConnection(),
      new ClassPathResource("test-data.sql")
    );
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    Collection<Movie> movies = movieRepositoryJdbc.findAll();
    assertEquals(
      Arrays.asList(
        new Movie(1, "Dark Knight", 152, Genre.ACTION),
        new Movie(2, "Memento", 113, Genre.THRILLER),
        new Movie(3, "Matrix", 136, Genre.ACTION)
      ), movies);
  }

}