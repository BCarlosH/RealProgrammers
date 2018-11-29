package com.example.carlos.realprogrammersnew.platform.views

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.example.carlos.realprogrammersnew.R
import com.example.carlos.realprogrammersnew.helpers.Cancelable
import com.example.carlos.realprogrammersnew.helpers.Confirmable
import com.example.carlos.realprogrammersnew.platform.ServiceLocator
import com.example.carlos.realprogrammersnew.platform.helpers.addTextChangedListener
import com.example.carlos.realprogrammersnew.platform.helpers.setOnSeekBarChangeListener
import com.example.carlos.realprogrammersnew.presentation.ProgrammerEditView
import com.example.carlos.realprogrammersnew.presentation.presenters.ProgrammerEditPresenter
import kotlinx.android.synthetic.main.fragment_add_programmer.*
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.yesButton
import javax.inject.Inject


class ProgrammerEditFragment : Fragment(), Cancelable, ProgrammerEditView {


    private var thisContext: Context? = null

    @Inject
    lateinit var presenter: ProgrammerEditPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_programmer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wireUpViews()
        assembleDaggerModule()
        presenter.viewReady()

    }

    private fun assembleDaggerModule() {
        val serviceLocator = activity?.application as ServiceLocator
        val programmerEditComponent = serviceLocator.provideProgrammerEditComponentBuilder().view(this).build()
        programmerEditComponent.inject(this)
    }

    override fun onCancel() {

        alert("perderás los datos, estas seguro") {
            title = "Cerrar"
            yesButton {
                val confirmableActivity = activity as? Confirmable
                confirmableActivity?.confirm()
            }
            noButton { }
        }.show()

    }

    override fun setUpFirstNameEntry(firstName: String) {
        firstname_edit_text_programmer_edit.setText(firstName)
    }

    override fun setUpLastNameEntry(lastName: String) {
        lastname_edit_text_programmer_edit.setText(lastName)
    }

    override fun setUpFavorite(favorite: Boolean) {
        favorite_toggle_button_programmer_edit.setOnCheckedChangeListener(null)
        favorite_toggle_button_programmer_edit.isChecked = favorite
//        favorite_toggle_button_programmer_edit.setOnCheckedChangeListener(favoriteCheckedChangeListener)
    }

    override fun setUpEmacsValue(value: Int) {
        emacs_seek_bar_programmer_edit.progress = value
    }

    override fun displayEmacs(emacsValue: Int) {
        emacs_text_view_programmer_edit.text = getEmacsLabel(emacsValue)
    }

    override fun setUpCaffeineValue(value: Int) {
        caffeine_seek_bar_programmer_edit.progress = value
    }

    override fun displayCaffeine(caffeineValue: Int) {
        caffeine_text_view_programmer_edit.text = getCaffeineLabel(caffeineValue)
    }

    override fun displayRealProgrammerRating(value: Int, colorCode: Int) {

//        rpr_rating_bar_programmer_edit.setProgress(value, false)
//
//        if (thisContext != null) {
//            rpr_rating_bar_programmer_edit.rating = (value + 1).toFloat()
//            val stars = rpr_rating_bar_programmer_edit.progressDrawable as LayerDrawable
//            stars.getDrawable(2).setColorFilter(ContextCompat.getColor(thisContext, thisContext.getColorId(colorCode)), PorterDuff.Mode.SRC_ATOP)
//        }

    }

    private fun wireUpViews() {
        prepareFirstNameEditText()
        prepareLastNameEditText()
        prepareFavoriteToggleButton()
        prepareEmacsSeekBar()
//        prepareEmacsTextView()
        prepareCaffeineSeekBar()
//        prepareCaffeineTextView()
//        prepareRprRatingBar()
    }

    private fun prepareFirstNameEditText() {
        val firstNameEditText = firstname_edit_text_programmer_edit
        firstNameEditText.addTextChangedListener(afterTextChanged = { editable ->
            presenter.firstNameChanged(editable.toString())
        })
    }

    private fun prepareLastNameEditText() {
        val lastNameEditText = lastname_edit_text_programmer_edit
        lastNameEditText.addTextChangedListener(afterTextChanged = { editable ->
            presenter.lastNameChanged(editable.toString())
        })
    }

    private fun prepareFavoriteToggleButton() {
        val favoriteToggleButton = favorite_toggle_button_programmer_edit
        val favoriteCheckedChangeListener = CompoundButton.OnCheckedChangeListener { _, value ->
            presenter.favoriteChanged(value)
        }
        favoriteToggleButton.setOnCheckedChangeListener(favoriteCheckedChangeListener)
    }

    private fun prepareEmacsSeekBar() {
        val emacsSeekBar = emacs_seek_bar_programmer_edit
        emacsSeekBar.setOnSeekBarChangeListener(onProgressChanged = { _, value, _ ->
            presenter.emacsChanged(value)
        })
    }

    private fun prepareCaffeineSeekBar() {
        val caffeineSeekBar = caffeine_seek_bar_programmer_edit
        caffeineSeekBar.setOnSeekBarChangeListener(onProgressChanged = { _, value, _ ->
            presenter.caffeineChanged(value)
        })
    }

    override fun enableSaveButton(enabled: Boolean) {
        save_programmer_button.isEnabled = enabled
    }

    private fun getEmacsLabel(value: Int): String {
        return when (value) {
            0 -> "Cero"
            1 -> "Uno"
            2 -> "Dos"
            3 -> "Tres"
            4 -> "Cuatro"
            else -> ""
        }
    }

    private fun getCaffeineLabel(value: Int): String {
        return when (value) {
            0 -> "Very Bad"
            1 -> "Bad"
            2 -> "Works"
            3 -> "Nice"
            4 -> "Master"
            else -> ""
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        thisContext = context
    }


    companion object {

        @JvmStatic
        fun newInstance() = ProgrammerEditFragment()

        @JvmStatic
        fun startFragment(supportFragmentManager: FragmentManager?, container: Int) {
            val fragmet = newInstance()
            supportFragmentManager?.beginTransaction(
            )?.replace(container, fragmet)?.addToBackStack(fragmet.tag)?.commit()
        }
    }

}
