package com.example.setyourgoal.fragments

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.setyourgoal.MainActivity
import com.example.setyourgoal.databinding.Fragment2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    /////

    private lateinit var fragment2Binding: Fragment2Binding

    private var chronometer: Chronometer? = null
    private var pauseOffset: Long? = null
    private var running: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false)
        val view = fragment2Binding.root
        var chronometer: Chronometer? = fragment2Binding.chronometer


        //define first initalization
        chronometer!!.stop()
        pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
        running = false
        chronometer!!.format = "Time: %s"
        chronometer?.start()
        chronometer?.setBase(SystemClock.elapsedRealtime())
        pauseOffset = 0
        chronometer!!.stop()

        chronometer.setOnChronometerTickListener {
            fun onChronometerTick(chronometer: Chronometer? = fragment2Binding.chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer!!.base >= 10000) {
                    chronometer.base = SystemClock.elapsedRealtime()
                    val toast = Toast.makeText(activity, "Bing!", Toast.LENGTH_SHORT).show()

                }
            }
        }

        fragment2Binding.btFrag2Start.setOnClickListener {

            if (!running) {
                chronometer?.setBase(SystemClock.elapsedRealtime() - pauseOffset!!)
                chronometer?.start()
                running = true
                }
            }

            fragment2Binding.btFrag2Stop.setOnClickListener {

                if (running) {
                    chronometer!!.stop()
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
                    running = false
                }
            }
                fragment2Binding.btFrag2Reset.setOnClickListener {
                    chronometer?.setBase(SystemClock.elapsedRealtime())
                    pauseOffset = 0
                }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}