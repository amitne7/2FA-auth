package auth.android.app.core.question;


import auth.android.app.request.QuestionRequest;
import auth.android.app.request.TokenRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.category.UserCategoryResponse;

public interface QuestionContractor {
    interface View {
        void onCategoryResponse(UserCategoryResponse response);
        void onQuestionSaveResponse(GeneralResponse response);
    }
    interface Presenter {
        void onCategoryResponse(UserCategoryResponse response);
        void onQuestionSaveResponse(GeneralResponse response);
        void categoryRequest(TokenRequest request);
        void questionSubmitRequest(QuestionRequest request);
    }
    interface Interactor {
        void categoryRequest(TokenRequest request);
        void questionSubmitRequest(QuestionRequest request);
    }
}
