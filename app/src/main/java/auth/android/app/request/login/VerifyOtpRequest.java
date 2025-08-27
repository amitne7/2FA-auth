package auth.android.app.request.login;

public class VerifyOtpRequest {
    private String mobile;
    private String otp;
    private int deviceType=1;
    private String deviceToken;

    public VerifyOtpRequest(String mobile, String otp, String deviceToken) {
        this.mobile = mobile;
        this.otp = otp;
        this.deviceToken = deviceToken;
    }
}
