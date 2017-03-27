package com.ifyou.mvprx.model;

import com.ifyou.mvprx.model.dto.BranchDTO;
import com.ifyou.mvprx.model.dto.ContributorDTO;
import com.ifyou.mvprx.model.dto.RepositoryDTO;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Baranov on 25.03.2017.
 */

public interface Model {

    Observable<List<RepositoryDTO>> getRepoList(String name);

    Observable<List<BranchDTO>> getRepoBranches(String owner, String name);

    Observable<List<ContributorDTO>> getRepoContributors(String owner, String name);
}
