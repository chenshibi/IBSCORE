package com.huateng.ebank.business.common;

import java.util.ArrayList;
import java.util.List;

import resource.bean.basic.FunctionInfo;

public class MenuFunction {
    private int menuLevel;
    private FunctionInfo function;

    private List<MenuFunction> subMenuList = new ArrayList<MenuFunction>();

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public FunctionInfo getFunction() {
        return function;
    }

    public void setFunction(FunctionInfo function) {
        this.function = function;
    }

    public List<MenuFunction> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuFunction> subMenuList) {
        this.subMenuList = subMenuList;
    }

}
