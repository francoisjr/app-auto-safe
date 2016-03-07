package br.com.autosafe.autosafeapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.autosafe.autosafeapp.R;

public class LoginActivity extends AppCompatActivity {


    private TextView tCpf;
    private TextView tSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin(View view) {
        tCpf = (TextView) findViewById(R.id.tCpf);
        tSenha = (TextView) findViewById(R.id.tSenha);
        String cpf = tCpf.getText().toString();
        String senha = tSenha.getText().toString();
        if ("ricardo".equals(cpf) && "123".equals(senha)) {
            alert("Bem-vindo, login realizado com sucesso!");
        } else {
            validaCampos();
            alert("Login/Senha incorretos!");
        }
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void validaCampos() {

        // Reset errors.
        tCpf.setError(null);
        tSenha.setError(null);

        // Store values at the time of the login attempt.
        String cpf = tCpf.getText().toString();
        String password = tSenha.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid cpf address.
        if (TextUtils.isEmpty(cpf)) {
            tCpf.setError(getString(R.string.error_field_required));
            focusView = tCpf;
            cancel = true;
        } else if (!isCpfValid(cpf)) {
            tCpf.setError(getString(R.string.error_invalid_email));
            focusView = tCpf;
            cancel = true;
        }

        // Check for a valid pass address.
        if (TextUtils.isEmpty(password)) {
            tSenha.setError(getString(R.string.error_field_required));
            focusView = tSenha;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            tCpf.setError(getString(R.string.error_invalid_email));
            focusView = tSenha;
            cancel = true;
        }
    }

    private boolean isCpfValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }
}
