package edu.auburn.app.diabetestoolkit.model;

/**
 * Created by liguorui on 3/2/16.
 */
public class ReadModel extends BaseModel{
    private String name;
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
