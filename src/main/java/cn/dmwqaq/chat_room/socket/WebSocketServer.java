package cn.dmwqaq.chat_room.socket;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
@ServerEndpoint("/webSocket/{username}")
public class WebSocketServer {

    /**
     * 当前在线人数
     */
    private static int onlineCount = 0;

    /**
     * Key: 每位用户的ID
     * Value: 每位用户所持有的WebSocket服务端对象
     */
    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<>();

    /**
     * 当前用户的ID
     */
    private String userId;

    private static Logger logger = LogManager.getLogger(WebSocketServer.class);

    private Session session;

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        this.userId = userId;
        this.session = session;

        clients.put(userId, this);
        addOnlineCount();
        logger.trace(userId + "已连接，当前用户数：" + onlineCount);
    }

    @OnClose
    public void onClose() {
        try {
            clients.remove(userId);
            subOnlineCount();
            logger.trace(userId + "已断开，当前用户数：" + onlineCount);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @OnMessage
    public void onMessage(String messageJsonString) {
        JSONObject messageJson = JSONObject.parseObject(messageJsonString);
        if ("all".equals(messageJson.get("target"))) {
            sendMessage(messageJsonString);
        } else {
            sendMessage(messageJsonString, messageJson.get("target").toString());
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized Map<String, WebSocketServer> getClients() {
        return clients;
    }

    private void sendMessage(String message) {
        for (WebSocketServer item : clients.values()) {
            try {
                item.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private void sendMessage(String message, String target) {
        // session.getBasicRemote().sendText(message);
        //session.getAsyncRemote().sendText(message);
        for (WebSocketServer item : clients.values()) {
            if (item.userId.equals(target)) {
                try {
                    item.session.getAsyncRemote().sendText(message);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
