package auth.android.app.ui.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import auth.android.app.request.FcmTokenRequest;
import auth.android.app.request.common.RegisterRequest;
import auth.android.app.request.login.MobileRequest;
import auth.android.app.utils.PrefsUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import event.msvc.android.R;
import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.responsemodel.GeneralResponse;
import auth.android.app.utils.Constants;
import auth.android.app.utils.FileUtils;
import auth.android.app.utils.Utils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static auth.android.app.utils.Utils.getFont;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.tv_register)
    TextView tvRegister;

    @BindView(R.id.tv_login)
    TextView tvLogin;

    @BindView(R.id.et_fname)
    EditText etFName;

    @BindView(R.id.et_lname)
    EditText etLName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_dob)
    EditText etDob;

    @BindView(R.id.et_anniversary)
    EditText etAnniversary;

    @BindView(R.id.et_spouse)
    EditText etSpouse;

    @BindView(R.id.et_address)
    EditText etAddress;

    @BindView(R.id.et_mobile)
    EditText etMobile;

    @BindView(R.id.et_city)
    EditText etCity;

    @BindView(R.id.btn_id)
    EditText btnIdProof;

    @BindView(R.id.btn_register)
    Button btnRegister;

    @BindView(R.id.progress_background)
    RelativeLayout progressBar;

    final Calendar myCalendar = Calendar.getInstance();
    final Calendar myAnniCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date, aDate;
    private static final int REQUEST_SELECT_DOCS = 1003;
    private String docPath="", fName, lName, email, mobile, dob, city, anniversary, spouse, address;
    String[] fileType = {"pdf", "jpg", "png", "jpeg","doc", "docx"};
    boolean formatError = false;
    private PrefsUtil prefsUtil;
    private String lat;
    private String lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        prefsUtil = new PrefsUtil(this);
        iniViews();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getPermission();
        }


         date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        aDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myAnniCalendar.set(Calendar.YEAR, year);
                myAnniCalendar.set(Calendar.MONTH, monthOfYear);
                myAnniCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateAnnLabel();
            }

        };
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etDob.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateAnnLabel() {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etAnniversary.setText(sdf.format(myAnniCalendar.getTime()));
    }

    private void iniViews() {
        tvRegister.setTypeface(getFont(this, Constants.BOLD));
        tvLogin.setTypeface(getFont(this, Constants.MEDIUM));
        btnIdProof.setTypeface(getFont(this, Constants.REGULAR));
        btnRegister.setTypeface(getFont(this, Constants.BOLD));

        etCity.setTypeface(getFont(this, Constants.REGULAR));
        etFName.setTypeface(getFont(this, Constants.REGULAR));
        etLName.setTypeface(getFont(this, Constants.REGULAR));
        etEmail.setTypeface(getFont(this, Constants.REGULAR));
        etDob.setTypeface(getFont(this, Constants.REGULAR));
        etMobile.setTypeface(getFont(this, Constants.REGULAR));
        etAnniversary.setTypeface(getFont(this, Constants.REGULAR));
        etSpouse.setTypeface(getFont(this, Constants.REGULAR));
        etAddress.setTypeface(getFont(this, Constants.REGULAR));



    }

    @OnClick(R.id.et_dob)
    void onClickDob() {
        new DatePickerDialog(this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.et_anniversary)
    void onClickAnni() {
        new DatePickerDialog(this, aDate, myAnniCalendar
                .get(Calendar.YEAR), myAnniCalendar.get(Calendar.MONTH),
                myAnniCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.et_city)
    void onClickLocation() {
        startActivityForResult(new Intent(this, MapActivity.class), 1000);
    }

    @OnClick(R.id.btn_id)
    void onClick() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/*");
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    REQUEST_SELECT_DOCS);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_register)
    void onre() {
        String name = etFName.getText().toString().trim() + " " + etLName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        prefsUtil.saveString(Constants.PREF_MOBILE, mobile);
        prefsUtil.saveString(Constants.PREF_EMAIL, email);
        RegisterRequest request = new RegisterRequest(name, email, mobile, lat, lng);
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.register(request);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                Toast.makeText(RegistrationActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
//    void onClickRegister() {
//        fName = etFName.getText().toString().trim();
//        lName = etLName.getText().toString().trim();
//        email = etEmail.getText().toString().trim();
//        dob = etDob.getText().toString().trim();
//        mobile = etMobile.getText().toString().trim();
//        city = etCity.getText().toString().trim();
//        anniversary = etAnniversary.getText().toString().trim();
//        spouse = etSpouse.getText().toString().trim();
//        address = etAddress.getText().toString().trim();
//        if (validate(fName, lName, email, dob, mobile, city)) {
//            progressBar.setVisibility(View.VISIBLE);
//            MultipartBody.Part docFile = null;
//            if (!docPath.isEmpty()) {
//                File dFile = new File(docPath);
//                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), dFile);
//                docFile =
//                        MultipartBody.Part.createFormData("id_proof", dFile.getName(), requestFile);
//            }
//            RequestBody mFName = RequestBody.create(MediaType.parse("text/plain"), fName);
//            RequestBody mLName = RequestBody.create(MediaType.parse("text/plain"), lName);
//            RequestBody mEmail = RequestBody.create(MediaType.parse("text/plain"), email);
//            RequestBody mDob = RequestBody.create(MediaType.parse("text/plain"), dob);
//            RequestBody mAnni = RequestBody.create(MediaType.parse("text/plain"), anniversary);
//            RequestBody mMobile = RequestBody.create(MediaType.parse("text/plain"), mobile);
//            RequestBody mCity = RequestBody.create(MediaType.parse("text/plain"), city);
//            RequestBody mSpouse = RequestBody.create(MediaType.parse("text/plain"), spouse);
//            RequestBody mAddress = RequestBody.create(MediaType.parse("text/plain"), address);
//
//            Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
//            Call<GeneralResponse> call = webservice.registration(mFName, mLName, mEmail, mDob, mAnni, mMobile, docFile, mCity, mSpouse, mAddress);
//            call.enqueue(new Callback<GeneralResponse>() {
//                @Override
//                public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
//                    progressBar.setVisibility(View.GONE);
//                    if (response.isSuccessful()) {
//                        if (response.body().isStatus()) {
////                            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
//                            Toast.makeText(RegistrationActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            finish();
//                        } else {
//                            Toast.makeText(RegistrationActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(RegistrationActivity.this, Constants.NETWORK_ERROR, Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<GeneralResponse> call, Throwable t) {
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(RegistrationActivity.this, Constants.NETWORK_ERROR, Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        }
//    }



    @OnClick(R.id.tv_login)
    void onClickLogin() {
//        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private boolean validate(String fName, String lName, String email, String dob, String mobile, String city) {
        if (fName.isEmpty()) {
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lName.isEmpty()) {
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.isEmpty()) {
            Toast.makeText(this, "Enter Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (dob.isEmpty()) {
            Toast.makeText(this, "Select Date of Birth", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mobile.isEmpty()) {
            Toast.makeText(this, "Enter Mobile No", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (docPath.isEmpty()) {
//            Toast.makeText(this, "Select ID Proof", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (city.isEmpty()) {
            Toast.makeText(this, "Enter Base Location", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            lat = data.getStringExtra("lat");
            lng = data.getStringExtra("lng");
            etCity.setText(lat + ", " + lng);
        }
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
//        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void getPermission() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);

        }

    }
}
