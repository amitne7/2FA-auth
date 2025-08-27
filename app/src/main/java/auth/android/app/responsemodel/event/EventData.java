package auth.android.app.responsemodel.event;

import com.google.gson.annotations.SerializedName;

public class EventData {
    @SerializedName("event_name")
    private String name;

    @SerializedName("event_id")
    private int eventId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
