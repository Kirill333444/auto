package ru.sapteh.model;

import java.util.Objects;

//POJO

public class model {

    private int id;
    private String mark;
    private String body_type;
    private String type_gasoline;

    public model(String mark, int id, String body_type) {

    }

    public  model (int id,String mark , String body_type , String type_gasoline) {
        this.id = id;
        this.mark = mark;
        this.body_type = body_type;
        this.type_gasoline= type_gasoline;
    }



    public int getId() {
        return id;
    }

    public String getMark() {
        return (String) mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getType_gasoline() {
        return (String) type_gasoline;
    }

    public void setType_gasoline(String type_gasoline) {
        this.type_gasoline = type_gasoline;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        model model = (model) o;
        return id == model.id && Objects.equals(mark, model.mark) && Objects.equals(body_type, model.body_type) && Objects.equals(type_gasoline,model.type_gasoline)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, body_type);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mark='" +mark + '\'' +
                ", body_type='" + body_type + '\'' +
                ", type_gasoline='" + type_gasoline + '\'' +
                '}';
    }
}