package model;

import model.enumerations.GroupNames;
import tools.Election;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Univer {
    private static List<Student> students;
    private static List<Group> groups;
    private static List<Professor> professors;
    private static Score scores;
    private static Election election;
    private static List<Integer> teamleaders;
    private static boolean founded = false;
    private static String timeStamp;
    private static String name;
    private static int StudNumber;
    private static String country;
    private static Properties properties;

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(Univer.class.getResourceAsStream("../resources/application.properties"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Univer() {
        loadProperties();
        this.students = new ArrayList<Student>();
        this.groups = new ArrayList<Group>();
        this.professors = new ArrayList<Professor>();
        this.teamleaders = new ArrayList<>();
        this.founded = true;
        this.name = properties.getProperty("univercity.name");
        this.StudNumber = Integer.parseInt(properties.getProperty("students.number"));
        setCountry();
        setTimeStamp();
        election = new Election(StudNumber);
    }

    private void setCountry() {
        Locale locale = Locale.getDefault();
        this.country = locale.getDisplayCountry();
    }

    private void setTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        timeStamp = dateFormat.format(cal.getTime());
    }

    public void setScores(Score scores) {
        this.scores = scores;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public int[] getScores(int studentId) {
        int[] result = new int[4];
        for (int i = 0; i < scores.score.length; i++) {
            result[i] = scores.score[i][studentId];
        }
        return result;
    }

    public void addStudent(Student student) {
        students.add(student);
        int groupId = GroupNames.valueOf(student.group).ordinal();
        Group group = getGroup(groupId);
        group.addStudent(student);
    }

    public static Student getStudent(int index) {
        return students.get(index);
    }

    public void addProfessor(Professor prof) {
        professors.add(prof);
    }

    public Professor getProfessor(int index) {
        return professors.get(index);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public static Group getGroup(int index) {
        return groups.get(index);
    }


//    public void Vote(int studId, int candidate, int rate) {
//        election.setResult(studId, candidate, rate);
//    }

    public static int getStudNumber() {
        return StudNumber;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<Group> getGroups() {
        return groups;
    }

    public static List<Professor> getProfessors() {
        return professors;
    }

    public static Score getScores() {
        return scores;
    }

    public static Election getElection() {
        return election;
    }

    public static List<Integer> getTeamleaders() {
        return teamleaders;
    }

    public static boolean isFounded() {
        return founded;
    }

    public static String getTimeStamp() {
        return timeStamp;
    }

    public static String getName() {
        return name;
    }

    public static String getCountry() {
        return country;
    }

    public static void setTeamleaders(List<Integer> teamleaders) {
        Univer.teamleaders = teamleaders;
    }
}
