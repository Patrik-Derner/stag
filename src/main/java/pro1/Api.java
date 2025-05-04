package pro1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    private static HttpClient client = HttpClient.newBuilder().build();
    private static String baseUrl = "https://stag-demo.uhk.cz/ws/services/rest2";
    public static String getTeachersByDepartment(String department)
    {
        return getFromUri(baseUrl+"/ucitel/getUciteleKatedry?outputFormat=JSON&katedra="+department);
    }

    public static String getActionsByDepartment(String department, int year)
    {
        return getFromUri(baseUrl+"/rozvrhy/getRozvrhByKatedra?semestr=%25&outputFormat=JSON&katedra="+department+"&rok="+year);
    }

    private static String getFromUri(String uri)
    {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

    public static String getSpecializations(int year)
    {
        return getFromUri(baseUrl+"/prijimacky/getPrijimaciObory?outputFormat=JSON&rok="+year+"&jenAktualni=false");
    }
}

