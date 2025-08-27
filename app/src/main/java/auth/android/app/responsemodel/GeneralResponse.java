package auth.android.app.responsemodel;

import com.google.gson.annotations.SerializedName;

public class GeneralResponse {
    @SerializedName("status")
    private boolean status;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("default_otp")
    private int otp;

    @SerializedName("otp_verify")
    private int otpVerify;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public int getOtpVerify() {
        return otpVerify;
    }

    public void setOtpVerify(int otpVerify) {
        this.otpVerify = otpVerify;
    }
}
