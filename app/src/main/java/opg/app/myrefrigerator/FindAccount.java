package opg.app.myrefrigerator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FindAccount extends AppCompatActivity {
    Button btFindId, btResetPw, btNewPwOkBt;
    LinearLayout findIdL, findPwL;
    String newPassword;
    TextView tvNewPwTitle, tvNewPw, tvNewPwCheck;
    EditText etNewPw, etNewPwCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_account);

        findIdL = (LinearLayout) findViewById(R.id.findIdLinear1);
        findPwL = (LinearLayout) findViewById(R.id.findPwLinear1);

        tvNewPwTitle = (TextView) findViewById(R.id.newPwTitleTv1);
        tvNewPw = (TextView) findViewById(R.id.newPwTv1);
        tvNewPwCheck = (TextView) findViewById(R.id.newPwCheckTv1);

        etNewPw = (EditText) findViewById(R.id.newPwEt1);
        etNewPwCheck = (EditText) findViewById(R.id.newPwCheckEt1);

        btNewPwOkBt = (Button) findViewById(R.id.newPwOkBt1);
        btNewPwOkBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewPwDialog();
            }
        });

        btFindId = (Button) findViewById(R.id.findIdBt1);
        btFindId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFindIdDialog();
            }
        });

        btResetPw = (Button) findViewById(R.id.resetBt1);
        btResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNewPwTitle.setVisibility(View.VISIBLE);
                tvNewPw.setVisibility(View.VISIBLE);
                etNewPw.setVisibility(View.VISIBLE);
                tvNewPwCheck.setVisibility(View.VISIBLE);
                etNewPwCheck.setVisibility(View.VISIBLE);
                btNewPwOkBt.setVisibility(View.VISIBLE);

            }
        });

    }

    void showFindIdDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Find ID");
        builder.setMessage("ID는 ~~입니다.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                findIdL.setVisibility(View.INVISIBLE);
                findPwL.setVisibility(View.VISIBLE);
            }
        });
        builder.show();
    }

    void showNewPwDialog(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("New Password");
        builder2.setMessage("비밀번호가 재설정 되었습니다.");
        builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        builder2.show();
    }


}