package com.solvd.laba.DAO.MyBatisImpl;

import com.solvd.laba.DAO.ReservationDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.models.User;
import com.solvd.laba.services.Mapping.ReservationMapper;
import com.solvd.laba.services.Mapping.UserMapper;
import com.solvd.laba.services.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ReservationMyBatisDao implements ReservationDao {
    private final SqlSessionFactory sqlSessionFactory;

    public ReservationMyBatisDao() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Reservation findByStatus(String status) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findByStatus(status);
        }
    }

    @Override
    public Reservation findById(Integer integer) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findById(integer);
        }
    }

    @Override
    public List<Reservation> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void save(Reservation entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.insert(entity);
        }
    }

    @Override
    public void update(Reservation entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.update(entity);
        }
    }

    @Override
    public void delete(Reservation entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.delete(entity);
        }
    }
}
