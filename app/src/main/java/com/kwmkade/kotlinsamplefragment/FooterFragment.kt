package com.kwmkade.kotlinsamplefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels

class FooterFragment : Fragment() {
    private lateinit var _buttonLeft: Button
    private lateinit var _buttonCenter: Button
    private lateinit var _buttonRight: Button
    private lateinit var _switchCard: Switch

    private val _viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_footer, container, false)
        _buttonLeft = view.findViewById(R.id.button_left)
        _buttonCenter = view.findViewById(R.id.button_center)
        _buttonRight = view.findViewById(R.id.button_right)

        _buttonLeft.setOnClickListener(ButtonClickListener(activity, _viewModel, "Left"))
        _buttonCenter.setOnClickListener(ButtonClickListener(activity, _viewModel, "Center"))
        _buttonRight.setOnClickListener(ButtonClickListener(activity, _viewModel, "Right"))

        _switchCard = view.findViewById(R.id.switch_card)
        _switchCard.setOnCheckedChangeListener(SwitchCheckedChangeListener(activity))

        return view
    }

    private class ButtonClickListener(
        private val _activity: FragmentActivity?,
        private val _viewModel: ItemViewModel,
        private val _inputText: String
    ) :
        View.OnClickListener {
        override fun onClick(p0: View?) {
            _viewModel.addItem(_inputText)
        }
    }

    private class SwitchCheckedChangeListener(
        private val _activity: FragmentActivity?
    ) : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if (_activity is MainActivity) {
                _activity.replaceFragment(p1)
            }
        }
    }

}