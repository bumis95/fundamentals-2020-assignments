package com.android.academy.fundamentals.app.workshop04

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.work.WorkManager
import com.android.academy.fundamentals.app.R

class WS04Fragment : Fragment(R.layout.fragment_ws04) {

    private val workRepository = WorkRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        WorkManager.getInstance(requireContext()).enqueue(workRepository.simpleRequest)

        WorkManager.getInstance(requireContext()).enqueue(workRepository.delayedRequest)

        WorkManager.getInstance(requireContext()).enqueue(workRepository.constrainedRequest)
    }

    companion object {
        fun create() = WS04Fragment()
    }
}
