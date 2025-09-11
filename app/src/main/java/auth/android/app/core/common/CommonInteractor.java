package auth.android.app.core.common;
import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.FcmTokenRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonInteractor implements CommonContractor.Interactor {
    CommonPresenter commonPresenter;

    public CommonInteractor(CommonPresenter commonPresenter) {
        this.commonPresenter = commonPresenter;
    }

    @Override
    public void fcmRequest(final FcmTokenRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.deviceToken(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                commonPresenter.updateFcmTokenResponse(response.body());
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                commonPresenter.updateFcmTokenResponse(null);
            }
        });

    }
}
