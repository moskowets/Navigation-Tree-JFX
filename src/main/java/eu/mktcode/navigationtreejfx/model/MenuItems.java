package eu.mktcode.navigationtreejfx.model;

import java.util.Objects;

public class MenuItems {

    private String dataInputMenu;
    private String resultMenu;

    public MenuItems(String dataInputMenu, String resultMenu) {
        this.dataInputMenu = dataInputMenu;
        this.resultMenu = resultMenu;
    }

    public String getDataInputMenu() {
        return dataInputMenu;
    }

    public String getResultMenu() {
        return resultMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItems menuItem = (MenuItems) o;
        return Objects.equals(dataInputMenu, menuItem.dataInputMenu) && Objects.equals(resultMenu, menuItem.resultMenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataInputMenu, resultMenu);
    }
}
