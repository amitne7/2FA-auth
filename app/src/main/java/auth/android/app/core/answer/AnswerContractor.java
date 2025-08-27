package auth.android.app.core.answer;


import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.answer.AnswerResponse;

public interface AnswerContractor {
    interface View {
        void OnAnswerResponse(AnswerResponse answerResponse);
    }
    interface Presenter {
        void OnAnswerResponse(AnswerResponse answerResponse);
        void answerRequest(PageDataRequest request);
    }
    interface Interactor {
        void answerRequest(PageDataRequest request);
    }
}
