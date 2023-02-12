package fit.wenchao.frpcwebui.utils;

import java.util.Objects;

public class Pair {

    String key;
    Object value;

    public Pair() {
    }

    public Pair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Pair key(String key) {
        setKey(key);
        return this;
    }

    public Pair value(Object value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "{" +
                " key='" + getKey() + "'" +
                ", value='" + getValue() + "'" +
                "}";
    }

}