package auth.android.app.core.exhibitor;

import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.common.PageDataResponse;

public interface ExhibitorContractor {
    interface View {
        void getExhibitorList(PageDataResponse response);
        void followExhibitor(GeneralResponse response);
        void sendMeeting(GeneralResponse response);
    }
    interface Presenter {
        void getExhibitorList(PageDataResponse response);
        void getExhibitorListRequest(PageDataRequest request);

        void followExhibitor(GeneralResponse response);
        void followExhibitorRequest();

        void sendMeeting(GeneralResponse response);
        void sentMeetingRequest();
    }
    interface Interactor {
        void getExhibitorListRequest(PageDataRequest request);
        void followExhibitorRequest();
        void sentMeetingRequest();
    }
}
