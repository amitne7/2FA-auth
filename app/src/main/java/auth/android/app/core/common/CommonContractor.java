package auth.android.app.core.common;
import auth.android.app.request.FcmTokenRequest;
import auth.android.app.responsemodel.GeneralResponse;

public interface CommonContractor {
    interface View {
        void updateFcmTokenResponse(GeneralResponse response);
    }
    interface Presenter {
        void updateFcmTokenResponse(GeneralResponse response);
        void fcmRequest(FcmTokenRequest request);
    }
    interface Interactor {
        void fcmRequest(FcmTokenRequest request);
    }
}
