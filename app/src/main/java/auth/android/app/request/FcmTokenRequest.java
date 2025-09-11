package auth.android.app.request;

public class FcmTokenRequest {

    private String token;
    private int uid;
    private String deviceToken;
    private String deviceId;
    private String deviceType = "1";

    public FcmTokenRequest(String token, int uid, String deviceToken, String deviceId) {
        this.token = token;
        this.uid = uid;
        this.deviceToken = deviceToken;
        this.deviceId = deviceId;
    }
}
