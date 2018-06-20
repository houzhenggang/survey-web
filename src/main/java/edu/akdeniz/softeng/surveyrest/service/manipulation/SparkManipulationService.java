package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.repository.CountsRepo;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maemresen
 * <p>
 * Manipulation Service to manipulate surveys.
 * creating, editing, deleting etc.
 */
@Controller
@RequestMapping("/service/manipulation")
public class SparkManipulationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparkManipulationService.class.getName());

    @Autowired
    private CountsRepo countsRepo;

    public void deleteAll() {
        countsRepo.deleteAll();
        LOGGER.info(String.format("All counts deleted by [%s]", SecurityHelper.getUserName()));
    }


}
