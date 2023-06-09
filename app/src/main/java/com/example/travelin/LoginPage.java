package com.example.travelin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginPage extends AppCompatActivity {
    //Deklarasi Variabel
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignClient;

    private EditText et_email, et_password;
    private Button btnlogin, btnregister, btngoogle;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener Listener;
    private String getEmail, getPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignClient = GoogleSignIn.getClient(this,gso);

        //Inisialisasi Widget
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btnlogin = findViewById(R.id.btn_login);
        btnregister = findViewById(R.id.btn_register);
        btngoogle = findViewById(R.id.btn_google);

        // Instance / membuat Objek Firebase Autentication
        auth = FirebaseAuth.getInstance();

        //mengecek keberadaan User
        Listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //mengecek apakah ada user yang sudah login / belum logout
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null && user.isEmailVerified()) {
                    //jika ada maka halaman akan langsung berpindah pada Menu Utama
                    startActivity(new Intent(LoginPage.this, FinishLoginPage.class));
                    finish();
                }
            }
        };

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mendapatkan data yang diinputkan User
                getEmail = et_email.getText().toString();
                getPassword = et_password.getText().toString();

                //mengecek apakah email dan sandi kosong atau tidak
                if (TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getPassword)) {
                    Toast.makeText(LoginPage.this, "Email atau Sandi Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    loginUserAccount();
                }
            }

            private void loginUserAccount() {
                auth.signInWithEmailAndPassword(getEmail, getPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull final Task<AuthResult> task) {
                                //Mengecek status keberhasilan saat login
                                if (task.isSuccessful()) {
                                    if (auth.getCurrentUser().isEmailVerified()) {
                                        Toast.makeText(LoginPage.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginPage.this, FinishLoginPage.class);
                                        startActivity(intent);

                                    } else {

                                        AlertDialog.Builder alert = new AlertDialog.Builder(LoginPage.this);
                                        alert.setTitle("Periksa Email anda untuk verifikasi !");
                                        alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                return;
                                            }
                                        });
                                        alert.create();
                                        alert.show();
                                    }
                                }
                            }
                        });
            }

        });



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);
            }
        });


        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }

            private void signIn() {
                Intent signtInIntent = mGoogleSignClient.getSignInIntent();
                startActivityForResult(signtInIntent,1000);
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.webclientid))
                .requestEmail()
                .build();

        mGoogleSignClient = GoogleSignIn.getClient(this,gso);

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode,Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 1000) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    Log.d("Google Sign In","firabaseAuthWithGoogle:" + account.getId());
                    firebaseAuthWithGoogle(account.getIdToken());
                }catch (ApiException e) {
                    Log.w("Google Sign In","Google Sign Failed");
                }
            }
        }

        private void firebaseAuthWithGoogle(String idToken){
            AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);
            auth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Log.d("Google Sign In","signInWithCredential:succes");
                                FirebaseUser user = auth.getCurrentUser();
                            }else{
                                Log.w("Google Sign In","signInWithCredential:failure", task.getException());
                            }
                            reload();
                        }

                        private void reload() {
                            startActivity(new Intent(getApplicationContext(),FinishLoginPage.class));
                        }
                    });
        }
    }