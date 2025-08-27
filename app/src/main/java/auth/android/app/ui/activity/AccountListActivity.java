package auth.android.app.ui.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.request.FcmTokenRequest;
import auth.android.app.request.account.AccountRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountData;
import auth.android.app.responsemodel.account.AccountResponse;
import auth.android.app.ui.adapter.AccountListAdapter;
import auth.android.app.utils.Constants;
import auth.android.app.utils.NotificationReceiver;
import auth.android.app.utils.PrefsUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import event.msvc.android.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static auth.android.app.utils.Utils.getFont;

public class AccountListActivity extends AppCompatActivity {

    @BindView(R.id.iv_add_account)
    ImageView ivAdd;

    @BindView(R.id.lv_accounts)
    ListView lvAccount;

    @BindView(R.id.tv_error)
    TextView tvError;

    private List<AccountData> accountDataList;
    private PrefsUtil prefsUtil;
    private AccountListAdapter adapter;
    private AlertDialog dialog;
    NotificationReceiver receiver = new NotificationReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);
        ButterKnife.bind(this);
        prefsUtil = new PrefsUtil(this);
        getAccountData();
        updateFcmToken();
        if (null != getIntent().getStringExtra("event_tab_id")) {
            showDialog(getIntent().getStringExtra("event_tab_id"));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("auth.android.app.NOTI_LISTENER"));
    }

    @OnClick(R.id.iv_add_account)
    void onClickAdd() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    private void getAccountData() {
        AccountRequest request = new AccountRequest(prefsUtil.getString(Constants.PREF_EMAIL));
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<AccountResponse> call = webservice.getAccountList(request);
        call.enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if(response.isSuccessful()) {
                    if (response.body().isStatus()) {
                        accountDataList = response.body().getAccountDataList();
                        adapter = new AccountListAdapter(AccountListActivity.this, accountDataList);
                        lvAccount.setAdapter(adapter);
                    } else {
                        tvError.setVisibility(View.VISIBLE);
                        lvAccount.setVisibility(View.GONE);
                        tvError.setText(response.body().getMessage());
                    }
                } else {
                    Toast.makeText(AccountListActivity.this, "Network error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable throwable) {
                Toast.makeText(AccountListActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showDialog(String accessCode) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_alert_layout, null);
        TextView ok = view.findViewById(R.id.ok);
        final TextView cancel = view.findViewById(R.id.cancel);
        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        tv2.setTypeface(getFont(this, Constants.REGULAR));
        ok.setTypeface(getFont(this, Constants.REGULAR));
        tv2.setText(accessCode);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        builder.setView(view);
        dialog = builder.create();
        dialog.show();

    }

    private void updateFcmToken() {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        FcmTokenRequest fcmTokenRequest = new FcmTokenRequest("", 0, prefsUtil.getString(Constants.PREF_FCM_TOKEN), prefsUtil.getString(Constants.PREF_EMAIL));
        Call<GeneralResponse> call = webservice.deviceTokn(fcmTokenRequest);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });
    }
}