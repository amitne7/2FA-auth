package auth.android.app.request.common;

public class RegisterRequest {
    private String deviceId;
    private String accountName;
    private String email;
    private String locationName;
    private String latitude;
    private String longitude;

    public RegisterRequest(String deviceId, String accountName, String email, String latitude, String longitude, String locationName) {
        this.deviceId = deviceId;
        this.accountName = accountName;
        this.email = email;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
