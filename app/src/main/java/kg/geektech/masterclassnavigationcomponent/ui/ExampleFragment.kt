package kg.geektech.masterclassnavigationcomponent.ui

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kg.geektech.masterclassnavigationcomponent.MainActivity
import kg.geektech.masterclassnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_example.*

class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_home_back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    companion object {
        fun start(activity: Activity, action: Int, text: Bundle) {
            Navigation.findNavController(activity, R.id.nav_host_fragment)
                .navigate(action, text)
        }
    }
}