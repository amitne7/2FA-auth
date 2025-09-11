package auth.android.app.core.common;

import auth.android.app.request.FcmTokenRequest;
import auth.android.app.responsemodel.GeneralResponse;

public class CommonPresenter implements CommonContractor.Presenter {
    CommonContractor.View mView;
    CommonInteractor commonInteractor;

    public CommonPresenter(CommonContractor.View mView) {
        this.mView = mView;
        commonInteractor = new CommonInteractor(this);
    }

    @Override
    public void updateFcmTokenResponse(GeneralResponse response) {
        mView.updateFcmTokenResponse(response);
    }

    @Override
    public void fcmRequest(FcmTokenRequest request) {
        commonInteractor.fcmRequest(request);
    }
}
