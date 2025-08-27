package auth.android.app.core.home;

import auth.android.app.request.home.HomePageRequest;
import auth.android.app.responsemodel.home.HomePageResponse;

public class HomePresenter implements HomeContractor.Presenter {
    private HomeContractor.View mView;
    private HomeInteractor homeInteractor;

    public HomePresenter(HomeContractor.View mView) {
        this.mView = mView;
        homeInteractor = new HomeInteractor(this);
    }

    @Override
    public void onHomeResponse(HomePageResponse response) {
        mView.onHomeResponse(response);
    }

    @Override
    public void homeRequest(HomePageRequest request) {
        homeInteractor.homeRequest(request);
    }
}
