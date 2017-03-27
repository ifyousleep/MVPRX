package com.ifyou.mvprx.presenter.vo;

import java.io.Serializable;

/**
 * Created by Baranov on 26.03.2017.
 */

public class Contributor implements Serializable {
    private String name;

    public Contributor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}