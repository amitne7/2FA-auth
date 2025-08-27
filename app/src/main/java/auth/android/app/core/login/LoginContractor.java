package auth.android.app.core.login;

import auth.android.app.request.login.MobileRequest;
import auth.android.app.request.login.VerifyOtpRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.login.LoginResponse;

public interface LoginContractor {
    interface View {
        void onMobileResponse(GeneralResponse response);
        void onOtpResponse(GeneralResponse response);
        void onVerifyOtpResponse(LoginResponse response);
    }
    interface Presenter {
        void onMobileResponse(GeneralResponse response);
        void mobileRequest(MobileRequest request);
        void onVerifyOtpResponse(LoginResponse response);
        void verifyOtpRequest(VerifyOtpRequest request);
        void onOtpResponse(GeneralResponse response);
        void otpRequest(MobileRequest request);
    }
    interface Interactor {
        void mobileRequest(MobileRequest request);
        void verifyOtpRequest(VerifyOtpRequest request);
        void otpRequest(MobileRequest request);
    }
}
