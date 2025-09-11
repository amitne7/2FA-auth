package auth.android.app.core.account;

import auth.android.app.request.account.AccountRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;


/**
 * This file is for interface for creating and fetching account list
 */

public interface AccountContractor {
    interface View {
        void addAccountResponse(GeneralResponse response);
        void accountListResponse(AccountResponse response);
    }
    interface Presenter {
        void addAccountResponse(GeneralResponse response);
        void accountListResponse(AccountResponse response);
        void addAccountRequest(RegisterRequest request);
        void accountListRequest(AccountRequest request);
    }
    interface Interactor {
        void addAccountRequest(RegisterRequest request);
        void accountListRequest(AccountRequest request);
    }
}
