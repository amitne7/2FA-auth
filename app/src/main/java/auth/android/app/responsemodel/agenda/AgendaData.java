package auth.android.app.responsemodel.agenda;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AgendaData implements Serializable {
    @SerializedName("time")
    private String time;

    @SerializedName("schedule")
    private String schedule;

    @SerializedName("venue")
    private String venue;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
