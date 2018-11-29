package com.example.carlos.realprogrammersnew.helpers

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


/**
 * 20170828. Initial version created by jorge
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
class RetainedFragment<T : Any> : Fragment() {
    companion object {
        fun <T : Any> retrieveOrInject(
            activity: AppCompatActivity,
            tag: String,
            connect: () -> T,
            reconnect: (T) -> Unit
        ): RetainedFragment<T> {
            val fragmentManager = activity.supportFragmentManager
            @Suppress("UNCHECKED_CAST")
            var retainedFragment: RetainedFragment<T>? = fragmentManager.findFragmentByTag(tag) as RetainedFragment<T>?

            if (retainedFragment == null) {
                retainedFragment = RetainedFragment<T>()
                retainedFragment.presenter = connect()
                fragmentManager.beginTransaction().add(retainedFragment, tag).commit()
            } else {
                reconnect(retainedFragment.presenter)
            }

            return retainedFragment
        }
    }

    //<editor-fold desc="Fields">
    lateinit var presenter: T
    //</editor-fold>

    //<editor-fold desc="Constructor">
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    //</editor-fold>

    // Invoke this in onPause (if (isFinishing()).
    //<editor-fold desc="Release references">
    fun dismiss(appCompatActivity: AppCompatActivity) {
        val fragmentManager = appCompatActivity.supportFragmentManager
        fragmentManager.beginTransaction().remove(this).commit()
    }
    //</editor-fold>

}
