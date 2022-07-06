package com.platzi.movie.model;

public class Movie {

  private Integer id;
  private String name;
  private int minutes;
  private Genre genre;

  public Movie(String name, int minutes, Genre genre) {
      this(null, name, minutes, genre);
  }

  public Movie(Integer id, String name, int minutes, Genre genre) {
      this.id = id;
      this.name = name;
      this.minutes = minutes;
      this.genre = genre;
  }

  public Integer getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  public int getMinutes() {
      return minutes;
  }

  public Genre getGenre() {
      return genre;
  }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + minutes;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (genre != other.genre)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (minutes != other.minutes)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

  

}