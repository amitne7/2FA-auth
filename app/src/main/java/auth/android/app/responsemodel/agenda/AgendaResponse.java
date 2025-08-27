package auth.android.app.responsemodel.agenda;

import com.google.gson.annotations.SerializedName;

public class AgendaResponse {

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;


    @SerializedName("data")
    private AgendaPageData pageData;

    @SerializedName("code")
    private int code;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AgendaPageData getPageData() {
        return pageData;
    }

    public void setPageData(AgendaPageData pageData) {
        this.pageData = pageData;
    }
}
