package com.sportivity.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sportivity.R;
import com.sportivity.adapters.TrainerListAdapter;
import com.sportivity.loaders.TrainerListLoader;
import com.sportivity.util.TrainerTypesUtil;
import com.sportivity.web.entities.Trainer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Alex Klimashevsky on 28.11.2015.
 */
public class TrainerListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Trainer>> {

    @Bind(R.id.trainers)
    RecyclerView trainersView;

    @Bind(R.id.types)
    Spinner mTypesSpinner;

    public static TrainerListFragment newInstance() {
        return new TrainerListFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.trainer_list, menu);

        android.support.v7.widget.SearchView search = (android.support.v7.widget.SearchView) menu.findItem(R.id.search).getActionView();

        search.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void loadData() {
        getLoaderManager().restartLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_trainer_list, container, false);
        ButterKnife.bind(this, root);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        trainersView.setLayoutManager(manager);
        List<String> t = new LinkedList<>();
        t.add("Type of a trainer:");
        t.addAll(Arrays.asList(TrainerTypesUtil.getTypes()));
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_spinner_item, t);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        mTypesSpinner.setAdapter(adapter);
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public Loader<List<Trainer>> onCreateLoader(int id, Bundle args) {
        return new TrainerListLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Trainer>> loader, List<Trainer> data) {
        TrainerListAdapter adapter = new TrainerListAdapter(data);
        trainersView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<List<Trainer>> loader) {

    }
}
