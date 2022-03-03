package util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValueClass {
    private String name;
    private String msg;

    public ValueClass(){}
    public ValueClass(String name, String msg){
        setName(name);
        setMsg(msg);
    }

    @Override public String toString(){
        return "NAME: " + getName() + " MESSAGE: " + getMsg();
    }
}
