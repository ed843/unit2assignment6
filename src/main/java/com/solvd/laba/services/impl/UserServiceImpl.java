package com.solvd.laba.services;

import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.User;
import com.solvd.laba.services.Mapping.UserMapper;
import com.solvd.laba.services.interfaces.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final SqlSessionFactory sqlSessionFactory;

    public UserServiceImpl() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public User findByUsername(String username) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findByUsername(username);
        } catch (Exception e) {
            throw new ServiceException("Failed to find user with username: " + username, e);
        }
    }

    @Override
    public User findById(Integer id) throws ServiceException {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findById(id);
        } catch (Exception e) {
            throw new ServiceException("Failed to find user with id: " + id, e);
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findAll();
        } catch (Exception e) {
            throw new ServiceException("Failed to find all users", e);
        }
    }

    @Override
    public void save(User user) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.insert(user);
        } catch (Exception e) {
            throw new ServiceException("Failed to save user", e);
        }
    }

    @Override
    public void update(User entity) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.update(entity);
        } catch (Exception e) {
            throw new ServiceException("Failed to update user", e);
        }
    }

    @Override
    public void delete(User entity) throws ServiceException {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.delete(entity);
        } catch (Exception e) {
            throw new ServiceException("Failed to delete user", e);
        }
    }
}
