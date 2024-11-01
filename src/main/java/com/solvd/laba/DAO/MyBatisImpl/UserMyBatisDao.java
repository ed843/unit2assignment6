package com.solvd.laba.DAO.MyBatisImpl;

import com.solvd.laba.DAO.UserDao;
import com.solvd.laba.exceptions.ServiceException;
import com.solvd.laba.models.User;
import com.solvd.laba.services.Mapping.UserMapper;
import com.solvd.laba.services.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMyBatisDao implements UserDao {
    private final SqlSessionFactory sqlSessionFactory;

    public UserMyBatisDao() {
        this.sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();
    }

    @Override
    public User findByUsername(String username) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findByUsername(username);
        }
    }

    @Override
    public User findById(Integer id) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findById(id);
        }
    }

    @Override
    public List<User> findAll()  {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.findAll();
        }
    }

    @Override
    public void save(User user)  {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.insert(user);
        }
    }

    @Override
    public void update(User entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.update(entity);
        }
    }

    @Override
    public void delete(User entity) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.delete(entity);
        }
    }
}
