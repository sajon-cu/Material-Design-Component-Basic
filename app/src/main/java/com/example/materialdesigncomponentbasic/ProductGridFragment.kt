package com.example.materialdesigncomponentbasic

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesigncomponentbasic.network.ProductEntry
import com.example.materialdesigncomponentbasic.network.ProductEntry.Companion.initProductEntryList

/**
 * A simple [Fragment] subclass.
 * Use the [ProductGridFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductGridFragment : Fragment() {
    lateinit var appBar: Toolbar

    // RecyclerView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_grid, container, false)

        appBar = view.findViewById(R.id.app_bar)
        (activity as AppCompatActivity).setSupportActionBar(appBar)

        recyclerView = view.findViewById(R.id.recycler_view)
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)

        Log.d(TAG, "List: ${initProductEntryList(resources)}")

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))
            adapter = ProductCardRecyclerViewAdapter(initProductEntryList(resources))
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object {
        private val TAG = ProductGridFragment::class.simpleName
    }
}