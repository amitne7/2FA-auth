package auth.android.app.core.answer;


import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.answer.AnswerResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerInteractor implements AnswerContractor.Interactor {
    AnswerPresenter answerPresenter;

    public AnswerInteractor(AnswerPresenter answerPresenter) {
        this.answerPresenter = answerPresenter;
    }

    @Override
    public void answerRequest(PageDataRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<AnswerResponse> call = webservice.getAnswers(request);
        call.enqueue(new Callback<AnswerResponse>() {
            @Override
            public void onResponse(Call<AnswerResponse> call, Response<AnswerResponse> response) {
                if (response.isSuccessful()) {
                    answerPresenter.OnAnswerResponse(response.body());
                } else {
                    answerPresenter.OnAnswerResponse(null);
                }
            }

            @Override
            public void onFailure(Call<AnswerResponse> call, Throwable t) {
                answerPresenter.OnAnswerResponse(null);
            }
        });

    }
}
