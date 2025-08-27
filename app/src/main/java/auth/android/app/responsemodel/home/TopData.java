package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopData {
    @SerializedName("left")
    private List<PageDataList> leftDataList;

    @SerializedName("right")
    private List<PageDataList> rightDataList;

    public List<PageDataList> getLeftDataList() {
        return leftDataList;
    }

    public void setLeftDataList(List<PageDataList> leftDataList) {
        this.leftDataList = leftDataList;
    }

    public List<PageDataList> getRightDataList() {
        return rightDataList;
    }

    public void setRightDataList(List<PageDataList> rightDataList) {
        this.rightDataList = rightDataList;
    }
}
