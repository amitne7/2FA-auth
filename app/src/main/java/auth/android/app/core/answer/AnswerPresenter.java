package auth.android.app.core.answer;


import auth.android.app.request.common.PageDataRequest;
import auth.android.app.responsemodel.answer.AnswerResponse;

public class AnswerPresenter implements AnswerContractor.Presenter {
    AnswerContractor.View mView;
    AnswerInteractor answerInteractor;

    public AnswerPresenter(AnswerContractor.View mView) {
        this.mView = mView;
        answerInteractor = new AnswerInteractor(this);
    }

    @Override
    public void OnAnswerResponse(AnswerResponse answerResponse) {
        mView.OnAnswerResponse(answerResponse);
    }

    @Override
    public void answerRequest(PageDataRequest request) {
        answerInteractor.answerRequest(request);
    }
}
