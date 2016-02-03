package edu.auburn.app.diabetestoolkit.activity.base;

/**
 * Created by liguorui on 2/1/16.
 */
public interface ParentInterface {
    void addFragment(BaseFragment frag, String... tags);
    void removeFragment(BaseFragment frag, String... tags);
    void addSubFragment(BaseFragment frag, String... tags);
    void removeSubFragment(BaseFragment frag, String... tags);
}
