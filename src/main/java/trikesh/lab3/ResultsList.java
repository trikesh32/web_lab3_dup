package trikesh.lab3;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;
import trikesh.lab3.utils.DBCommunicator;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@Named("resultsList")
@SessionScoped
public class ResultsList implements Serializable {
    ArrayList<Result> results = new ArrayList<>();

    private DBCommunicator dbCommunicator = DBCommunicator.getInstance();

    public ResultsList() {
    }

    @Transactional
    public void addResult(Result result) {
        results.add(result);
        dbCommunicator.sendOne(result);
    }
    public String getResultsJson(){
        String json =  new GsonBuilder().create().toJson(results);
        return json;
    }
}
