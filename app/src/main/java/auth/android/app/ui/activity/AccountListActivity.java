package auth.android.app.ui.activity;

import static auth.android.app.utils.Constants.ACCESS_CODE;
import static auth.android.app.utils.Utils.getFont;
import static auth.android.app.utils.Utils.showMessageOnMainThread;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import auth.android.app.R;
import auth.android.app.core.account.AccountContractor;
import auth.android.app.core.account.AccountPresenter;
import auth.android.app.core.common.CommonContractor;
import auth.android.app.core.common.CommonPresenter;
import auth.android.app.request.FcmTokenRequest;
import auth.android.app.request.account.AccountRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountData;
import auth.android.app.responsemodel.account.AccountResponse;
import auth.android.app.ui.adapter.AccountListAdapter;
import auth.android.app.utils.Constants;
import auth.android.app.utils.NotificationReceiver;
import auth.android.app.utils.PrefsUtil;
import auth.android.app.utils.Utils;

public class AccountListActivity extends AppCompatActivity implements AccountContractor.View, CommonContractor.View {

    TextView tvTitle;
    Toolbar toolbar;
    ListView lvAccount;
    TextView tvError;

    private List<AccountData> accountDataList;
    private PrefsUtil prefsUtil;
    private AccountListAdapter adapter;
    private AlertDialog dialog;
    NotificationReceiver receiver = new NotificationReceiver();
    private AccountPresenter accountPresenter;
    private CommonPresenter commonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_list);
        initViews();
        prefsUtil = new PrefsUtil(this);
        accountPresenter = new AccountPresenter(this);
        commonPresenter = new CommonPresenter(this);
        if (Utils.isNetworkAvailable(this)) {
            updateFcmToken();
        }

//        ivAdd.setVisibility(View.VISIBLE);
        toolbar.setTitle(getString(R.string.txt_account_list));
        setSupportActionBar(toolbar);
        Log.e("TAG", prefsUtil.getString(Constants.PREF_DEVICE_ID));
        if (null != getIntent().getStringExtra(ACCESS_CODE)) {
            showDialog(getIntent().getStringExtra(ACCESS_CODE));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            getPermission();

    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.toolbar_title);
        lvAccount = findViewById(R.id.lv_accounts);
        tvError = findViewById(R.id.tv_error);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            startActivityForResult(new Intent(this, AddAccountActivity.class), 1000);
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("auth.android.app.NOTI_LISTENER"));
        if (Utils.isNetworkAvailable(this))
            getAccountData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1000) {

        }
    }

    private void getAccountData() {
        AccountRequest request = new AccountRequest(prefsUtil.getString(Constants.PREF_DEVICE_ID));
        accountPresenter.accountListRequest(request);
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
        ok.setOnClickListener(view1 -> dialog.dismiss());
        cancel.setOnClickListener(view2 -> dialog.dismiss());
        builder.setView(view);
        dialog = builder.create();
        dialog.show();

    }

    private void openAppInfo() {
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Important Location Alerts !!");
        alertDialogBuilder.setMessage("Please change the Permission of Location to \"Allow all the time\" to fully utilize the application.");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Ok",
                (arg0, arg1) -> {
                    Intent i = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    i.addCategory(Intent.CATEGORY_DEFAULT);
                    i.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(i);
                    arg0.dismiss();

                });

        alertDialogBuilder.setNegativeButton("cancel",
                (arg0, arg1) -> arg0.dismiss());

        android.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void updateFcmToken() {
        FcmTokenRequest fcmTokenRequest = new FcmTokenRequest("", 0, prefsUtil.getString(Constants.PREF_FCM_TOKEN), prefsUtil.getString(Constants.PREF_DEVICE_ID));
        commonPresenter.fcmRequest(fcmTokenRequest);
    }

    private void getPermission() {
        if(Build.VERSION.SDK_INT == 29) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
            }
        } else if(Build.VERSION.SDK_INT >= 30) {
            if (checkSinglePermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)) return;
            openAppInfo();
        }

    }

    @Override
    public void addAccountResponse(GeneralResponse response) {

    }

    @Override
    public void accountListResponse(AccountResponse response) {
        if (null != response) {
            if (response.isStatus()) {
                accountDataList = response.getAccountDataList();
                adapter = new AccountListAdapter(AccountListActivity.this, accountDataList);
                lvAccount.setAdapter(adapter);
            } else {
                tvError.setVisibility(View.VISIBLE);
                lvAccount.setVisibility(View.GONE);
                tvError.setText(response.getMessage());
            }
        } else {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.txt_error_network));
//            Toast.makeText(this, getResources().getString(R.string.txt_error_network), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void updateFcmTokenResponse(GeneralResponse response) {

    }

    public static boolean checkSinglePermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }
}