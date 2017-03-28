package com.ifyou.mvprx.presenter.mappers;

import com.ifyou.mvprx.model.dto.ContributorDTO;
import com.ifyou.mvprx.presenter.vo.Contributor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Baranov on 26.03.2017.
 */

public class RepoContributorsMapper implements Function<List<ContributorDTO>, List<Contributor>> {

    @Inject
    public RepoContributorsMapper() {
    }

    @Override
    public List<Contributor> apply (List<ContributorDTO> branchDTOs) {
        return Observable.fromIterable(branchDTOs)
                .map(contributorDTO -> new Contributor(contributorDTO.getLogin()))
                .toList()
                .toObservable()
                .blockingFirst();
    }
}
