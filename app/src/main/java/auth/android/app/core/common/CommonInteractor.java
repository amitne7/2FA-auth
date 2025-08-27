package auth.android.app.core.common;

import android.util.Log;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.common.PageDataResponse;
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
    public void pageRequest(final PageDataRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<PageDataResponse> call = webservice.getPageData(request);
        call.enqueue(new Callback<PageDataResponse>() {
            @Override
            public void onResponse(Call<PageDataResponse> call, Response<PageDataResponse> response) {
                if (response != null)
                    commonPresenter.onPageResponse(response.body());
                else
                    commonPresenter.onPageResponse(null);
            }

            @Override
            public void onFailure(Call<PageDataResponse> call, Throwable t) {
                Log.i("Errr", t.getMessage());
                commonPresenter.onPageResponse(null);
            }
        });

    }
}
