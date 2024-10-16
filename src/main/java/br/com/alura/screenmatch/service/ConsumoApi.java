package br.com.alura.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi { //Classe para consumir a API
    public String obterDados(String endereco) { // Obter dados precisa receber um endereco web, que vem por meio de uma String
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder() // O cliente faz o request
                .uri(URI.create(endereco)) // cria-se o endereco web
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body(); // Dados a serem retornados e intanciado na classe principal
        return json;
    }

}
