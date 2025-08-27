package auth.android.app.responsemodel.chat;

import com.google.gson.annotations.SerializedName;

public class ChatData {
    @SerializedName("msg_id")
    private String msgId;

    @SerializedName("sender_id")
    private String senderId;

    @SerializedName("sender_name")
    private String senderName;

    @SerializedName("receiver_id")
    private int receiverId;

    @SerializedName("receiver_name")
    private String receiverName;

    @SerializedName("message")
    private String message;

    @SerializedName("date_added")
    private String dateAdded;

    @SerializedName("reply")
    private String type;

    public ChatData(String msgId, String senderId, String senderName, int receiverId, String receiverName, String message, String dateAdded, String type) {
        this.msgId = msgId;
        this.senderId = senderId;
        this.senderName = senderName;
        this.receiverId = receiverId;
        this.receiverName = receiverName;
        this.message = message;
        this.dateAdded = dateAdded;
        this.type = type;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
