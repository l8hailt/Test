package com.example.test.rv_in_rv;

import java.util.List;

/**
 * @author ITSOL JAPAN
 * Created on 02/01/2021.
 * Copyright © 2020 YSL Solution Co., Ltd. All rights reserved.
 *
 * <p>
 **/
public class Parent {

    private String title;
    private int type;
    private List<Child> children;

    public Parent(String title, List<Child> children) {
        this.title = title;
        this.children = children;
    }

    public Parent() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
