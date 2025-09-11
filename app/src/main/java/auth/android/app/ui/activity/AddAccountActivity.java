package auth.android.app.ui.activity;

import static auth.android.app.utils.Utils.getFont;
import static auth.android.app.utils.Utils.showMessageOnMainThread;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import auth.android.app.R;
import auth.android.app.core.account.AccountContractor;
import auth.android.app.core.account.AccountPresenter;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.responsemodel.account.AccountResponse;
import auth.android.app.utils.Constants;
import auth.android.app.utils.PrefsUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAccountActivity extends BaseActivity implements AccountContractor.View {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_email)
    EditText etEmail;

   @BindView(R.id.et_account_name)
   EditText etAccountName;

    @BindView(R.id.et_location)
    EditText etLocation;

    @BindView(R.id.et_location_name)
    EditText etLocationName;

    @BindView(R.id.btn_submit_account)
    Button btnRegister;

    @BindView(R.id.progress_background)
    RelativeLayout progressBar;

    private static final int REQUEST_SELECT_LOCATION = 1003;
    private PrefsUtil prefsUtil;
    private String lat;
    private String lng;
    private AccountPresenter accountPresenter;
    private String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        ButterKnife.bind(this);
        prefsUtil = new PrefsUtil(this);
        accountPresenter = new AccountPresenter(this);
        deviceId = prefsUtil.getString(Constants.PREF_DEVICE_ID);
        iniViews();

    }



    private void iniViews() {
        toolbar.setTitle(getString(R.string.txt_add_account));
        btnRegister.setTypeface(getFont(this, Constants.BOLD));
        etLocation.setTypeface(getFont(this, Constants.REGULAR));
        etEmail.setTypeface(getFont(this, Constants.REGULAR));
        etLocation.setTypeface(getFont(this, Constants.REGULAR));
        etLocationName.setTypeface(getFont(this, Constants.REGULAR));
        etAccountName.setTypeface(getFont(this, Constants.REGULAR));

    }


    @OnClick(R.id.et_location)
    void onClickLocation() {
        startActivityForResult(new Intent(this, MapActivity.class), REQUEST_SELECT_LOCATION);
    }



    @OnClick(R.id.btn_submit_account)
    void onClickAddAccount() {
        String accountName = etAccountName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        String locationName = etLocationName.getText().toString().trim();
        if (validate(accountName, email, location, locationName)) {
            String lat = location.split(",")[0].trim();
            String lng = location.split(",")[1].trim();
            RegisterRequest request = new RegisterRequest(deviceId, accountName, email, lat, lng, locationName);
            accountPresenter.addAccountRequest(request);
        }

    }

    private boolean validate(String accountName, String email, String location, String locationName) {
        if (TextUtils.isEmpty(accountName)) {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.error_enter_account_name));
            return false;
        }

        if (TextUtils.isEmpty(email)) {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.error_enter_email));
            return false;
        }
        if (TextUtils.isEmpty(location)) {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.error_select_location));
            return false;
        }
        if (TextUtils.isEmpty(locationName)) {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.error_enter_location));
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_LOCATION && resultCode == RESULT_OK) {
            lat = data.getStringExtra("lat");
            lng = data.getStringExtra("lng");
            etLocation.setText(lat + ", " + lng);
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    private void getPermission() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);

        }

    }

    @Override
    public void addAccountResponse(GeneralResponse response) {
        if (null != response) {
            showMessageOnMainThread(this, toolbar.getRootView(), response.getMessage());
            if (response.isStatus())
                finish();

        } else {
            showMessageOnMainThread(this, toolbar.getRootView(), getString(R.string.txt_error_network));
        }
    }

    @Override
    public void accountListResponse(AccountResponse response) {

    }
}
