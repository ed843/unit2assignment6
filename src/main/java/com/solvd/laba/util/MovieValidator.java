package com.solvd.laba.util;

import com.solvd.laba.exceptions.ValidationException;
import com.solvd.laba.models.Movie;

public class MovieValidator implements Validator<Movie> {
    @Override
    public void validate(Movie movie) throws ValidationException {
        if (movie.getTitle() == null || movie.getTitle().trim().isEmpty()) {
            throw new ValidationException("Movie title cannot be empty");
        }
        if (movie.getDuration() <= 0) {
            throw new ValidationException("Movie duration must be positive");
        }
    }
}
