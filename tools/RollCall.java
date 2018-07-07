package tools;

import model.Group;
import model.Professor;
import model.Student;
import model.Univer;

public class RollCall {

    public static String performRollCall(Professor professor, int groupIndex) {
        Group group = Univer.getGroup(groupIndex);
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator() + "This is Group " + group.getName() + System.lineSeparator());
        builder.append("I am Professor " + professor.getName() + " and I shall conduct a rollcall today " + System.lineSeparator());
        for (Student student : group.getStudents()
                ) {
            builder.append("Student " + student.getName() + ifPresent(student) + System.lineSeparator());
        }
        return builder.toString();
    }

    private static String ifPresent(Student student) {
        if (student.isPresent())
            return " present ";
        else return " ABSENT ";
    }
}
