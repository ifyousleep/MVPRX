package com.ifyou.mvprx.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ifyou.mvprx.R;
import com.ifyou.mvprx.presenter.vo.Repository;
import com.ifyou.mvprx.view.fragments.RepoInfoFragment;
import com.ifyou.mvprx.view.fragments.RepoListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements ActivityCallback {

    private static String TAG = "TAG";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(TAG);
        if (fragment == null) replaceFragment(new RepoListFragment(), false);
    }

    private void replaceFragment(Fragment fragment, boolean addBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment, TAG);
        if (addBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void startRepoInfoFragment(Repository repository) {
        replaceFragment(RepoInfoFragment.newInstance(repository), true);
    }

}

/*public class MainActivity extends AppCompatActivity implements View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.button)
    Button searchButton;

    private Presenter presenter;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new ResponseListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(v ->
                presenter.onSearchButtonClick()
        );
    }

    @Override
    public void showData(List<RepositoryDTO> list) {
        adapter.setRepoList(list);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    private void makeToast(String text) {
        Snackbar.make(toolbar, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast(getString(R.string.empty_repo_list));
    }

    @Override
    public String getUserName() {
        return editText.getText().toString();
    }
}*/
