package tools;

import model.Student;
import model.Univer;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class Election {
    public static Integer[][] result;
    public static Integer[] total;
    static int studNum;

    public Election(int studNum) {
        result = new Integer[studNum][studNum];
        total = new Integer[studNum];
        fillArray2d();
        Arrays.fill(total,0);
        this.studNum = studNum;
    }

    public static void commitVote(Student elector, Student candidate) {
        int candidRating;
        if (elector.isPresent()) {
            candidRating = giveOpinion(elector, candidate);
            setResult(elector.getId(), candidate.getId(), candidRating);
        }

    }

    public static String count() {
        calculateResults();
        List<Integer> winnersIds = WinnersIds();
        List<Student> winnersList = getWinnersFromIds(winnersIds);
        Univer.setTeamleaders(winnersIds);
        return printResult(winnersList);
    }

    private static int giveOpinion(Student elector, Student candidate) {
        int rating = 0;
        if (candidate.isPresent())
            ++rating;
        if (elector.group.equalsIgnoreCase(candidate.group))
            ++rating;
        if (candidate.age > elector.age)
            ++rating;
        if (candidate.scoreAverage > elector.scoreAverage)
            ++rating;
        if ((candidate.scoreMainGroup > elector.scoreMainGroup) & (elector.group.equalsIgnoreCase(candidate.group)))
            ++rating;
        return rating;
    }

    private static void setResult(int elector, int candid, int val) {
        result[elector][candid] = val;
    }

    private static void calculateResults() {
        for (int id = 0; id < studNum; id++) {
            total[id] = getScoreOfCandid(id);
        }
    }

    private static int getScoreOfCandid(int studentId) {
        int total = 0;
        for (int i = 0; i < studNum; i++) {
            total = total+result[i][studentId];
        }
        return total;
    }

    private static List<Integer> WinnersIds() {

        Integer[] arrayForSortResult = total.clone();
        Arrays.sort(arrayForSortResult, Collections.reverseOrder());
        int winnerResult = getWinnerResult();
        List<Integer> winnersIds = getWinnersIdList(winnerResult);
        return winnersIds;
    }

    private static Integer getWinnerResult() {
        Integer[] arrayForSortResult = total.clone();
        Arrays.sort(arrayForSortResult, Collections.reverseOrder());
        return arrayForSortResult[0];
    }

    private static List<Integer> getWinnersIdList(int winnerResult) {
        List<Integer> winners = new ArrayList<Integer>();
        int indexOfWinner=-1;
        for (int i = 0; i < total.length; i++) {
            indexOfWinner = ArrayUtils.indexOf(total, winnerResult,indexOfWinner+1);
            if (indexOfWinner==-1)
                break;
            winners.add(indexOfWinner);
        }
        return winners;
    }

    private static List<Student> getWinnersFromIds(List<Integer> winnersIds) {
        List<Student> winList = new LinkedList<>();
        for (Integer id : winnersIds
                ) {
            Student student = Univer.getStudent(id);
            winList.add(student);
        }
        return winList;
    }

    private static String printResult(List<Student> winnersList) {
        StringBuilder sb=new StringBuilder();
        sb.append(winnersList.size()+ " student(s) won elections !!!"+System.lineSeparator());
        for (Student student:winnersList
             ) {
            sb.append(student.getName() + " with total score "+total[student.getId()]+" from group "+student.group+System.lineSeparator());
        }
        return sb.toString();
    }

    private static void fillArray2d(){
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 0);
        }
    }
}
