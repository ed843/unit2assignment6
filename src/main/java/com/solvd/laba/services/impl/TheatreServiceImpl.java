package com.solvd.laba.services.impl;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Theatre;
import com.solvd.laba.services.Mapping.TheatreMapper;
import com.solvd.laba.services.MyBatisConfig;
import com.solvd.laba.services.interfaces.TheatreService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TheatreServiceImpl implements TheatreService {
    private final SqlSessionFactory sqlSessionFactory;

    public TheatreServiceImpl() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Theatre findById(Integer id) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findById(id);
        } catch (Exception e) {
            throw new ServiceException("Error finding theatre by ID", e);
        }
    }

    @Override
    public List<Theatre> findAll() throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error finding all theatres", e);
        }
    }

    @Override
    public void save(Theatre theatre) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.insert(theatre);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error saving theatre", e);
        }
    }

    @Override
    public void update(Theatre theatre) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.update(theatre);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error updating theatre", e);
        }
    }

    @Override
    public void delete(Theatre theatre) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.delete(theatre);
            sqlSession.commit();
        } catch (Exception e) {
            throw new ServiceException("Error deleting theatre", e);
        }
    }

    @Override
    public List<Theatre> findByLocation(String location) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findByLocation(location);
        }
    }
}