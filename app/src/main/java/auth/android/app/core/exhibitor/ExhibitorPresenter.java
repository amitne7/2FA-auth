package auth.android.app.core.exhibitor;

import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.common.PageDataResponse;

public class ExhibitorPresenter implements ExhibitorContractor.Presenter {
    private ExhibitorContractor.View mView;
    private ExhibitorInteractor interactor;

    public ExhibitorPresenter(ExhibitorContractor.View mView) {
        this.mView = mView;
        interactor = new ExhibitorInteractor(this);
    }

    @Override
    public void getExhibitorList(PageDataResponse response) {
        mView.getExhibitorList(response);
    }

    @Override
    public void getExhibitorListRequest(PageDataRequest request) {
        interactor.getExhibitorListRequest(request);
    }

    @Override
    public void followExhibitor(GeneralResponse response) {
        mView.followExhibitor(response);
    }

    @Override
    public void followExhibitorRequest() {
        interactor.followExhibitorRequest();
    }

    @Override
    public void sendMeeting(GeneralResponse response) {
        mView.sendMeeting(response);
    }

    @Override
    public void sentMeetingRequest() {
        interactor.sentMeetingRequest();
    }
}
