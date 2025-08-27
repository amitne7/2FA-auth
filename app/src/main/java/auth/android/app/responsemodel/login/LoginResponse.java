package auth.android.app.responsemodel.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("page_type")
    private String pageType;

    @SerializedName("data")
    private LoginData loginData;

    @SerializedName("event_id")
    private int eventId;

    @SerializedName("pre_launcher_welcome_tab")
    private int preLauncherWelcomeTab;

    @SerializedName("tab_index")
    private String tabIndex;


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

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public LoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getPreLauncherWelcomeTab() {
        return preLauncherWelcomeTab;
    }

    public void setPreLauncherWelcomeTab(int preLauncherWelcomeTab) {
        this.preLauncherWelcomeTab = preLauncherWelcomeTab;
    }

    public String getTabIndex() {
        return tabIndex;
    }

    public void setTabIndex(String tabIndex) {
        this.tabIndex = tabIndex;
    }
}
