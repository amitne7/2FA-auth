package auth.android.app.responsemodel.login;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("member_name")
    private String name;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("email")
    private String email;

    @SerializedName("token")
    private String token;

    @SerializedName("id")
    private int id;

    @SerializedName("user_image")
    private String userImage;

    @SerializedName("company_name")
    private String companyName;

    @SerializedName("designation")
    private String designation;

    @SerializedName("user_type")
    private String userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
