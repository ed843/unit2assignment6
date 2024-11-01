package com.solvd.laba.DAO.MyBatisImpl;

import com.solvd.laba.DAO.MovieDao;
import com.solvd.laba.models.Movie;
import com.solvd.laba.services.Mapping.MovieMapper;
import com.solvd.laba.services.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class MovieMyBatisDao implements MovieDao {
    private final SqlSessionFactory sqlSessionFactory;

    public MovieMyBatisDao() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Movie findById(Integer id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Movie> findAll() throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void save(Movie movie) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.insert(movie);
            session.commit();
        }
    }

    @Override
    public void update(Movie movie) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.update(movie);
            session.commit();
        }
    }

    @Override
    public void delete(Movie movie) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            mapper.delete(movie);
            session.commit();
        }
    }

    @Override
    public List<Movie> findByGenre(String genre) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            MovieMapper mapper = session.getMapper(MovieMapper.class);
            return mapper.findByGenre(genre);
        }
    }
}