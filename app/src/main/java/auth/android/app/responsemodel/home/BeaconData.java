package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

public class BeaconData {
    @SerializedName("event_id")
    private int eventId;

    @SerializedName("beacon_id")
    private int beaconId;

    @SerializedName("beacon_name")
    private String beaconName;

    @SerializedName("beacon_uuid")
    private String beaconUuid;

    @SerializedName("beacon_minor")
    private int beaconMinor;

    @SerializedName("beacon_major")
    private int beaconMajor;

    @SerializedName("beacon_location")
    private String beaconLocation;


    @SerializedName("beacon_enable")
    private boolean beaconEnable;

    @SerializedName("seat_no_text")
    private String seatNo;

    @SerializedName("prompt_btn_text_color")
    private String btnTxtColor;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(int beaconId) {
        this.beaconId = beaconId;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }

    public String getBeaconUuid() {
        return beaconUuid;
    }

    public void setBeaconUuid(String beaconUuid) {
        this.beaconUuid = beaconUuid;
    }

    public int getBeaconMinor() {
        return beaconMinor;
    }

    public void setBeaconMinor(int beaconMinor) {
        this.beaconMinor = beaconMinor;
    }

    public int getBeaconMajor() {
        return beaconMajor;
    }

    public void setBeaconMajor(int beaconMajor) {
        this.beaconMajor = beaconMajor;
    }

    public String getBeaconLocation() {
        return beaconLocation;
    }

    public void setBeaconLocation(String beaconLocation) {
        this.beaconLocation = beaconLocation;
    }

    public boolean isBeaconEnable() {
        return beaconEnable;
    }

    public void setBeaconEnable(boolean beaconEnable) {
        this.beaconEnable = beaconEnable;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getBtnTxtColor() {
        return btnTxtColor;
    }

    public void setBtnTxtColor(String btnTxtColor) {
        this.btnTxtColor = btnTxtColor;
    }
}
