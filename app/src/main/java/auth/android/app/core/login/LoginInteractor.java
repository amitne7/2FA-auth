package auth.android.app.core.login;

import auth.android.app.remote.ApiClient;
import auth.android.app.request.login.MobileRequest;
import auth.android.app.request.login.VerifyOtpRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.login.LoginResponse;
import auth.android.app.remote.Webservice;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor implements LoginContractor.Interactor {
    private LoginPresenter loginPresenter;

    public LoginInteractor(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void mobileRequest(MobileRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.login(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                if (response.isSuccessful())
                    loginPresenter.onMobileResponse(response.body());
                else
                    loginPresenter.onMobileResponse(null);
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                loginPresenter.onMobileResponse(null);
            }
        });
    }

    @Override
    public void verifyOtpRequest(VerifyOtpRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<LoginResponse> call = webservice.verifyOtp(request);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful())
                    loginPresenter.onVerifyOtpResponse(response.body());
                else
                    loginPresenter.onVerifyOtpResponse(null);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginPresenter.onVerifyOtpResponse(null);
            }
        });
    }

    @Override
    public void otpRequest(MobileRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.resendOtp(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                if (response.isSuccessful())
                    loginPresenter.onOtpResponse(response.body());
                else
                    loginPresenter.onOtpResponse(null);
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                loginPresenter.onOtpResponse(null);
            }
        });
    }
}
