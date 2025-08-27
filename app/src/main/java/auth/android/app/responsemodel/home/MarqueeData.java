package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

public class MarqueeData {
    @SerializedName("text")
    private String text;

    @SerializedName("color")
    private String color;

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("html")
    private String html;


    public String getText() {
        return text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
