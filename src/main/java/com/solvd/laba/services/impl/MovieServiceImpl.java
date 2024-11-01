package com.solvd.laba.services.impl;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Movie;
import com.solvd.laba.services.Mapping.MovieMapper;
import com.solvd.laba.services.MyBatisConfig;
import com.solvd.laba.services.interfaces.MovieService.MovieService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final SqlSessionFactory sqlSessionFactory;

    public MovieServiceImpl() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Movie findById(Integer id) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            return mapper.findById(id);
        } catch (Exception e) {
            throw new ServiceException("Error finding movie by ID", e);
        }
    }

    @Override
    public List<Movie> findAll() throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            return mapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error finding all movies", e);
        }
    }

    @Override
    public void save(Movie movie) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            mapper.insert(movie);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error saving movie", e);
        }
    }

    @Override
    public void update(Movie movie) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            mapper.update(movie);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error updating movie", e);
        }
    }

    @Override
    public void delete(Movie movie) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            mapper.delete(movie);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error deleting movie", e);
        }
    }

    @Override
    public List<Movie> findByGenre(String genre) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MovieMapper mapper = sqlSession.getMapper(MovieMapper.class);
            return mapper.findByGenre(genre);
        } catch (Exception e) {
            throw new ServiceException("Error finding movies by genre", e);
        }
    }
}