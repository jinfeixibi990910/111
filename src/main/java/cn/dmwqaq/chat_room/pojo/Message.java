package cn.dmwqaq.chat_room.pojo;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Message implements Serializable {

    private static final long serialVersionUID = 74831215612364L;

    private String id;
    private String content;
    private String sourceUserId;
    private String targetUserId;
    private String createTime;
    private boolean withdrawn;

    public Message(String id, String content, String sourceUserId, String targetUserId, String createTime,
            boolean withdrawn) {
        this.id = id;
        this.content = content;
        this.sourceUserId = sourceUserId;
        this.targetUserId = targetUserId;
        this.createTime = createTime;
        this.withdrawn = withdrawn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(String sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(boolean withdrawn) {
        this.withdrawn = withdrawn;
    }
}
