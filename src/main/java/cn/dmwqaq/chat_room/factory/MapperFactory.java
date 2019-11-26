package cn.dmwqaq.chat_room.factory;

import cn.dmwqaq.chat_room.mapper.MessageMapper;
import cn.dmwqaq.chat_room.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MapperFactory {

    private static SqlSession session;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            session = sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserMapper getUserMapper() {
        return session.getMapper(UserMapper.class);
    }

    public static MessageMapper getMessageMapper() {
        return session.getMapper(MessageMapper.class);
    }
}