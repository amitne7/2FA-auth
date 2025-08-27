package auth.android.app.responsemodel.agenda;

import com.google.gson.annotations.SerializedName;

public class AgendaPageData {

    @SerializedName("webview_url")
    private String url;

    @SerializedName("event_tab_id")
    private String eventTabId;

    @SerializedName("label")
    private String label;

    @SerializedName("header_color")
    private String headerColor;

    @SerializedName("bg_image")
    private String bgImage;

    @SerializedName("si_text")
    private String siText;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("button_bg_color")
    private String btnBgColor;

    @SerializedName("button_color")
    private String btnColor;

    @SerializedName("extra_btn_text_color")
    private String extraBtnTextColor;

    @SerializedName("color")
    private String color;

    @SerializedName("si_image")
    private String siImage;

    @SerializedName("si_video")
    private String videoUrl;


    @SerializedName("listing")
    private AgendaListing listings;

    @SerializedName("header_visible")
    private String headerVisible;

    @SerializedName("sub_heading")
    private String subHeading;

    @SerializedName("sub_heading_color")
    private String subHeadingColor;

    @SerializedName("border_color")
    private String borderColor;

    @SerializedName("selected_btn_bg_color")
    private String selectedBtnBgColor;

    @SerializedName("selected_btn_text_color")
    private String selectedBtnTxtColor;

    @SerializedName("agenda_date_visible")
    private String agendaDateVisible;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEventTabId() {
        return eventTabId;
    }

    public void setEventTabId(String eventTabId) {
        this.eventTabId = eventTabId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(String headerColor) {
        this.headerColor = headerColor;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public String getSiText() {
        return siText;
    }

    public void setSiText(String siText) {
        this.siText = siText;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getSiImage() {
        return siImage;
    }

    public void setSiImage(String siImage) {
        this.siImage = siImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getBtnBgColor() {
        return btnBgColor;
    }

    public void setBtnBgColor(String btnBgColor) {
        this.btnBgColor = btnBgColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AgendaListing getListings() {
        return listings;
    }

    public void setListings(AgendaListing listings) {
        this.listings = listings;
    }

    public String getHeaderVisible() {
        return headerVisible;
    }

    public void setHeaderVisible(String headerVisible) {
        this.headerVisible = headerVisible;
    }

    public String getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(String btnColor) {
        this.btnColor = btnColor;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public String getSubHeadingColor() {
        return subHeadingColor;
    }

    public void setSubHeadingColor(String subHeadingColor) {
        this.subHeadingColor = subHeadingColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getSelectedBtnBgColor() {
        return selectedBtnBgColor;
    }

    public void setSelectedBtnBgColor(String selectedBtnBgColor) {
        this.selectedBtnBgColor = selectedBtnBgColor;
    }

    public String getSelectedBtnTxtColor() {
        return selectedBtnTxtColor;
    }

    public void setSelectedBtnTxtColor(String selectedBtnTxtColor) {
        this.selectedBtnTxtColor = selectedBtnTxtColor;
    }

    public String getAgendaDateVisible() {
        return agendaDateVisible;
    }

    public void setAgendaDateVisible(String agendaDateVisible) {
        this.agendaDateVisible = agendaDateVisible;
    }

    public String getExtraBtnTextColor() {
        return extraBtnTextColor;
    }

    public void setExtraBtnTextColor(String extraBtnTextColor) {
        this.extraBtnTextColor = extraBtnTextColor;
    }
}
