package opg.app.myrefrigerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button btLogin, btResister, btSignUp, btSingIn;
    LinearLayout loLinear, reLinear;
    TextView tvFindAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    loLinear = (LinearLayout) findViewById(R.id.loginLinear);
    reLinear = (LinearLayout) findViewById(R.id.resisterLinear);

    // ID/PW 찾기 화면으로
    tvFindAccount = (TextView) findViewById(R.id.forgotTv1);
    tvFindAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), FindAccount.class);
            startActivity(intent);
        }
    });

    // 로그인! 메인 화면으로
    btSingIn = (Button) findViewById(R.id.singInbt1);
    btSingIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    });


    // 로그인 화면으로
    btLogin = (Button) findViewById(R.id.loginbt2);
    btLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loLinear.setVisibility(View.VISIBLE);
            reLinear.setVisibility(View.INVISIBLE);
        }
    });

    // 등록 화면으로
    btResister = (Button) findViewById(R.id.resisterbt1);
    btResister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loLinear.setVisibility(View.INVISIBLE);
            reLinear.setVisibility(View.VISIBLE);
        }
    });

    // 등록 화면에서 회원가입 버튼 눌렀을 때
    btSignUp = (Button) findViewById(R.id.singUpbt1);
    btSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showSignUpDialog();
        }
    });
    }
    // 회원가입 성공 다이얼로그
 void showSignUpDialog(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Sign Up");
    builder.setMessage("회원가입 성공, 로그인 화면으로 이동합니다.");
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            loLinear.setVisibility(View.VISIBLE);
            reLinear.setVisibility(View.INVISIBLE);
        }
    });
     builder.show();
}


}