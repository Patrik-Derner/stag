package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;

import java.util.stream.Collectors;

public class Main5 {

    public static void main(String[] args) {
        System.out.println(roomsSummary("KIKM",2024));
    }

    public static String roomsSummary(String department, int year)
    {
        String json = Api.getActionsByDepartment(department,year);
        ActionsList actions= new Gson().fromJson(json, ActionsList.class);
        String res = actions.items.stream()
                .map(i->i.room)
                .filter(s->s!=null)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
        return res;
    }
}