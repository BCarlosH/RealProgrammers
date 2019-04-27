package com.example.carlos.realprogrammers.platform.views

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.carlos.realprogrammers.R
import com.example.carlos.realprogrammers.platform.ServiceLocator
import com.example.carlos.realprogrammers.platform.helpers.getCaffeineLabel
import com.example.carlos.realprogrammers.platform.helpers.getColorId
import com.example.carlos.realprogrammers.platform.helpers.getEmacsLabel
import com.example.carlos.realprogrammers.presentation.ProgrammerDetailView
import com.example.carlos.realprogrammers.presentation.presenters.ProgrammerDetailPresenter
import kotlinx.android.synthetic.main.fragment_programmer_detail.*
import javax.inject.Inject

private const val ARG_PROGRAMMER_ID = "programmerId"


class ProgrammerDetailFragment : Fragment(), ProgrammerDetailView {

    @Inject
    lateinit var presenter: ProgrammerDetailPresenter

    private lateinit var activityContext: Context
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

    override fun displayEmacs(emacsValue: Int?) {
        emacs_text_view_programmer_detail.text = getEmacsLabel(activityContext, emacsValue)
    }

    override fun displayCaffeine(caffeineValue: Int?) {
        caffeine_text_view_programmer_detail.text = getCaffeineLabel(activityContext, caffeineValue)
    }

    override fun displayRealProgrammerRating(value: Int, colorCode: Int) {
        rpr_rating_bar_programmer_detail.rating = (value + 1).toFloat()
        val stars = rpr_rating_bar_programmer_detail.progressDrawable as LayerDrawable
        stars.getDrawable(2)
            .setColorFilter(ContextCompat.getColor(activityContext, getColorId(colorCode)), PorterDuff.Mode.SRC_ATOP)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            activityContext = context
        }

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
