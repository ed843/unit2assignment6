package com.solvd.laba.services.impl;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.Screening;
import com.solvd.laba.services.Mapping.ScreeningMapper;
import com.solvd.laba.services.MyBatisConfig;
import com.solvd.laba.services.interfaces.ScreeningService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ScreeningServiceImpl implements ScreeningService {

    private final SqlSessionFactory sqlSessionFactory;

    public ScreeningServiceImpl() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public List<Screening> findByMovieId(Integer id) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findByMovieId(id);
        } catch (Exception e) {
            throw new ServiceException("Error finding screening by Movie ID", e);
        }
    }

    @Override
    public Screening findById(Integer integer) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findById(integer);
        } catch (Exception e) {
            throw new ServiceException("Error finding screening by ID", e);
        }
    }

    @Override
    public List<Screening> findAll() throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            return mapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error finding all screenings", e);
        }
    }

    @Override
    public void save(Screening entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.insert(entity);
        } catch (Exception e) {
            throw new ServiceException("Error saving screening", e);
        }
    }

    @Override
    public void update(Screening entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.update(entity);
        } catch (Exception e) {
            throw new ServiceException("Error updating screening", e);
        }
    }

    @Override
    public void delete(Screening entity) throws ServiceException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ScreeningMapper mapper = session.getMapper(ScreeningMapper.class);
            mapper.delete(entity);
        } catch (Exception e) {
            throw new ServiceException("Error deleting screening", e);
        }
    }
}
