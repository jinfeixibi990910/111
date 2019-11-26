package cn.dmwqaq.chat_room.service.impl;

import cn.dmwqaq.chat_room.factory.MapperFactory;
import cn.dmwqaq.chat_room.mapper.UserMapper;
import cn.dmwqaq.chat_room.pojo.User;
import cn.dmwqaq.chat_room.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static UserMapper userMapper;
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    static {
        try {
            userMapper = MapperFactory.getUserMapper();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean create(User user) {
        return userMapper.create(user) > 0;
    }

    @Override
    public User getById(String id) {
        return userMapper.getById(id);
    }
}
