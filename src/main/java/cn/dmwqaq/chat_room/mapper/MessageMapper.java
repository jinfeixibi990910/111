package cn.dmwqaq.chat_room.mapper;

import cn.dmwqaq.chat_room.pojo.Message;

public interface MessageMapper {

    Message getById(String id);
    int create(Message message);
    int updade(Message message);
}
