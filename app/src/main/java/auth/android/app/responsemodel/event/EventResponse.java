package auth.android.app.responsemodel.event;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("bg_image")
    private String bg_image;

    @SerializedName("data")
    private List<EventData> eventData;

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

    public String getBg_image() {
        return bg_image;
    }

    public void setBg_image(String bg_image) {
        this.bg_image = bg_image;
    }

    public List<EventData> getEventData() {
        return eventData;
    }

    public void setEventData(List<EventData> eventData) {
        this.eventData = eventData;
    }
}
