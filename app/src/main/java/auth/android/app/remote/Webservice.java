package auth.android.app.remote;

import java.util.Map;

import auth.android.app.request.EventRequest;
import auth.android.app.request.FcmTokenRequest;
import auth.android.app.request.NotePadRequest;
import auth.android.app.request.QuestionRatingRequest;
import auth.android.app.request.QuestionRequest;
import auth.android.app.request.QuizAnswerRequest;
import auth.android.app.request.ScanRequest;
import auth.android.app.request.TokenRequest;
import auth.android.app.request.account.AccountRequest;
import auth.android.app.request.common.PageDataRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.request.home.HomePageRequest;
import auth.android.app.request.login.MobileRequest;
import auth.android.app.request.login.VerifyOtpRequest;
import auth.android.app.request.survey.SurveyQuestions;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;
import auth.android.app.responsemodel.agenda.AgendaResponse;
import auth.android.app.responsemodel.answer.AnswerResponse;
import auth.android.app.responsemodel.category.UserCategoryResponse;
import auth.android.app.responsemodel.common.PageDataResponse;
import auth.android.app.responsemodel.event.EventResponse;
import auth.android.app.responsemodel.feedback.QuestionsResponse;
import auth.android.app.responsemodel.gallery.GalleryResponse;
import auth.android.app.responsemodel.home.HomePageResponse;
import auth.android.app.responsemodel.home.VersionResponse;
import auth.android.app.responsemodel.login.LoginResponse;
import auth.android.app.responsemodel.speakers.SpeakerResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Webservice {
    @POST("hello")
    Call<GeneralResponse> login(@Body MobileRequest loginRequest);

    @POST("verifyOTP")
    Call<LoginResponse> verifyOtp(@Body VerifyOtpRequest verifyOtpRequest);

    @POST("resendOtp")
    Call<GeneralResponse> resendOtp(@Body MobileRequest loginRequest);

    @POST("getEvents")
    Call<EventResponse> getEvent(@Body EventRequest eventRequest);

    @POST("getHomeTabsByEventId")
    Call<HomePageResponse> homeTabs(@Body HomePageRequest request);

    @POST("save_user_notepad")
    Call<GeneralResponse> saveNotePad(@Body NotePadRequest notePadRequest);

    @POST("getPageData")
    Call<PageDataResponse> getPageData(@Body PageDataRequest pageDataRequest);

    @POST("getSpeakers")
    Call<SpeakerResponse>  getSpeakers(@Body PageDataRequest request);

    @POST("getPageData")
    Call<AgendaResponse> getAgenda(@Body PageDataRequest pageDataRequest);

    @POST("getGallery")
    Call<GalleryResponse> galleryData(@Body PageDataRequest pageDataRequest);

    @POST("getQuestions")
    Call<QuestionsResponse> getQuestions(@Body TokenRequest tokenRequest);

    @POST("save_user_feedback")
    Call<GeneralResponse> saveFeedback(@Body QuestionRatingRequest questionRatingRequest);

    @POST("scanUserQR")
    Call<GeneralResponse> scanInfo(@Body ScanRequest scanRequest);

    @Multipart
    @POST("save_user_uploaddoc")
    Call<GeneralResponse> uploadId(@Part("token") RequestBody token, @Part("mobile") RequestBody mobile, @Part("uid") RequestBody uid, @Part("udid") RequestBody qqid, @Part("event_id") RequestBody event_id, @Part("event_tab_id") RequestBody event_tab_id, @Part MultipartBody.Part iFile);

    @POST("getQuestionTypes")
    Call<UserCategoryResponse> getQuestionCategory(@Body TokenRequest request);

    @POST("save_user_question")
    Call<GeneralResponse> askQuestion(@Body QuestionRequest questionRequest);

    @POST("getQuizQuestions")
    Call<QuestionsResponse> getQuizQuestions(@Body PageDataRequest request);

    @POST("save_user_quiz")
    Call<GeneralResponse> saveAnswer(@Body QuizAnswerRequest quizAnswerRequest);

    @POST("saveActSurveyData")
    Call<GeneralResponse> saveSurvey(@Body SurveyQuestions requests);

    @POST("deleteAccount")
    Call<GeneralResponse> deleteAccount(@Body PageDataRequest pageDataRequest);

    @POST("device_token")
    Call<GeneralResponse> deviceTokn(@Body FcmTokenRequest fcmTokenRequest);

    @POST("getQuesReply")
    Call<AnswerResponse> getAnswers(@Body PageDataRequest pageDataRequest);

    @Multipart
    @POST("registerProcess")
    Call<GeneralResponse> registration(
            @Part("first_name") RequestBody fName,
            @Part("last_name") RequestBody lName,
            @Part("email") RequestBody email,
            @Part("dob") RequestBody dob,
            @Part("anniversary_date") RequestBody anni,
            @Part("mobile") RequestBody mobile,
            @Part MultipartBody.Part dFile,
            @Part("city") RequestBody city,
            @Part("spouse_name") RequestBody spouse,
            @Part("address") RequestBody address
    );

    @Multipart
    @POST("update_user_image")
    Call<GeneralResponse> uploadProfile(
            @Part("token") RequestBody token,
            @Part("mobile") RequestBody mobile,
            @Part("uid") RequestBody uid,
            @Part("event_id") RequestBody event_id,
            @Part MultipartBody.Part iFile,
            @Part("type") RequestBody type,
            @Part("event_tab_id") RequestBody eventTabId,
            @Part("deviceType") RequestBody deviceType
    );


    @POST("app_version")
    Call<VersionResponse> getAppVersion(@Body HomePageRequest homePageRequest);

    @POST("register")
    Call<GeneralResponse> register(@Body RegisterRequest request);

    @POST("get_accounts_list")
    Call<AccountResponse> getAccountList(@Body AccountRequest request);

    @POST("send_device_location")
    Call<GeneralResponse> sendLocation(@Body Map<String, String> data);

}
