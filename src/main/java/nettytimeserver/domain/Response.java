package nettytimeserver.domain;/** * @author aries */public class Response {    /**     * 发信人     */    private String sender;    /**     * 发送时间     */    private String time;    /**     * 消息内容     */    private String content;    public Response() {    }    public Response(String sender, String time, String content) {        this.sender = sender;        this.time = time;        this.content = content;    }    public String getSender() {        return sender;    }    public void setSender(String sender) {        this.sender = sender;    }    public String getTime() {        return time;    }    public void setTime(String time) {        this.time = time;    }    public String getContent() {        return content;    }    public void setContent(String content) {        this.content = content;    }}