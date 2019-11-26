package cn.dmwqaq.chat_room.mapper;

import cn.dmwqaq.chat_room.pojo.User;

public interface UserMapper {

    User getById(String id);
    int create(User user);
    int update(User user);
}
