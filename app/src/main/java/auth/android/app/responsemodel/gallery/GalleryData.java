package auth.android.app.responsemodel.gallery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GalleryData implements Serializable {

    @SerializedName("pvid")
    private String pvId;

    @SerializedName("event_id")
    private String eventId;

    @SerializedName("filename")
    private String fileName;

    @SerializedName("type")
    private String type;

    @SerializedName("thumbnail")
    private String thumbnail;

    public String getPvId() {
        return pvId;
    }

    public void setPvId(String pvId) {
        this.pvId = pvId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
