package auth.android.app.responsemodel.account;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<AccountData> accountDataList;

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

    public List<AccountData> getAccountDataList() {
        return accountDataList;
    }

    public void setAccountDataList(List<AccountData> accountDataList) {
        this.accountDataList = accountDataList;
    }
}
