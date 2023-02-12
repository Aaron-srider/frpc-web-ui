package fit.wenchao.frpcwebui.model;

import java.util.Objects;

public class ConfigItemPO {
    Integer id;
    String name;


    public ConfigItemPO() {
    }

    public ConfigItemPO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConfigItemPO id(Integer id) {
        setId(id);
        return this;
    }

    public ConfigItemPO name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConfigItemPO)) {
            return false;
        }
        ConfigItemPO configItemPO = (ConfigItemPO) o;
        return Objects.equals(id, configItemPO.id) && Objects.equals(name, configItemPO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

}
