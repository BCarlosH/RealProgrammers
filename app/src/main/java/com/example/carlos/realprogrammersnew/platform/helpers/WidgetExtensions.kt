package com.example.carlos.realprogrammersnew.platform.helpers

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar


/**
 * 20170905. Initial version created by jorge
 * for a Canonical Examples training.
 *
 * Copyright 2017 Jorge D. Ortiz Fuentes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
fun EditText.addTextChangedListener(
    beforeTextChanged: (CharSequence, Int, Int, Int) -> Unit = { _, _, _, _ -> },
    onTextChanged: (CharSequence, Int, Int, Int) -> Unit = { _, _, _, _ -> },
    afterTextChanged: (Editable) -> Unit = { _ -> }
) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            beforeTextChanged(charSequence, i, i1, i2)
        }

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            onTextChanged(charSequence, i, i1, i2)
        }

        override fun afterTextChanged(editable: Editable) {
            afterTextChanged(editable)
        }
    })
}

fun SeekBar.setOnSeekBarChangeListener(
    onProgressChanged: (SeekBar, Int, Boolean) -> Unit = { _, _, _ -> },
    onStartTrackingTouch: (SeekBar) -> Unit = { _ -> },
    onStopTrackingTouch: (SeekBar) -> Unit = { _ -> }
) {
    this.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, value: Int, b: Boolean) {
            onProgressChanged(seekBar, value, b)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            onStartTrackingTouch(seekBar)
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            onStopTrackingTouch(seekBar)
        }
    })
}
