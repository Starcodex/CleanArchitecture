package com.starcodex.cleanarchitecture.ui.movies.list

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.starcodex.cleanarchitecture.R
import com.starcodex.cleanarchitecture.databinding.MainFragmentBinding
import com.starcodex.cleanarchitexture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.MoviesListAdapter
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.OnItemClickListener
import com.starcodex.cleanarchitecture.commons.InjectableBaseFragment
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.MenuItemCompat
import android.widget.Spinner
import com.starcodex.cleanarchitecture.ui.movies.FragmentActivityInteraction
import com.starcodex.cleanarchitecture.ui.movies.detail.DetailMovieFragment
import javax.inject.Inject
import kotlin.collections.HashMap


class MoviesListFragment : InjectableBaseFragment<MoviesListViewModelImpl, MainFragmentBinding>(), OnItemClickListener, AdapterView.OnItemSelectedListener {

    override fun getLayoutRes(): Int {
        return R.layout.main_fragment
    }

    @Inject
    lateinit var activityInterface: FragmentActivityInteraction

    //lateinit var binding: MainFragmentBinding
    lateinit var moviesAdapter: MoviesListAdapter

    // Spinner Dropdown in ActionBar
    lateinit var categoriesSelector: Spinner
    var spinnerMap = HashMap<String, String>()
    var spinnerPosition: Int = -1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        enableHomeActionBar(false)
        setHasOptionsMenu(true)
        moviesAdapter = MoviesListAdapter(activity as Context, this)
        initRecycler()
        viewModel.moviesListLiveData.observe(this, Observer { moviesAdapter.submitList(it) })
    }

    fun initRecycler() {
        binding.moviesRecycler.addItemDecoration(DividerItemDecoration(activity,LinearLayoutManager.VERTICAL))
        binding.moviesRecycler.setLayoutManager(LinearLayoutManager(activity))
        binding.moviesRecycler.adapter = moviesAdapter
    }

    // Handle Click On RecyclerViewItems
    override fun onItemClick(item: MovieItem) {
        activityInterface.replaceFragmentCurrent(DetailMovieFragment(item))
    }

    // Create Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_spinner, menu)
        setSpinner(menu)
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Handle Nothing Selected
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (spinnerPosition != p2) {
            spinnerPosition = p2
            viewModel.loadList(spinnerMap.get(categoriesSelector.selectedItem.toString())!!)
        }
    }

    // Set Toolbar Spinner
    fun setSpinner(menu: Menu){
        val item = menu.findItem(R.id.spinner)
        categoriesSelector = MenuItemCompat.getActionView(item) as Spinner

        // Populate HasMap
        val keys = getResources().getStringArray(R.array.movie_categorie_keys)
        val values = getResources().getStringArray(R.array.movie_categorie_values)
        spinnerMap = HashMap()
        for (i in 0 until keys.size) { spinnerMap.put(keys[i], values[i]) }

        val adapter = ArrayAdapter.createFromResource(
            activity as Context,
            R.array.movie_categorie_keys, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categoriesSelector.adapter = adapter
        categoriesSelector.setSelection(spinnerPosition) // Restore Spinner State
        categoriesSelector.onItemSelectedListener = this
    }

}
