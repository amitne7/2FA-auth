package auth.android.app.core.account;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.account.AccountRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;
import auth.android.app.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountInteractor implements AccountContractor.Interactor {
    AccountPresenter presenter;
    Webservice webservice;

    public AccountInteractor(AccountPresenter presenter) {
        this.presenter = presenter;
        webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
    }

    @Override
    public void addAccountRequest(RegisterRequest request) {
        Call<GeneralResponse> call = webservice.AddAccount(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                presenter.addAccountResponse(response.body());
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable throwable) {
                presenter.addAccountResponse(null);
            }
        });
    }

    @Override
    public void accountListRequest(AccountRequest request) {
        Call<AccountResponse> call = webservice.getAccountList(request);
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                presenter.accountListResponse(response.body());
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable throwable) {
                presenter.accountListResponse(null);
            }
        });
    }
}
