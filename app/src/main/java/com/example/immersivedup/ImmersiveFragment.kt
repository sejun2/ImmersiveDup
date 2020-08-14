package com.example.immersivedup

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment

class ImmersiveFragment : Fragment() {
    companion object{
        val TAG = "ImmersiveFragment"
    }
    var immersiveModeStatus = false
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var decorView = activity?.window?.decorView

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "${item.itemId} selected!")
        when(item.itemId){
            R.id.sample_action -> {
                if(immersiveModeStatus == false) {
                    activity?.window?.insetsController?.hide(WindowInsets.Type.navigationBars())
                    activity?.window?.insetsController?.hide(WindowInsets.Type.statusBars())
                    activity?.window?.insetsController?.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
                    immersiveModeStatus = true
                }
                else{
                    activity?.window?.insetsController?.show(WindowInsets.Type.navigationBars())
                    activity?.window?.insetsController?.show(WindowInsets.Type.statusBars())
                    activity?.window?.insetsController?.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_BARS_BY_SWIPE
                    immersiveModeStatus = false
                }
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

}