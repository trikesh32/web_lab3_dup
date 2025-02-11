package trikesh.lab3_dup;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import trikesh.lab3.db.ResultDAO;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@Named("resultsList")
@SessionScoped
public class ResultsList implements Serializable {
    ArrayList<Result> results = new ArrayList<>();
    private final ResultDAO resultDAO = new ResultDAO();

    public ResultsList() {
    }

    @Transactional
    public void addResult(Result result) {
        results.add(result);
        resultDAO.save(result);

    }
}
