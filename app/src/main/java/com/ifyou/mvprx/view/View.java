package com.ifyou.mvprx.view;

import com.ifyou.mvprx.model.data.Response;

import java.util.List;

/**
 * Created by Baranov on 25.03.2017.
 */

public interface View {

    void showData(List<Response> list);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
