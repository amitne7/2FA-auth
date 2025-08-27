package auth.android.app.request;

/**
 * Created by sudhirharit on 30/03/18.
 */

public class FcmTokenRequest {

    private String token;
    private int uid;
    private String deviceToken;
    private String email;
    private String deviceType = "1";

    public FcmTokenRequest(String token, int uid, String deviceToken, String email) {
        this.token = token;
        this.uid = uid;
        this.deviceToken = deviceToken;
        this.email = email;
    }
}
