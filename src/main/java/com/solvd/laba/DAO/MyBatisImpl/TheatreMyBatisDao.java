package com.solvd.laba.DAO.MyBatisImpl;

import com.solvd.laba.DAO.TheatreDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Theatre;
import com.solvd.laba.services.Mapping.TheatreMapper;
import com.solvd.laba.services.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class TheatreMyBatisDao implements TheatreDao {
    private final SqlSessionFactory sqlSessionFactory;

    public TheatreMyBatisDao() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Theatre findById(Integer id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<Theatre> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void save(Theatre theatre) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.insert(theatre);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Theatre theatre) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.update(theatre);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Theatre theatre) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            mapper.delete(theatre);
            sqlSession.commit();
        }
    }

    @Override
    public List<Theatre> findByLocation(String location) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            TheatreMapper mapper = sqlSession.getMapper(TheatreMapper.class);
            return mapper.findByLocation(location);
        }
    }
}
