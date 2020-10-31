package kg.geektech.masterclassnavigationcomponent.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kg.geektech.masterclassnavigationcomponent.R
import kg.geektech.masterclassnavigationcomponent.ui.ExampleFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)


        button_home_next.setOnClickListener {
            val bundle  = Bundle()
            bundle.putString("text", "text")

            /**Java*/
            /*Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_mainFragment_to_exampleFragment)*/

            /**Kotlin*/
            //findNavController().navigate(R.id.action_mainFragment_to_exampleFragment, bundle)

            ExampleFragment.start(requireActivity(),
                R.id.action_mainFragment_to_exampleFragment, bundle)
        }
    }
}