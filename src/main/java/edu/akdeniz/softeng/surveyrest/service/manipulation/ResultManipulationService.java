package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultManipulationService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultManipulationService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void deleteAll(){
        resultRepo.deleteAll();
    }
}
