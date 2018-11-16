package br.unip.greenhouse.view;

import br.unip.greenhouse.model.Actions;
import br.unip.greenhouse.model.Info;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class GreenhouseAPI {
    
    private final String URL= "http://localhost:8080/greenhousews-repo/webresources/greenhouse/";
    
    public String get(final String OPERACAO) {
        try {
            System.out.println("GET: creating HttpClient...");
            HttpClient cli = HttpClientBuilder.create().build();

            System.out.println("GET: creating HttpGet");
            HttpGet requisicao = new HttpGet(URL + OPERACAO);
            requisicao.addHeader("Accept", "application/json");
            
            System.out.println("GET: executing HttpResponse");
            HttpResponse resposta = cli.execute(requisicao);
            
            //System.out.println("GET: response: " + EntityUtils.toString(resposta.getEntity()));
            System.out.println("GET: returning response");
            return EntityUtils.toString(resposta.getEntity());

        } catch (Exception e) {
            System.out.println("ERRO ghAPI: get : " + e.getMessage());
            return null;
        }
    }
    
    public String post(final String OPERACAO, Actions actions){
        try {
            HttpClient cli = HttpClientBuilder.create().build();

            HttpPost requisicao = new HttpPost(URL + OPERACAO);
            requisicao.addHeader("Content-Type", "application/json");
            
            StringEntity se = new StringEntity(new Gson().toJson(actions),"UTF-8");
            requisicao.setEntity((HttpEntity) se);

            HttpResponse resposta = cli.execute(requisicao);
            return EntityUtils.toString(resposta.getEntity());
            
        } catch (Exception e) {
             System.out.println("ERRO ghAPI: post : " + e.getMessage());
            return null;
        }
    }
    
    public Info getInfo(){
        System.out.println("GreenhouseAPI : getInfo");
        Info info = new Gson().fromJson(
                    get("get/info"),
                    new TypeToken<Info>() {
                    }.getType()
            );
        return info;
    }
    public Actions getActions(){
        System.out.println("GreenhouseAPI : getActions");
        Actions actions = new Gson().fromJson(
                    get("get/actions"),
                    new TypeToken<Actions>() {
                    }.getType()
            );
        return actions;
    }
    public List<Info> listInfo(){
        System.out.println("GreenhouseAPI : listInfo");
        List<Info> info = new Gson().fromJson(
                    get("list/info"),
                    new TypeToken<ArrayList<Info>>() {
                    }.getType()
            );
        return info;
    }
    public List<Info> listInfo(String dates){
        System.out.println("GreenhouseAPI : listInfo");
        List<Info> info = new Gson().fromJson(
                    get("list/info/"+dates),
                    new TypeToken<ArrayList<Info>>() {
                    }.getType()
            );
        return info;
    }
    public String setActions(Actions actions){
        System.out.println("GreenhouseAPI : setActions");
        return post("set/actions", actions);        
    }
    
    /*
    public static void main(String[] args) {
        Actions a = new Actions(false, false, true);
        System.out.println("POST RESULT: " + new GreenhouseAPI().setActions(a));
        //Actions b = new GreenhouseAPI().getActions();
        //System.out.println("GET RESULT: " + b.light + " " + b.water + " " + b.exaust);
        List<Info> infolist = new GreenhouseAPI().listInfo();
        for(Info info : infolist){
            System.out.println(info.toString());
        }
    }*/
}
