package auth.android.app.core.common;

import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.common.PageDataResponse;

public interface CommonContractor {
    interface View {
        void onPageResponse(PageDataResponse response);
    }
    interface Presenter {
        void onPageResponse(PageDataResponse response);
        void pageRequest(PageDataRequest request);
    }
    interface Interactor {
        void pageRequest(PageDataRequest request);
    }
}
