package auth.android.app.core.login;

import auth.android.app.request.login.MobileRequest;
import auth.android.app.request.login.VerifyOtpRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.login.LoginResponse;

public class LoginPresenter implements LoginContractor.Presenter {
    private LoginContractor.View mView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginContractor.View mView) {
        this.mView = mView;
        loginInteractor = new LoginInteractor(this);
    }

    @Override
    public void onMobileResponse(GeneralResponse response) {
        mView.onMobileResponse(response);
    }

    @Override
    public void mobileRequest(MobileRequest request) {
        loginInteractor.mobileRequest(request);
    }

    @Override
    public void onVerifyOtpResponse(LoginResponse response) {
        mView.onVerifyOtpResponse(response);
    }

    @Override
    public void verifyOtpRequest(VerifyOtpRequest request) {
        loginInteractor.verifyOtpRequest(request);
    }

    @Override
    public void onOtpResponse(GeneralResponse response) {
        mView.onOtpResponse(response);
    }

    @Override
    public void otpRequest(MobileRequest request) {
        loginInteractor.otpRequest(request);
    }
}
