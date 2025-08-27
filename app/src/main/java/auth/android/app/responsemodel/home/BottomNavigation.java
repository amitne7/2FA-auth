package auth.android.app.responsemodel.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BottomNavigation {
    @SerializedName("list")
    private List<PageDataList> bottomNavigationList;

    public List<PageDataList> getBottomNavigationList() {
        return bottomNavigationList;
    }

    public void setBottomNavigationList(List<PageDataList> bottomNavigationList) {
        this.bottomNavigationList = bottomNavigationList;
    }
}
