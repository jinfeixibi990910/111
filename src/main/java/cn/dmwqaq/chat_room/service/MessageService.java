package cn.dmwqaq.chat_room.service;

import cn.dmwqaq.chat_room.mapper.MessageMapper;
import cn.dmwqaq.chat_room.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public Message getById(String id) {
        return messageMapper.getById(id);
    }

    public boolean create(Message message) {
        return messageMapper.create(message) > 0;
    }

    public boolean update(Message message) {
        return messageMapper.updade(message) > 0;
    }

}
