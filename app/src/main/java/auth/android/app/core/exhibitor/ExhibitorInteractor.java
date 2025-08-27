package auth.android.app.core.exhibitor;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.common.PageDataResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibitorInteractor implements ExhibitorContractor.Interactor {
    private ExhibitorPresenter exhibitorPresenter;

    public ExhibitorInteractor(ExhibitorPresenter exhibitorPresenter) {
        this.exhibitorPresenter = exhibitorPresenter;
    }

    @Override
    public void getExhibitorListRequest(PageDataRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<PageDataResponse> call = webservice.getPageData(request);
        call.enqueue(new Callback<PageDataResponse>() {
            @Override
            public void onResponse(Call<PageDataResponse> call, Response<PageDataResponse> response) {
                if (response.isSuccessful())
                    exhibitorPresenter.getExhibitorList(response.body());
                else
                    exhibitorPresenter.getExhibitorList(null);
            }

            @Override
            public void onFailure(Call<PageDataResponse> call, Throwable t) {
                exhibitorPresenter.getExhibitorList(null);
            }
        });
    }

    @Override
    public void followExhibitorRequest() {

    }

    @Override
    public void sentMeetingRequest() {

    }
}
