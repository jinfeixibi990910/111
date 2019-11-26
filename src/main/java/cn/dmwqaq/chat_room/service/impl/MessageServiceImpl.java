package cn.dmwqaq.chat_room.service.impl;

import cn.dmwqaq.chat_room.factory.MapperFactory;
import cn.dmwqaq.chat_room.mapper.MessageMapper;
import cn.dmwqaq.chat_room.pojo.Message;
import cn.dmwqaq.chat_room.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageServiceImpl implements MessageService {

    private static Logger logger = LogManager.getLogger(MessageServiceImpl.class);
    private static MessageMapper messageMapper;

    static {
        try {
            messageMapper = MapperFactory.getMessageMapper();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public Message getById(String id) throws Exception {
        return messageMapper.getById(id);
    }

    @Override
    public boolean create(Message message) throws Exception {
        return messageMapper.create(message) > 0;
    }

    @Override
    public boolean update(Message message) throws Exception {
        return messageMapper.updade(message) > 0;
    }
}
