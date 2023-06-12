package engine;

import org.springframework.stereotype.Service;

@Service
public class WeightServiceImpl implements WeightService {
    private static final int MAX_ITERATIONS = 10;
    private static final int MAX_COMMENTS = 20;
    private static final double COMPLEXITY_WEIGHT = 15;
    private static final double SPENT_TIME_WEIGHT = 10;
    private static final double ADDED_LINES_WEIGHT = 0.2;
    private static final double CHANGED_LINES_WEIGHT = 0.2;
    private static final double DELETED_LINES_WEIGHT = 0.1;
    private static final double COMMENTS_SCORE_WEIGHT = 2;
    private static final double ITERATIONS_SCORE_WEIGHT = 5;
    private static final double SHAREHOLDER_WEIGHT = 20;
    @Override
    public WeightResponse calculateWeight(WeightRequest weightRequest) {
        Double spentTimeWeight = calculateSpentTimeWeight(weightRequest.getEstimatedTime(), weightRequest.getLoggedTime());
        Double commentsScore = calculateCommentsScore(weightRequest.getNumberOfComments());
        Double iterationsScore = calculateIterationsScore(weightRequest.getNumberOfIterations());
        Double experience = calculateExperience(weightRequest.getTaskComplexity(), spentTimeWeight,commentsScore,iterationsScore,(double) weightRequest.getChangedLines(),
                (double) weightRequest.getAddedLines(), (double) weightRequest.getRemovedLines(), weightRequest.getShareholderFeedback());

        WeightResponse response = new WeightResponse();
        response.setExperience(experience);
        return response;
    }

    private Double calculateExperience(Double taskComplexity, Double spentTimeWeight, Double commentsScore, Double iterationsScore,
                                       double changedLines, double addedLines, double removedLines, Double shareholderFeedback) {
        double sum = COMPLEXITY_WEIGHT * taskComplexity + spentTimeWeight * SPENT_TIME_WEIGHT + COMMENTS_SCORE_WEIGHT * commentsScore
                + ITERATIONS_SCORE_WEIGHT * iterationsScore + ADDED_LINES_WEIGHT * addedLines
                + CHANGED_LINES_WEIGHT * changedLines + DELETED_LINES_WEIGHT * removedLines
                + SHAREHOLDER_WEIGHT * shareholderFeedback;
        return sum / 8;
    }

    private Double calculateIterationsScore(Integer numberOfIterations) {
        int iterationsScore = MAX_ITERATIONS - numberOfIterations;
        if(iterationsScore > 0) {
            return (double) (iterationsScore);
        }
        return 1D;
    }

    private Double calculateCommentsScore(Integer numberOfComments) {
        int commentsScore = MAX_COMMENTS - numberOfComments;
        if(commentsScore > 0) {
            return (double) (commentsScore);
        }
        return 1D;
    }

    private Double calculateSpentTimeWeight(Integer estimatedTime, Integer loggedTime) {
        if(estimatedTime > 0 && loggedTime > 0) {
            return Double.valueOf(estimatedTime) / Double.valueOf(loggedTime);
        }
        return 1d;
    }


}
