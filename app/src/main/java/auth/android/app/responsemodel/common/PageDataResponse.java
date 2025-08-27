package auth.android.app.responsemodel.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageDataResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("message")
    private String message;


    @SerializedName("data")
    private PageData pageData;

    @SerializedName("code")
    private int code;

    @SerializedName("color")
    private String color;

    @SerializedName("label")
    private String label;

    @SerializedName("slider")
    private List<String> imageList;



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

    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

}
