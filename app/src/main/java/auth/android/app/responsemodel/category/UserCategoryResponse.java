package auth.android.app.responsemodel.category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserCategoryResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<CategoryData> categoryDataList;

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

    public List<CategoryData> getCategoryDataList() {
        return categoryDataList;
    }

    public void setCategoryDataList(List<CategoryData> categoryDataList) {
        this.categoryDataList = categoryDataList;
    }
}
