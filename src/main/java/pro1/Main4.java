package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.TeachersList;

import java.util.Comparator;

public class Main4 {

    public static void main(String[] args) {
         printShortestEmails("KIKM",5);
    }

    public static void printShortestEmails(String department, int count)
    {
        String json = Api.getTeachersByDepartment(department);
        TeachersList teachers = new Gson().fromJson(json,TeachersList.class);

        teachers.items.stream()
                .filter(t -> t.email != null)
                .sorted(Comparator.comparing(t->t.email.length()))
                .limit(count)
                .forEach(t -> System.out.println(t.email));
    }
}