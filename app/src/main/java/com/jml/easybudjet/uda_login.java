package com.jml.easybudjet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.libizo.CustomEditText;

import DataLayer.data_lyr_DB_Initialize;
import DataLayer.data_lyr_login;
import Model_Packages.udm_login;

public class uda_login extends AppCompatActivity {
    final AppCompatActivity udo_current_activity = uda_login.this;
    private Context context = this;
    private data_lyr_DB_Initialize DB_Initialixer;
    private data_lyr_login dbhelper_login;
    private udjc_core udm_core = new udjc_core();
    AppCompatTextView udtv_signup;
    CustomEditText udet_userid;
    CustomEditText udet_password;
    Button udbtn_login;

    /*Global Variable Declarations*/
    String udo_username="";
    String udo_password="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uda_login);

        DB_Initialixer = new data_lyr_DB_Initialize(this);
        dbhelper_login = new data_lyr_login(this);
        DB_Initialixer.udf_initializedb();

        udet_userid     = findViewById(R.id.udet_userid);
        udet_password   = findViewById(R.id.udet_password);
        udbtn_login     = findViewById(R.id.udbtn_login);
        udtv_signup     = findViewById(R.id.udtv_signup);

        // Login Process
        udbtn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(udet_userid.getText().toString())) {
                    udm_core.udf_ShowAlert("Easy Budjet","Username Can not Empty",udo_current_activity);
                }else if (TextUtils.isEmpty(udet_password.getText().toString())) {
                    udm_core.udf_ShowAlert("Easy Budjet","Password Can not Empty",udo_current_activity);
                }else{
                    udo_username = udet_userid.getText().toString();
                    udo_password = udet_password.getText().toString();

                    Boolean is_ValidateUser = dbhelper_login.udf_ValidateUser(udo_username,udo_password);
                    if(is_ValidateUser){
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        // Sign up Process
        udtv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog SignupDialog = new Dialog(context);
                SignupDialog.setContentView(R.layout.udcl_signup);

                //Find Controls in Dialog
                final LinearLayout udlyt_errorlayout              = SignupDialog.findViewById(R.id.udlyt_errorlayout);
                final AppCompatTextView udtv_errortext            = SignupDialog.findViewById(R.id.udtv_errortext);
                final AppCompatTextView udtv_error_closebutton    = SignupDialog.findViewById(R.id.udtv_error_closebutton);

                udtv_error_closebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        udlyt_errorlayout.setVisibility(View.GONE);
                    }
                });

                final CustomEditText udet_username        =  SignupDialog.findViewById(R.id.udet_username);
                final CustomEditText udet_email           =  SignupDialog.findViewById(R.id.udet_email);
                final CustomEditText udet_phone           =  SignupDialog.findViewById(R.id.udet_phone);
                final CustomEditText udet_password        =  SignupDialog.findViewById(R.id.udet_password);
                final CustomEditText udet_confirmpassword =  SignupDialog.findViewById(R.id.udet_confirmpassword);
                final CustomEditText udet_pin             =  SignupDialog.findViewById(R.id.udet_pin);

                AppCompatButton udbtn_signup =  SignupDialog.findViewById(R.id.udbtn_signup);
                AppCompatButton udbtn_cancel =  SignupDialog.findViewById(R.id.udbtn_cancel);

                udbtn_signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        udlyt_errorlayout.setVisibility(View.GONE);
                        // registration process get values from fields
                        udm_login ude_login = new udm_login();
                        ude_login.setUdmo_name(udet_username.getText().toString());
                        ude_login.setUdmo_email(udet_email.getText().toString());
                        ude_login.setUdmo_phone(udet_phone.getText().toString());
                        ude_login.setUdmo_password(udet_password.getText().toString());
                        ude_login.setUdmo_oldpassword(udet_password.getText().toString());
                        ude_login.setUdmo_pin(udet_pin.getText().toString());
                        if (udet_password.getText().toString().equals(udet_confirmpassword.getText().toString())){
                            Boolean udo_result = dbhelper_login.udf_InsertData(ude_login);
                            if(udo_result){
                                udlyt_errorlayout.setBackgroundColor(getResources().getColor(R.color.SuccessColor));
                                udtv_errortext.setText("Registration Completed.try login");
                                //Toast.makeText(getApplicationContext(),"Registration Completed. Try to login",Toast.LENGTH_SHORT).show();
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Do something after 700ms
                                        SignupDialog.dismiss();
                                    }
                                }, 700);
                            }else {
                                Toast.makeText(getApplicationContext(),"Failed to Sign up.",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            udlyt_errorlayout.setVisibility(View.VISIBLE);
                            udlyt_errorlayout.setBackgroundColor(getResources().getColor(R.color.ErrorLightColor));
                            udtv_errortext.setText("Password does not match...");
                            udet_confirmpassword.requestFocus();
                        }

                    }
                });
                udbtn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SignupDialog.dismiss();
                    }
                });


                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(SignupDialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                SignupDialog.show();
                //SignupDialog.getWindow().setBackgroundDrawableResource(R.drawable.udcd_signup_bg);

                SignupDialog.getWindow().setAttributes(lp);
            }
        });

    }
}
