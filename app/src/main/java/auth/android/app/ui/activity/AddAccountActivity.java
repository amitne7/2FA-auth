package auth.android.app.ui.activity;

import static auth.android.app.utils.Utils.getFont;
import static auth.android.app.utils.Utils.showMessageOnMainThread;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class AddAccountActivity extends BaseActivity implements AccountContractor.View {

    Toolbar toolbar;
    EditText etEmail;
    EditText etAccountName;
    EditText etLocation;
    EditText etLocationName;
    Button btnRegister;
    RelativeLayout progressBar;

    private static final int REQUEST_SELECT_LOCATION = 1003;
    private AccountPresenter accountPresenter;
    private String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        initViews();
        PrefsUtil prefsUtil = new PrefsUtil(this);
        accountPresenter = new AccountPresenter(this);
        deviceId = prefsUtil.getString(Constants.PREF_DEVICE_ID);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        etEmail = findViewById(R.id.et_email);
        etLocation = findViewById(R.id.et_location);
        etAccountName = findViewById(R.id.et_account_name);
        etLocationName = findViewById(R.id.et_location_name);
        btnRegister = findViewById(R.id.btn_submit_account);
        progressBar = findViewById(R.id.progress_background);

        toolbar.setTitle(getString(R.string.txt_add_account));
        btnRegister.setTypeface(getFont(this, Constants.BOLD));
        etLocation.setTypeface(getFont(this, Constants.REGULAR));
        etEmail.setTypeface(getFont(this, Constants.REGULAR));
        etLocation.setTypeface(getFont(this, Constants.REGULAR));
        etLocationName.setTypeface(getFont(this, Constants.REGULAR));
        etAccountName.setTypeface(getFont(this, Constants.REGULAR));
        etLocation.setOnClickListener(view -> startActivityForResult(new Intent(AddAccountActivity.this, MapActivity.class), REQUEST_SELECT_LOCATION));
        btnRegister.setOnClickListener(view -> submitAccountDetails());
    }


    private void submitAccountDetails() {
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
            String lat = null;
            String lng = null;
            if (data != null) {
                lat = data.getStringExtra("lat");
                lng = data.getStringExtra("lng");
            }
            etLocation.setText(lat + ", " + lng);
        }
    }


    @Override
    public void onBackPressed() {
        finish();
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
