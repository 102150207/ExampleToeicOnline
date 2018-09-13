package vn.myclass.core.web.command;

/**
 * Created by Admin on 6/7/2018.
 */
public class AbstractCommand<T> {
    protected T pojo;
    private String crudaction;

    public T getPojo() {
        return pojo;
    }

    public void setPojo(T pojo) {
        this.pojo = pojo;
    }

    public String getCrudaction() {
        return crudaction;
    }

    public void setCrudaction(String crudaction) {
        this.crudaction = crudaction;
    }
}
