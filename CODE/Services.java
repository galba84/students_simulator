package CODE;

import model.*;
import tools.Election;
import tools.ShowUnivStructure;

import java.util.List;

public class Services {
    private static Univer univer = null;

    public boolean isUnivFound() {
        if (univer == null) return false;
        else return true;
    }

    public void setUniver() {
        univer = new Univer();
        setScore();
        setGroups();
        setStudents();
        setProfs();
        System.out.println(Univer.getName()+" UNIVERSITY was found in " + univer.getCountry()+"!"+ System.lineSeparator());
    }

    public void printUnivStructure() {
        ShowUnivStructure showUnivStructure = new ShowUnivStructure();
        List<Integer> teamleaders = Univer.getTeamleaders();
        StringBuilder sb = new StringBuilder();
        sb.append(" University " + univer.getName() + " was founded " + univer.getTimeStamp() + " in " + univer.getCountry()+ System.lineSeparator() + System.lineSeparator());
        sb.append(" A " + Univer.getStudNumber() + " students study here." + System.lineSeparator());
        sb.append(showUnivStructure.printProfessors(Univer.getProfessors()));
        sb.append(showUnivStructure.printGroups(Univer.getGroups()));
        sb.append(showUnivStructure.printStudInfo(Univer.getStudents()));
        sb.append(showUnivStructure.printTeamLeaders(teamleaders));
        System.out.println(sb.toString());
    }

    public void studentsRollCall() {
        List <Professor> professors = Univer.getProfessors();
        StringBuilder sb = new StringBuilder();
        for (Professor professor:professors
             ) {
            sb.append(professor.rollCallStudents(professor.getGroupId()));
        }
        System.out.println(sb);

    }

    public void orginizeElection() {
        for (Student student : Univer.getStudents()
                ) {
            for (Student candid : Univer.getStudents()
                    ) {
                student.vote(candid);
            }
        }
        System.out.println(Election.count());

    }

    private void setScore() {
        Score score = new Score(Univer.getStudNumber());
        univer.setScores(score);
    }

    private void setGroups() {
        Group group;
        for (int i = 0; i < 4; i++) {
            group = new Group(i);
            univer.addGroup(group);
        }
    }

    private void setStudents() {
        Student student;
        for (int i = 0; i < Univer.getStudNumber(); i++) {
            student = new Student(i, (univer.getScores(i)));
            univer.addStudent(student);
        }
    }

    private void setProfs() {
        Professor proff;
        for (int i = 0; i < 4; i++) {
            proff = new Professor(i);
            univer.addProfessor(proff);
        }
    }

}
