package auth.android.app.remote;

import java.util.Map;

import auth.android.app.request.FcmTokenRequest;
import auth.android.app.request.account.AccountRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Webservice {
    @POST("device_token")
    Call<GeneralResponse> deviceToken(@Body FcmTokenRequest fcmTokenRequest);

    @POST("add_account")
    Call<GeneralResponse> AddAccount(@Body RegisterRequest request);

    @POST("get_accounts_list")
    Call<AccountResponse> getAccountList(@Body AccountRequest request);

    @POST("send_device_location")
    Call<GeneralResponse> sendLocation(@Body Map<String, String> data);

}
