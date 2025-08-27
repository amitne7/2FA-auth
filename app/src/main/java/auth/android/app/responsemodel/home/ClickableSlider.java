package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClickableSlider implements Serializable {
    @SerializedName("image")
    private String imageUrl;

    @SerializedName("listing")
    private PageDataList items;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PageDataList getItems() {
        return items;
    }

    public void setItems(PageDataList items) {
        this.items = items;
    }
}
