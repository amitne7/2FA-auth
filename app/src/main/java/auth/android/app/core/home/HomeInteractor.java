package auth.android.app.core.home;

import android.util.Log;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.home.HomePageRequest;
import auth.android.app.responsemodel.home.HomePageResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor implements HomeContractor.Interactor {
    private HomePresenter homePresenter;

    public HomeInteractor(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }

    @Override
    public void homeRequest(HomePageRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<HomePageResponse> call = webservice.homeTabs(request);
        call.enqueue(new Callback<HomePageResponse>() {
            @Override
            public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
                if (response.isSuccessful())
                    homePresenter.onHomeResponse(response.body());
                else
                    homePresenter.onHomeResponse(null);
            }

            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {
                Log.e("Message",t.getMessage()+" / "+t.getLocalizedMessage());
                homePresenter.onHomeResponse(null);
            }
        });

    }
}
