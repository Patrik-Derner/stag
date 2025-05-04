package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action
{
    @SerializedName("obsazeni")
    public int personsCount;
    @SerializedName("nazev")
    public String title;
    @SerializedName("katedra")
    public String department;
    @SerializedName("ucitIdno")
    public long teacherId;
    public String room;
}
