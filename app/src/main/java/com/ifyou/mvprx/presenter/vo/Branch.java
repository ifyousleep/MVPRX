package com.ifyou.mvprx.presenter.vo;

import java.io.Serializable;

/**
 * Created by Baranov on 26.03.2017.
 */

public class Branch implements Serializable {
    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}