package auth.android.app.core.home;

import auth.android.app.request.home.HomePageRequest;
import auth.android.app.responsemodel.home.HomePageResponse;

public interface HomeContractor {
    interface View {
        void onHomeResponse(HomePageResponse response);
    }
    interface Presenter {
        void onHomeResponse(HomePageResponse response);
        void homeRequest(HomePageRequest request);
    }
    interface Interactor {
        void homeRequest(HomePageRequest request);
    }
}
