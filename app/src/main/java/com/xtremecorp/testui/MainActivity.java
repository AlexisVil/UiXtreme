package com.xtremecorp.testui;



import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    private EditText usr;
    private EditText idNum;
    private CheckBox guardar;
    private TextInputLayout password;
    private TextInputEditText clave;
    String savedPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        guardar = findViewById(R.id.checkBox);
        usr = findViewById(R.id.username);
        idNum = findViewById(R.id.identification);

        password = findViewById(R.id.password);
        clave = findViewById(R.id.clave);


    }

    public void login(View view) {
        LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);
        Handler handler = new Handler();
        String usrName = usr.getText().toString();
        String id_String = idNum.getText().toString();
        String clave_String = clave.getText().toString();
        if (usrName.length() != 0 && id_String.length() != 0 && clave_String.length() != 0) {
            if (guardar.isChecked()) {
                Toast.makeText(this, "password saved", Toast.LENGTH_SHORT).show();
                savedPass = clave_String;
            }
            loadingDialog.startLoadingDialog();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismissDialog();
                }
            },5000);
        } else {
            Toast.makeText(this, "complete fields", Toast.LENGTH_SHORT).show();
        }
    }
}