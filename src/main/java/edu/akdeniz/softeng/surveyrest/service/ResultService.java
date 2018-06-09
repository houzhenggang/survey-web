package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maemresen
 * <p>
 * Service to results.
 */
@Service
public class ResultService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public List<Result> getResultList() {
        return new NotNullList<>(resultRepo.findAll());
    }

}
