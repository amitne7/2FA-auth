package auth.android.app.responsemodel.others;

import com.google.gson.annotations.SerializedName;

public class WorldClock {
    @SerializedName("country")
    private String country;

    @SerializedName("timezone")
    private String timeZone;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
