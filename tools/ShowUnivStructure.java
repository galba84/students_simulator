package tools;

import model.Group;
import model.Professor;
import model.Student;
import model.Univer;

import java.util.List;

public class ShowUnivStructure {

    public String printProfessors(List<Professor> professorList) {
        StringBuilder sb = new StringBuilder();
        sb.append("Famous professors working here, namely: " + System.lineSeparator());
        for (Professor prof : professorList
                ) {
            sb.append("Mr. " + prof.getName() + System.lineSeparator());
        }
        return sb.toString();
    }

    public String printGroups(List<Group> groupList) {
        StringBuilder sb = new StringBuilder();
        sb.append(" There are " + groupList.size() + " groups :" + System.lineSeparator());
        for (Group group : groupList
                ) {
            sb.append(group.getName() + " with " + group.getStudents().size() + " students." + System.lineSeparator());
        }
        return sb.toString();
    }

    public String printStudInfo(List<Student> studentList) {
        StringBuilder sb = new StringBuilder();
        sb.append(" Total number of students is :" + studentList.size() + System.lineSeparator());
        sb.append(printScoreLeader(studentList));
        return sb.toString();
    }

    public String printTeamLeaders(List<Integer> leadersList) {
        if (leadersList.size() == 0)
            return ("There are no teamleader elected. Please Elect one \n");
        StringBuilder sb = new StringBuilder();
        for (Integer leaderIndex : leadersList
                ) {
            Student student = Univer.getStudent(leaderIndex);
            sb.append("Teamleader is " + student.getName() + " " + student.sex + " group " + student.group + " age "
                    + student.age + " avarage score " + student.scoreAverage + " of scale 1-12 " + System.lineSeparator());
        }
        return sb.toString();
    }

    private String printScoreLeader(List<Student> studentList) {
        StringBuilder sb = new StringBuilder();
        int avrScoreMax = 0;
        int avrScoreLeaderId = 0;
        int avrageScoreSum = 0;
        int avarageScore = 0;
        for (Student st : studentList
                ) {
            if (st.scoreAverage > avrScoreMax) {
                avrScoreMax = st.scoreAverage;
                avrScoreLeaderId = st.getId();
            }
            avrageScoreSum += st.scoreAverage;
        }
        avarageScore = avrageScoreSum / studentList.size();
        Student st = Univer.getStudent(avrScoreLeaderId);
        sb.append("avarage score of students is " + avarageScore + " of scale 1-12" + System.lineSeparator());
        sb.append("The highest avarage score of " + avrScoreMax + " has student " + st.getName() + " age " + st.age + " group " + st.group + System.lineSeparator());
        return sb.toString();
    }
}
