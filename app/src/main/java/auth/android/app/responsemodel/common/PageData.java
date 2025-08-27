package auth.android.app.responsemodel.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import auth.android.app.responsemodel.home.PageDataList;
import auth.android.app.responsemodel.others.WorldClock;
import auth.android.app.responsemodel.others.CurrencyData;
import auth.android.app.responsemodel.others.UserQuestion;

public class PageData {
    @SerializedName("webview_url")
    private String url;

    @SerializedName("webview_html")
    private String html;

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

    @SerializedName("color")
    private String color;

    @SerializedName("button_color")
    private String btnColor;

    @SerializedName("si_image")
    private String siImage;

    @SerializedName("si_video")
    private String videoUrl;

    @SerializedName("world_clock")
    private List<WorldClock> worldClocks;

    @SerializedName("listing")
    private List<PageDataList> listings;

    @SerializedName("border_color")
    private  String borderColor;

    @SerializedName("placeholder")
    private String placeholder;

    @SerializedName("allow_download")
    private int download;

    @SerializedName("open_feedback")
    private int openFeedback;

    @SerializedName("header_visible")
    private String headerVisible;

    @SerializedName("top")
    private String top;

    @SerializedName("sub_heading")
    private String subHeading;

    @SerializedName("sub_heading_color")
    private String subHeadingColor;

    @SerializedName("selected_btn_bg_color")
    private String selectedBtnBgColor;

    @SerializedName("selected_btn_text_color")
    private String selectedBtnTxtColor;

    @SerializedName("extra_btn_text_color")
    private String extraBtnTextcolor;

    @SerializedName("base_level")
    private String currentCountry;

    @SerializedName("currency_exchange")
    private List<CurrencyData> currencyDataList;

    @SerializedName("questions_adv")
    private List<UserQuestion> userQuestions;

    @SerializedName("agenda_date_visible")
    private int agendaDateVisible;

    @SerializedName("slider_view")
    private int sliderView;

    @SerializedName("notepad_text")
    private String notepadText;

    @SerializedName("slider")
    private List<String> sliderImages;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
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

    public String getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(String btnColor) {
        this.btnColor = btnColor;
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

    public List<WorldClock> getWorldClocks() {
        return worldClocks;
    }

    public void setWorldClocks(List<WorldClock> worldClocks) {
        this.worldClocks = worldClocks;
    }

    public List<PageDataList> getListings() {
        return listings;
    }

    public void setListings(List<PageDataList> listings) {
        this.listings = listings;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public int getOpenFeedback() {
        return openFeedback;
    }

    public void setOpenFeedback(int openFeedback) {
        this.openFeedback = openFeedback;
    }

    public String getHeaderVisible() {
        return headerVisible;
    }

    public void setHeaderVisible(String headerVisible) {
        this.headerVisible = headerVisible;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
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

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public List<CurrencyData> getCurrencyDataList() {
        return currencyDataList;
    }

    public void setCurrencyDataList(List<CurrencyData> currencyDataList) {
        this.currencyDataList = currencyDataList;
    }

    public List<UserQuestion> getUserQuestions() {
        return userQuestions;
    }

    public void setUserQuestions(List<UserQuestion> userQuestions) {
        this.userQuestions = userQuestions;
    }

    public int getAgendaDateVisible() {
        return agendaDateVisible;
    }

    public void setAgendaDateVisible(int agendaDateVisible) {
        this.agendaDateVisible = agendaDateVisible;
    }

    public int getSliderView() {
        return sliderView;
    }

    public void setSliderView(int sliderView) {
        this.sliderView = sliderView;
    }

    public List<String> getSliderImages() {
        return sliderImages;
    }

    public void setSliderImages(List<String> sliderImages) {
        this.sliderImages = sliderImages;
    }

    public String getExtraBtnTextcolor() {
        return extraBtnTextcolor;
    }

    public void setExtraBtnTextcolor(String extraBtnTextcolor) {
        this.extraBtnTextcolor = extraBtnTextcolor;
    }

    public String getNotepadText() {
        return notepadText;
    }

    public void setNotepadText(String notepadText) {
        this.notepadText = notepadText;
    }
}
