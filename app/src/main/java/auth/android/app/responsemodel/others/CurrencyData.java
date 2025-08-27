package auth.android.app.responsemodel.others;

import com.google.gson.annotations.SerializedName;

public class CurrencyData {
    @SerializedName("label")
    private String label;

    @SerializedName("rate")
    private String rate;

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("selected_bg_color")
    private String selectedBgColor;

    @SerializedName("border_radius")
    private int borderRadius;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getSelectedBgColor() {
        return selectedBgColor;
    }

    public void setSelectedBgColor(String selectedBgColor) {
        this.selectedBgColor = selectedBgColor;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }
}
