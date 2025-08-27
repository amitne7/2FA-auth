package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

public class VersionResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("version")
    private String version;

    @SerializedName("url")
    private String url;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
