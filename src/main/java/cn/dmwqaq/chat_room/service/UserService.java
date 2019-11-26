package cn.dmwqaq.chat_room.service;

import cn.dmwqaq.chat_room.pojo.User;

public interface UserService {

    boolean update(User user);

    boolean create(User user);

    User getById(String id);
}
