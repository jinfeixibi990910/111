package cn.dmwqaq.chat_room.mapper;

import cn.dmwqaq.chat_room.pojo.Message;

public interface MessageMapper {

    Message getById(String id) throws Exception;

    int create(Message message) throws Exception;

    int updade(Message message) throws Exception;
}
