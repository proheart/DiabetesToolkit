package edu.auburn.app.diabetestoolkit.model;

/**
 * Created by liguorui on 3/5/16.
 */
public class StateModel extends BaseModel{
    private int id;
    private String time;
    private String blood;
    private String note;

    public StateModel(String time, String blood, String note) {
        this.time = time;
        this.blood = blood;
        this.note = note;
    }

    public StateModel(int id, String time, String blood, String note) {
        this.id = id;
        this.time = time;
        this.blood = blood;
        this.note = note;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
