package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public List<Result> getResultList() {
        return new NotNullList<Result>(resultRepo.findAll());
    }

    public Result save(Result result) {
        resultRepo.save(result);
        return result;
    }

    public void save(List<Result> results) {
        results.forEach(this::save);
    }
}
