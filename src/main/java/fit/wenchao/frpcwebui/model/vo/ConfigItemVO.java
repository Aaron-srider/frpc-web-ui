package fit.wenchao.frpcwebui.model.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fit.wenchao.frpcwebui.model.ConfigEntryPO;
import fit.wenchao.frpcwebui.utils.Pair;

public class ConfigItemVO {
    String name;
    List<ConfigEntryPO> values;

    public ConfigItemVO() {
    }

    public ConfigItemVO(String name, List<ConfigEntryPO> values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConfigEntryPO> getValues() {
        return this.values;
    }

    public void setValues(List<ConfigEntryPO> values) {
        this.values = values;
    }

    public ConfigItemVO name(String name) {
        setName(name);
        return this;
    }

    public ConfigItemVO values(List<ConfigEntryPO> values) {
        setValues(values);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConfigItemVO)) {
            return false;
        }
        ConfigItemVO configItemsVO = (ConfigItemVO) o;
        return Objects.equals(name, configItemsVO.name) && Objects.equals(values, configItemsVO.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, values);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", values='" + getValues() + "'" +
                "}";
    }

    public static ConfigItemVO getInstance(String name, Pair... values) {
        ConfigItemVO result = new ConfigItemVO();
        List<ConfigEntryPO> configEntrys = new ArrayList<ConfigEntryPO>();
        result.setName(name);
        for (Pair value : values) {
            configEntrys.add(new ConfigEntryPO(value.getKey(), (String) value.getValue()));
        }
        result.setValues(configEntrys);
        return result;
    }

}
