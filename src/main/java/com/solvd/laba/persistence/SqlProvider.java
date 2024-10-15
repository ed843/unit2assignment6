package com.solvd.laba.persistence;

public class SqlProvider {
    private DatabaseDialect dialect;

    public SqlProvider(DatabaseDialect dialect) {
        this.dialect = dialect;
    }

    public String getInsertMovieQuery() {
        switch (dialect) {
            case MYSQL:
                return "INSERT INTO Movie (title, duration, genre, release_date) VALUES (?, ?, ?, ?)";
            case POSTGRESQL:
                return "INSERT INTO Movie (title, duration, genre, release_date) VALUES (?, ?, ?, ?) RETURNING movie_id";
            default:
                throw new IllegalStateException("Unsupported database dialect: " + dialect);
        }
    }

    public String getFindMovieByIdQuery() {
        switch (dialect) {
            case MYSQL:
            case POSTGRESQL:
                return "SELECT * FROM Movie WHERE movie_id = ?";
            default:
                throw new IllegalStateException("Unsupported database dialect: " + dialect);
        }
    }

    // Add more methods for other SQL queries...
}
