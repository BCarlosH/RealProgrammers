package com.example.carlos.realprogrammersnew.platform.views

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carlos.realprogrammersnew.R
import com.example.carlos.realprogrammersnew.platform.ServiceLocator
import com.example.carlos.realprogrammersnew.presentation.ProgrammersListView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammersListPresenter
import kotlinx.android.synthetic.main.fragment_programmers_list.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import javax.inject.Inject

class ProgrammersListFragment : Fragment(), ProgrammersListView {


    private var thisContext: Context? = null

    @Inject
    lateinit var presenter: ProgrammersListPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programmers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assembleDaggerModule()
        presenter.viewReady()
        initAdapter()

        setFloatinButtonListener()
    }

    private fun setFloatinButtonListener() {
        fab_programmers_list.onClick {
            ProgrammerEditFragment.startFragment(activity?.supportFragmentManager, R.id.main_container)
        }
    }

    private fun assembleDaggerModule() {
        val serviceLocator = activity?.application as ServiceLocator
        val programmerListComponent = serviceLocator.provideProgrammerListComponentBuilder().view(this).build()
        programmerListComponent.inject(this)
    }

    private fun initAdapter() {
        if (thisContext != null) {
            recyclerView.apply {
                adapter = ProgrammerListAdapter(presenter) {
                    onItemClick(it)
                }
                layoutManager = LinearLayoutManager(thisContext)
            }
        }
    }

    private fun onItemClick(id: String) {
        presenter.onProgrammerItemClick(id)
    }

    override fun navigateToDetail(id: String) {
        ProgrammerDetailFragment.startFragment(id, activity?.supportFragmentManager, R.id.main_container)
    }

    override fun refreshView() {
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        thisContext = context
    }

}
