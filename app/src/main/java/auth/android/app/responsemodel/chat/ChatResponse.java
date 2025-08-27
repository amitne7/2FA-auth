package auth.android.app.responsemodel.chat;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private List<ChatData> chatDataList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ChatData> getChatDataList() {
        return chatDataList;
    }

    public void setChatDataList(List<ChatData> chatDataList) {
        this.chatDataList = chatDataList;
    }
}
