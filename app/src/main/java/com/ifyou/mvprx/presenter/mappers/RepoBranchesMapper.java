package com.ifyou.mvprx.presenter.mappers;

import com.ifyou.mvprx.model.dto.BranchDTO;
import com.ifyou.mvprx.presenter.vo.Branch;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Baranov on 26.03.2017.
 */

public class RepoBranchesMapper implements Function<List<BranchDTO>, List<Branch>> {

    @Inject
    public RepoBranchesMapper() {
    }

    @Override
    public List<Branch> apply (List<BranchDTO> branchDTOs) {
        return Observable.fromIterable(branchDTOs)
                .map(branchDTO -> new Branch(branchDTO.getName()))
                .toList()
                .toObservable()
                .blockingFirst();
    }
}