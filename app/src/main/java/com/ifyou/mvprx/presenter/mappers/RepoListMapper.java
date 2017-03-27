package com.ifyou.mvprx.presenter.mappers;

import com.ifyou.mvprx.model.dto.RepositoryDTO;
import com.ifyou.mvprx.presenter.vo.Repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by Baranov on 26.03.2017.
 */

public class RepoListMapper implements Function<List<RepositoryDTO>, List<Repository>> {

    @Override
    public List<Repository> apply (List<RepositoryDTO> repositoryDTOs) {
        return Observable.fromIterable(repositoryDTOs)
                .map(repoDTO -> new Repository(repoDTO.getName(), repoDTO.getOwner().getLogin()))
                .toList()
                .toObservable()
                .blockingFirst();
    }

}
