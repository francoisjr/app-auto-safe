package br.com.autosafe.autosafeapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import br.com.autosafe.autosafeapp.R;
import br.com.autosafe.autosafeapp.domain.Cliente;
import br.com.autosafe.autosafeapp.service.LoginService;

public class LoginActivity extends AppCompatActivity {

    //teste
    
    ProgressDialog progressDialog;
    private TextView tCpf;
    private TextView tSenha;
    private String cpf;
    private String senha;
    private Cliente c;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClickLogin(View view) {
        tCpf = (TextView) findViewById(R.id.tCpf);
        tSenha = (TextView) findViewById(R.id.tSenha);
        cpf = tCpf.getText().toString();
        senha = tSenha.getText().toString();
        try {
            if (validaCampos()) {
                taskDados();
            } else {
                alert("nao bateu!");
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private boolean validaCampos() {

        // Reset errors.
        tCpf.setError(null);
        tSenha.setError(null);

        // Store values at the time of the login attempt.
        String cpf = tCpf.getText().toString();
        String password = tSenha.getText().toString();

        boolean passou = false;
        View focusView = null;

        // Check for a valid cpf address.
        if (TextUtils.isEmpty(cpf)) {
            tCpf.setError(getString(R.string.obrigatoriedade_cpf));
            focusView = tCpf;
            passou = false;
        } else if (!isCpfValid(cpf)) {
            tCpf.setError(getString(R.string.erro_cpf_invalido));
            focusView = tCpf;
            passou = false;
        } else if (!TextUtils.isEmpty(cpf) && isCpfValid(cpf)) {
            passou = true;
        }

        // Check for a valid pass address.
        if (TextUtils.isEmpty(password)) {
            tSenha.setError(getString(R.string.obrigatoriedade_senha));
            focusView = tSenha;
            passou = false;
        } else if (!isPasswordValid(password)) {
            tSenha.setError(getString(R.string.senha_invalida));
            focusView = tSenha;
            passou = false;
        } else if (!TextUtils.isEmpty(password) && isPasswordValid(password)) {
            passou = true;
        }

        return passou;
    }

    private boolean isCpfValid(String cpf) {
        return cpf.length() == 11;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 6;
    }


    private void taskDados() throws Exception {
        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Por favor, aguarde...");
        progressDialog.setMessage("Verificando informaçoes na base de dados...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        //busca os carros: dispara a task
        new GetDadosTask(this).execute();
    }

    private boolean isloginValid(Cliente cliente) {
        boolean ehValido = true;

        if (cliente != null) {
            if (cliente.getId().equals("") || cliente.getId() == null) {
                ehValido = false;
            }
        } else if (cliente == null) {
            ehValido = false;
        }
        return ehValido;
    }

    private class GetDadosTask extends AsyncTask<Void, Integer, Integer> {
        final static int STATE_DONE = 0;
        final static int STATE_RUNNING = 1;
        int mState;
        int total;
        private Context context;

        public GetDadosTask(Context context) {
            this.context = context;
        }

        //No onPreExecute, atualizamos o ProgressDialog
        @Override
        protected void onPreExecute() {
            progressDialog.setProgress(0);
        }

        /*
        * No doInBackground, é onde fazemos todo o serviço. E como estamos em outra Thread,
        * nos comunicamos com o ProgressDialog via o método publishProgress(total) enviando
        * o contador para o método onProgressUpdate.
        * */
        @Override
        protected Integer doInBackground(Void... params) {
            mState = STATE_RUNNING;
            total = 0;
            while (mState == STATE_RUNNING) {
                total++;
                publishProgress(total);

                if (total >= 3) {
                    mState = STATE_DONE;
                }
                try {
                    Thread.sleep(3000);
                    c = LoginService.getDados(cpf, senha);
                } catch (InterruptedException e) {
                    Log.e(TAG, e.getMessage());
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
            return total;
        }

        //No onProgressUpdate, atualizamos o ProgressDialog.
        @Override
        protected void onProgressUpdate(Integer... progress) {
            progressDialog.setProgress(progress[0]);
        }

        //No onPostExecute, fechamos o ProgressDialog e enviamos uma breve mensagem via toast e finalizamos a AsyncTask
        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (isloginValid(c)) {
                // Dados a serem passados para a menu activity
                Intent intent = new Intent(context, MenuActivity.class);
                intent.putExtra("cliente", c);
                intent.putExtra("apolices", c.getApolices());
                startActivity(intent);
                finish();
            } else {
                alert("CPF e/ou senha incorreta. Por favor, verifique a digitação");
            }
        }
    }
}