package com.example.carlos.realprogrammersnew.platform.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.carlos.realprogrammersnew.R
import com.example.carlos.realprogrammersnew.platform.ServiceLocator
import com.example.carlos.realprogrammersnew.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerDetailPresenter
import kotlinx.android.synthetic.main.fragment_programmer_detail.*
import javax.inject.Inject

private const val ARG_PROGRAMMER_ID = "programmerId"


class ProgrammerDetailFragment : Fragment(), ProgrammerDetailView {

    @Inject
    lateinit var presenter: ProgrammerDetailPresenter

    private lateinit var programmerId: String
    private lateinit var favoriteCheckedChangeListener: CompoundButton.OnCheckedChangeListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            programmerId = it.getString(ARG_PROGRAMMER_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_programmer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wireUpViews()
        assembleDaggerModule()
        presenter.viewReady()

    }

    private fun wireUpViews() {
        prepareFavoriteToggleButton()
    }

    private fun assembleDaggerModule() {
        val serviceLocator = activity?.application as ServiceLocator
        val programmerDetailComponent = serviceLocator.provideProgrammerDetailComponentBuilder()
        programmerDetailComponent.view(this)
        programmerDetailComponent.programmerId(programmerId)
        programmerDetailComponent.build().inject(this)

    }

    private fun prepareFavoriteToggleButton() {
        favoriteCheckedChangeListener = CompoundButton.OnCheckedChangeListener { _, b ->
            presenter.favoriteChanged(b)
        }
        favorite_toggle_button_programmer_detail.setOnCheckedChangeListener(favoriteCheckedChangeListener)
    }

    override fun displayFirstName(firstName: String) {
        first_name_text_view_programmer_detail.text = firstName
    }

    override fun displayLastName(lastName: String) {
        last_name_text_view_programmer_detail.text = lastName
    }

    override fun setUpFavorite(favorite: Boolean) {
        favorite_toggle_button_programmer_detail.isChecked = favorite
    }

    override fun displayEmacs(emacsLabel: String) {
        emacs_text_view_programmer_detail.text = emacsLabel
    }

    override fun displayCaffeine(caffeineLabel: String) {
        caffeine_text_view_programmer_detail.text = caffeineLabel
    }

    override fun displayRealProgrammerRating(value: Int, colorCode: Int) {
        //TODO: por hacer todo el sistema del rating
    }


    companion object {

        @JvmStatic
        fun newInstance(programmerId: String) =
            ProgrammerDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PROGRAMMER_ID, programmerId)
                }
            }

        @JvmStatic
        fun startFragment(programmerId: String, supportFragmentManager: FragmentManager?, container: Int) {
            val fragment = ProgrammerDetailFragment.newInstance(programmerId)
            supportFragmentManager?.beginTransaction(
            )?.replace(container, fragment)?.addToBackStack(fragment.tag)?.commit()
        }
    }

}
