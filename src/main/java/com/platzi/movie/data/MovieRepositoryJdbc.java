package com.platzi.movie.data;

import java.util.Collection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.platzi.movie.model.Genre;
import com.platzi.movie.model.Movie;

public class MovieRepositoryJdbc implements MovieRepository {

  private JdbcTemplate jdbcTemplate;

  public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Movie findById(long id) {
    Object[] args = { id };
    return jdbcTemplate.queryForObject("select * from movies where id = ?", args, rowMapper);
  }

  @Override
  public Collection<Movie> findAll() {
    return jdbcTemplate.query("select * from movies", rowMapper);
  }

  @Override
  public void saveOrUpdate(Movie movie) {
    jdbcTemplate.update("insert into movies (name, minutes, genre) values (?, ?, ?)",
      movie.getName(), movie.getMinutes(), movie.getGenre().name());
  }

  private static RowMapper<Movie> rowMapper = (rs, rowNum) -> new Movie(
    rs.getInt("id"),
    rs.getString("name"),
    rs.getInt("minutes"),
    Genre.valueOf(rs.getString("genre"))
  );
}