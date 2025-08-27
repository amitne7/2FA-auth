package auth.android.app.responsemodel.speakers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpeakerResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<SpeakerData> speakerData;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SpeakerData> getSpeakerData() {
        return speakerData;
    }

    public void setSpeakerData(List<SpeakerData> speakerData) {
        this.speakerData = speakerData;
    }
}
