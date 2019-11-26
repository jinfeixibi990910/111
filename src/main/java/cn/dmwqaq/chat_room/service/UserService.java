package cn.dmwqaq.chat_room.service;

import cn.dmwqaq.chat_room.pojo.User;

public interface UserService {

    boolean update(User user) throws Exception;

    boolean create(User user) throws Exception;

    User getById(String id) throws Exception;
}
