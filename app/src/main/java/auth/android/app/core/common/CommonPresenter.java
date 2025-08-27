package auth.android.app.core.common;

import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.common.PageDataResponse;

public class CommonPresenter implements CommonContractor.Presenter {
    CommonContractor.View mView;
    CommonInteractor commonInteractor;

    public CommonPresenter(CommonContractor.View mView) {
        this.mView = mView;
        commonInteractor = new CommonInteractor(this);
    }

    @Override
    public void onPageResponse(PageDataResponse response) {
        mView.onPageResponse(response);
    }

    @Override
    public void pageRequest(PageDataRequest request) {
        commonInteractor.pageRequest(request);
    }
}
