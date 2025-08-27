package auth.android.app.responsemodel.category;

import com.google.gson.annotations.SerializedName;

public class CategoryData {
    @SerializedName("role_id")
    private String roleId;

    @SerializedName("role_name")
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
