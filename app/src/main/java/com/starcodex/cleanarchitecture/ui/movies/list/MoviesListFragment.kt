package com.starcodex.cleanarchitecture.ui.movies.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.starcodex.cleanarchitecture.R
import com.starcodex.cleanarchitecture.databinding.MainFragmentBinding
import com.starcodex.cleanarchitecture.domain.movies.model.MovieItem
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.MoviesListAdapter
import com.starcodex.cleanarchitecture.ui.movies.list.adapter.OnItemClickListener
import com.starcodex.cleanarchitecture.utils.commons.BaseFragment
import javax.inject.Inject
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.MenuItemCompat
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.starcodex.cleanarchitecture.ui.movies.FragmentActivityInteraction
import com.starcodex.cleanarchitecture.ui.movies.detail.DetailMovieFragment
import kotlin.collections.HashMap


class MoviesListFragment : BaseFragment<MainFragmentBinding, MoviesListViewModel>(), OnItemClickListener, AdapterView.OnItemSelectedListener {

    val viewModel: MoviesListViewModel by viewModels { viewModelFactory }
    private var activityInterface: FragmentActivityInteraction? = null
    lateinit var moviesAdapter: MoviesListAdapter


    // Spinner Dropdown in ActionBar
    lateinit var categoriesSelector: Spinner
    var spinnerMap = HashMap<String, String>()
    var spinnerPosition: Int = -1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (savedInstanceState != null) { spinnerPosition = savedInstanceState.getInt("spinnerPosition") }
        (activity as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        moviesAdapter = MoviesListAdapter(activity as Context, this)
        initRecycler()
        viewModel.getMovieslistLiveData().observe(this, Observer {
            moviesAdapter.submitList(it)
        })
    }

    fun initRecycler() {
        binding.moviesRecycler.addItemDecoration(
            DividerItemDecoration(
                activity,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.moviesRecycler.setLayoutManager(LinearLayoutManager(activity))
        binding.moviesRecycler.adapter = moviesAdapter
    }

    // Handle Click On RecyclerViewItems
    override fun onItemClick(item: MovieItem) {
        activityInterface!!.replaceFragmentCurrent(DetailMovieFragment(item))
    }

    // Create Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_spinner, menu)

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


    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Handle Nothing Selected
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (spinnerPosition != p2) {
            spinnerPosition = p2
            viewModel.loadList(spinnerMap.get(categoriesSelector.selectedItem.toString())!!)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when {
            context is FragmentActivityInteraction -> activityInterface = context
            else -> throw IllegalArgumentException("$context must implement FragmentActivityInteraction")
        }
    }

    // Save Spinner State
/*    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("spinnerPosition", categoriesSelector.selectedItemPosition)
    }*/
}
