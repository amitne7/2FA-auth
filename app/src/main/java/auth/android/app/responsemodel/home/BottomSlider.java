package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

public class BottomSlider {
    @SerializedName("image")
    String imageUrl;

    @SerializedName("video")
    String videoUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
