package com.solvd.laba.services.impl;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Reservation;
import com.solvd.laba.services.Mapping.ReservationMapper;
import com.solvd.laba.services.MyBatisConfig;
import com.solvd.laba.services.interfaces.ReservationService.ReservationService;
import com.solvd.laba.services.listener.ReservationListener;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationServiceImpl implements ReservationService {
    private List<ReservationListener> listeners = new ArrayList<>();

    private final SqlSessionFactory sqlSessionFactory;

    public ReservationServiceImpl() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public Reservation findByStatus(String status) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findByStatus(status);
        } catch (Exception e) {
            throw new ServiceException("Failed to get reservation with status " + status, e);
        }
    }

    @Override
    public Reservation findById(Integer integer) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findById(integer);
        } catch (Exception e) {
            throw new ServiceException("Failed to get reservation with id " + integer, e);
        }
    }

    @Override
    public List<Reservation> findAll() throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            return mapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Failed to get reservations", e);
        }
    }

    @Override
    public void save(Reservation entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.insert(entity);
        }
    }

    @Override
    public void update(Reservation entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.update(entity);
        } catch (Exception e) {
            throw new ServiceException("Failed to update reservation", e);
        }
    }

    @Override
    public void delete(Reservation entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ReservationMapper mapper = session.getMapper(ReservationMapper.class);
            mapper.delete(entity);
        } catch (Exception e) {
            throw new ServiceException("Failed to delete reservation", e);
        }
    }

    public void addListener(ReservationListener listener) {
        listeners.add(listener);
    }

    public void createReservation(Reservation reservation) {
        // Save reservation
        listeners.forEach(l -> l.onReservationCreated(reservation));
    }
}
