package auth.android.app.core.question;


import auth.android.app.request.QuestionRequest;
import auth.android.app.request.TokenRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.category.UserCategoryResponse;

public class QuestionPresenter implements QuestionContractor.Presenter {
    private QuestionContractor.View mView;
    private QuestionInteractor interactor;

    public QuestionPresenter(QuestionContractor.View mView) {
        this.mView = mView;
        interactor = new QuestionInteractor(this);
    }

    @Override
    public void onCategoryResponse(UserCategoryResponse response) {
        mView.onCategoryResponse(response);
    }

    @Override
    public void onQuestionSaveResponse(GeneralResponse response) {
        mView.onQuestionSaveResponse(response);
    }

    @Override
    public void categoryRequest(TokenRequest request) {
        interactor.categoryRequest(request);
    }

    @Override
    public void questionSubmitRequest(QuestionRequest request) {
        interactor.questionSubmitRequest(request);
    }
}
