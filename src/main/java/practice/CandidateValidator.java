package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) {
            return false;
        }
        if (!candidate.isAllowedToVote()) {
            return false;
        }
        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(years[0]);
        int to = Integer.parseInt(years[1]);
        return (to - from) >= 10;
    }
}
