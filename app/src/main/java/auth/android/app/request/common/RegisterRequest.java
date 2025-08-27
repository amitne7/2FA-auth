package auth.android.app.request.common;

public class RegisterRequest {
    private String name;
    private String email;
    private String mobile;
    private String latitude;
    private String longitude;

    public RegisterRequest(String name, String email, String mobile, String latitude, String longitude) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
