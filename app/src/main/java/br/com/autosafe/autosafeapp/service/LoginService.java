package br.com.autosafe.autosafeapp.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.autosafe.autosafeapp.domain.Apolice;
import br.com.autosafe.autosafeapp.domain.Cliente;
import br.com.autosafe.autosafeapp.domain.Login;
import br.com.autosafe.autosafeapp.domain.Veiculo;
import livroandroid.lib.utils.HttpHelper;

/**
 * Created by François on 3/18/2016.
 */
public class LoginService {

    public static Cliente getDados(String cpf, String senha) throws IOException {

        String montaUrl = "http://autosafe.azurewebsites.net/api/LoginService?cpf=" + cpf + "&senha=" + senha;

        //faz a requisicao http no servidor e retorna a string com o conteudo.
        HttpHelper http = new HttpHelper();
        String url = http.doGet(montaUrl);


        Cliente c = parserJSON(url);
        return c;
    }

    //faz o parser do json
    private static Cliente parserJSON(String json) throws IOException {

        ArrayList<Apolice> apolices = new ArrayList<Apolice>();
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente = null;
        Veiculo veiculo = null;
        Apolice apolice = null;
        Login login = null;

        try {
            JSONObject root = new JSONObject(json);
            //  JSONObject obj = root.getJSONObject("listaveiculos");
            JSONArray jsonVeiculos = root.getJSONArray("listaveiculos");
            JSONArray jsonApolices = root.getJSONArray("apolicemodel");
            JSONArray jsonDependentes = root.getJSONArray("dependentemodel");
            JSONArray jsonClientes = root.getJSONArray("clientemodel");
            //JSONArray jsonClientesDependentes = root.getJSONArray("clientedep");

            // percorre o array de cliente
            for (int i = 0; i < jsonClientes.length(); i++) {
                cliente = new Cliente();
                login = new Login();
                JSONObject jsonCliente = jsonClientes.getJSONObject(i);
                // Lê as informações do cliente e login
                login.setCpf(jsonCliente.optString("Cpf"));
                cliente.setId(jsonCliente.optString("ClienteId"));
                cliente.setNome(jsonCliente.optString("Nome"));
                cliente.setDataNasc(jsonCliente.optString("DataNasc"));
                cliente.setNomeMae(jsonCliente.optString("NomeMae"));
                cliente.setRg(jsonCliente.optString("Rg"));
                cliente.setEmail(jsonCliente.optString("Email"));
                cliente.setTelefone(jsonCliente.optString("Telefone"));
                cliente.setCelular(jsonCliente.optString("Celular"));
                cliente.setEndereco(jsonCliente.optString("Endereco"));
                cliente.setBairro(jsonCliente.optString("Bairro"));
                cliente.setEstado(jsonCliente.optString("Estado"));
                cliente.setCidade(jsonCliente.optString("Cidade"));
                cliente.setCep(jsonCliente.optString("Cep"));
                cliente.setNumHabilatacao(jsonCliente.optString("NumHabilatacao"));
                cliente.setCategoriaHab(jsonCliente.optString("Categoria"));
                cliente.setDataEmissaoHab(jsonCliente.optString("DataEmissao"));
                cliente.setDataValidadeHab(jsonCliente.optString("DataValidade"));
                cliente.setLocalEmissaoHab(jsonCliente.optString("LocalEmissao"));
                cliente.setEhDependente(false);
                //relaciona o login ao cliente
                login.setCliente(cliente);
                cliente.setLogin(login);
                clientes.add(cliente);
            }

            // percorre o array de veiculos(pode ser varios, cada um de uma apolice)
            for (int i = 0; i < jsonVeiculos.length(); i++) {
                JSONObject jsonVeiculo = jsonVeiculos.getJSONObject(i);
                veiculo = new Veiculo();

                // Lê as informações de cada veiculo
                veiculo.setId(jsonVeiculo.optString("VeiculoId"));
                veiculo.setModelo(jsonVeiculo.optString("Modelo"));
                veiculo.setCor(jsonVeiculo.optString("Cor"));
                veiculo.setChassi(jsonVeiculo.optString("Chassi"));
                veiculo.setFabricante(jsonVeiculo.optString("Fabricante"));
                veiculo.setPossuiRastreador(jsonVeiculo.optString("PossuiRastreador"));
                veiculo.setAno(jsonVeiculo.optString("Ano"));
                veiculo.setPlaca(jsonVeiculo.optString("Placa"));
                veiculo.setRenavam(jsonVeiculo.optString("Renavan"));
                //add o veiculo a lista de veiculos
                veiculos.add(veiculo);
            }

            // percorre o array de apolices
            for (int i = 0; i < jsonApolices.length(); i++) {
                JSONObject jsonApolice = jsonApolices.getJSONObject(i);
                apolice = new Apolice();

                // Lê as informações de cada apolice
                apolice.setId(jsonApolice.optString("ApoliceId"));
                apolice.setDataValidade(jsonApolice.optString("DataValidade"));
                apolice.setLocaldaPernoite(jsonApolice.optString("LocalDaPernoite"));
                apolice.setDescricaoUsoVeiculo(jsonApolice.optString("DescricaoUsoVeiculo"));
                //relaciona cada apolice ao um veiculo
                apolice.setVeiculo(veiculo);
                //add a apolice a lista de apolices
                apolices.add(apolice);
                //relaciona o cliente a lista de apolices
                cliente.setApolices(apolices);
                apolice.setClientes(clientes);
            }

           /*
            // percorre o array de dependentes
            for (int i = 0; i < jsonDependentes.length(); i++) {
                cliente = new Cliente();
                JSONObject jsonDependente = jsonDependentes.getJSONObject(i);
                // Lê as informações do dependente
                login.setCpf(jsonDependente.optString("clientepf"));
                cliente.setId(jsonDependente.optString("ClienteId"));
                cliente.setNome(jsonDependente.optString("Nome"));
                cliente.setDataNasc(jsonDependente.optString("DataNasc"));
                cliente.setNomeMae(jsonDependente.optString("NomeMae"));
                cliente.setRg(jsonDependente.optString("Rg"));
                cliente.setEmail(jsonDependente.optString("Email"));
                cliente.setTelefone(jsonDependente.optString("Telefone"));
                cliente.setCelular(jsonDependente.optString("Celular"));
                cliente.setEndereco(jsonDependente.optString("Endereco"));
                cliente.setBairro(jsonDependente.optString("Bairro"));
                cliente.setEstado(jsonDependente.optString("Estado"));
                cliente.setCidade(jsonDependente.optString("Cidade"));
                cliente.setCep(jsonDependente.optString("Cep"));
                cliente.setNumHabilatacao(jsonDependente.optString("NumHabilatacao"));
                cliente.setCategoriaHab(jsonDependente.optString("Categoria"));
                cliente.setDataEmissaoHab(jsonDependente.optString("DataEmissao"));
                cliente.setDataValidadeHab(jsonDependente.optString("DataValidade"));
                cliente.setLocalEmissaoHab(jsonDependente.optString("LocalEmissao"));
                cliente.setEhDependente(true);
            }
            */

        } catch (JSONException e) {
            throw new IOException(e.getMessage(), e);
        }
        return cliente;
    }

}