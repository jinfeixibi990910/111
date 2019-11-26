package cn.dmwqaq.chat_room.service;

import cn.dmwqaq.chat_room.pojo.Message;

public interface MessageService {

    public Message getById(String id) throws Exception;

    public boolean create(Message message) throws Exception;

    public boolean update(Message message) throws Exception;

}
