package auth.android.app.core.question;


import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.QuestionRequest;
import auth.android.app.request.TokenRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.category.UserCategoryResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionInteractor implements QuestionContractor.Interactor {
    QuestionPresenter questionPresenter;

    public QuestionInteractor(QuestionPresenter questionPresenter) {
        this.questionPresenter = questionPresenter;
    }

    @Override
    public void categoryRequest(TokenRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<UserCategoryResponse> call = webservice.getQuestionCategory(request);
        call.enqueue(new Callback<UserCategoryResponse>() {
            @Override
            public void onResponse(Call<UserCategoryResponse> call, Response<UserCategoryResponse> response) {
                if (response.isSuccessful())
                    questionPresenter.onCategoryResponse(response.body());
                else
                    questionPresenter.onCategoryResponse(null);
            }

            @Override
            public void onFailure(Call<UserCategoryResponse> call, Throwable t) {
                questionPresenter.onCategoryResponse(null);
            }
        });

    }

    @Override
    public void questionSubmitRequest(QuestionRequest request) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.askQuestion(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                if (response.isSuccessful())
                    questionPresenter.onQuestionSaveResponse(response.body());
                else
                    questionPresenter.onQuestionSaveResponse(null);
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                questionPresenter.onQuestionSaveResponse(null);
            }
        });
    }
}
