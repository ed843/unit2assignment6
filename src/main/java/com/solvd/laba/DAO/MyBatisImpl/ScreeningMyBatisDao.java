package com.solvd.laba.DAO.MyBatisImpl;

import com.solvd.laba.DAO.ScreeningDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Screening;
import com.solvd.laba.services.Mapping.ScreeningMapper;
import com.solvd.laba.services.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;

public class ScreeningMyBatisDao implements ScreeningDao {
    private final SqlSessionFactory sqlSessionFactory;

    public ScreeningMyBatisDao() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public List<Screening> findByMovieId(Integer id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findByMovieId(id);
        }
    }

    @Override
    public Screening findById(Integer integer) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findById(integer);
        }
    }

    @Override
    public List<Screening> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void save(Screening entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.insert(entity);
        }
    }

    @Override
    public void update(Screening entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.update(entity);
        }
    }

    @Override
    public void delete(Screening entity)  {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.delete(entity);
        }
    }
}
