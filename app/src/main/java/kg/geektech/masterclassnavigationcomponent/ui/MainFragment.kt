package kg.geektech.masterclassnavigationcomponent.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kg.geektech.masterclassnavigationcomponent.R
import kg.geektech.masterclassnavigationcomponent.ui.dashboard.DashboardFragment
import kg.geektech.masterclassnavigationcomponent.ui.home.HomeFragment
import kg.geektech.masterclassnavigationcomponent.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.sql.StatementEventListener

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        nonscrolalblepager_main.adapter = MainPagerAdapter(childFragmentManager)
        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    nonscrolalblepager_main.currentItem = 0
                }

                R.id.navigation_dashboard -> {
                    nonscrolalblepager_main.currentItem = 1
                }

                R.id.navigation_notifications -> {
                    nonscrolalblepager_main.setCurrentItem(2, false)
                }
            }
            true
        }
    }

    class MainPagerAdapter(fm: FragmentManager) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> HomeFragment()
                1 -> DashboardFragment()
                2 -> NotificationsFragment()
                else -> HomeFragment()
            }
        }
    }
}