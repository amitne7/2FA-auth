package auth.android.app.responsemodel.gallery;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GalleryResponse implements Serializable {
    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private boolean status;

    @SerializedName("data")
    private List<GalleryData> galleryData;

    @SerializedName("more")
    private int more;

    @SerializedName("message")
    private String message;

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

    public List<GalleryData> getGalleryData() {
        return galleryData;
    }

    public void setGalleryData(List<GalleryData> galleryData) {
        this.galleryData = galleryData;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
