package fit.wenchao.frpcwebui.model;

import java.util.Objects;

public class ConfigEntryPO {
    String key;
    String value;


    public ConfigEntryPO() {
    }

    public ConfigEntryPO(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ConfigEntryPO key(String key) {
        setKey(key);
        return this;
    }

    public ConfigEntryPO value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConfigEntryPO)) {
            return false;
        }
        ConfigEntryPO configEntryPO = (ConfigEntryPO) o;
        return Objects.equals(key, configEntryPO.key) && Objects.equals(value, configEntryPO.value);
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
