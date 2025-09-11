package auth.android.app.core.account;

import auth.android.app.request.account.AccountRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;

public class AccountPresenter implements AccountContractor.Presenter {
    AccountContractor.View mView;
    AccountInteractor interactor;

    public AccountPresenter(AccountContractor.View mView) {
        this.mView = mView;
        interactor = new AccountInteractor(this);
    }

    @Override
    public void addAccountResponse(GeneralResponse response) {
        mView.addAccountResponse(response);
    }

    @Override
    public void accountListResponse(AccountResponse response) {
        mView.accountListResponse(response);
    }

    @Override
    public void addAccountRequest(RegisterRequest request) {
        interactor.addAccountRequest(request);
    }

    @Override
    public void accountListRequest(AccountRequest request) {
        interactor.accountListRequest(request);
    }
}

