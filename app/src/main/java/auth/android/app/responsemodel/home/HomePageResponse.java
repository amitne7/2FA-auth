package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomePageResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("bg_image")
    private String bg_image;

    @SerializedName("header_visible")
    private int headerVisible;

    @SerializedName("code")
    private int code;

    @SerializedName("pre_launcher_welcome_tab")
    private int welcomeTab;

    @SerializedName("data")
    private List<PageDataList> pageDataLists;

    @SerializedName("beacon")
    private BeaconData beaconData;

    @SerializedName("slider_view")
    private int sliderView;

    @SerializedName("slider")
    private List<String> imageList;

    @SerializedName("bottom_slider")
    private List<BottomSlider> bottomSlider;

    @SerializedName("slider_clickable")
    private List<ClickableSlider> clickableSlider;

    @SerializedName("bottom")
    private BottomNavigation bottomNavigation;

    @SerializedName("grid_count")
    private int gridCount;

    @SerializedName("header_color")
    private String headerColor;

    @SerializedName("header_bg_color")
    private String headerBgColor;

    @SerializedName("top")
    private TopData topData;

    @SerializedName("feeds")
    private List<PageDataList> notificationList;

    @SerializedName("bend")
    private String bend;

    @SerializedName("event_bend")
    private String eventBend;

    @SerializedName("marquee")
    private MarqueeData marqueeData;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBg_image() {
        return bg_image;
    }

    public void setBg_image(String bg_image) {
        this.bg_image = bg_image;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getWelcomeTab() {
        return welcomeTab;
    }

    public void setWelcomeTab(int welcomeTab) {
        this.welcomeTab = welcomeTab;
    }

    public List<PageDataList> getPageDataLists() {
        return pageDataLists;
    }

    public void setPageDataLists(List<PageDataList> pageDataLists) {
        this.pageDataLists = pageDataLists;
    }

    public BeaconData getBeaconData() {
        return beaconData;
    }

    public void setBeaconData(BeaconData beaconData) {
        this.beaconData = beaconData;
    }

    public int getSliderView() {
        return sliderView;
    }

    public void setSliderView(int sliderView) {
        this.sliderView = sliderView;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public List<BottomSlider> getBottomSlider() {
        return bottomSlider;
    }

    public void setBottomSlider(List<BottomSlider> bottomSlider) {
        this.bottomSlider = bottomSlider;
    }

    public List<ClickableSlider> getClickableSlider() {
        return clickableSlider;
    }

    public void setClickableSlider(List<ClickableSlider> clickableSlider) {
        this.clickableSlider = clickableSlider;
    }

    public int getGridCount() {
        return gridCount;
    }

    public void setGridCount(int gridCount) {
        this.gridCount = gridCount;
    }

    public String getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(String headerColor) {
        this.headerColor = headerColor;
    }

    public String getHeaderBgColor() {
        return headerBgColor;
    }

    public void setHeaderBgColor(String headerBgColor) {
        this.headerBgColor = headerBgColor;
    }

    public TopData getTopData() {
        return topData;
    }

    public void setTopData(TopData topData) {
        this.topData = topData;
    }

    public BottomNavigation getBottomNavigation() {
        return bottomNavigation;
    }

    public void setBottomNavigation(BottomNavigation bottomNavigation) {
        this.bottomNavigation = bottomNavigation;
    }

    public int getHeaderVisible() {
        return headerVisible;
    }

    public void setHeaderVisible(int headerVisible) {
        this.headerVisible = headerVisible;
    }

    public List<PageDataList> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<PageDataList> notificationList) {
        this.notificationList = notificationList;
    }

    public String getBend() {
        return bend;
    }

    public void setBend(String bend) {
        this.bend = bend;
    }

    public String getEventBend() {
        return eventBend;
    }

    public void setEventBend(String eventBend) {
        this.eventBend = eventBend;
    }

    public MarqueeData getMarqueeData() {
        return marqueeData;
    }

    public void setMarqueeData(MarqueeData marqueeData) {
        this.marqueeData = marqueeData;
    }
}
