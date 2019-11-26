package cn.dmwqaq.chat_room.mapper;

import cn.dmwqaq.chat_room.pojo.User;

public interface UserMapper {

    User getById(String id) throws Exception;

    int create(User user) throws Exception;

    int update(User user) throws Exception;
}
