package com.example.onlineshopsatriaadhipradana

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.onlineshopsatriaadhipradana.databinding.FragmentSigninBinding
import com.example.onlineshopsatriaadhipradana.localdatabase.MyViewModel
import com.example.onlineshopsatriaadhipradana.localdatabase.User
import com.example.weatherapplication.common.di.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.regex.Matcher
import java.util.regex.Pattern

class SigninFragment : BaseFragment() {

    private var _binding: FragmentSigninBinding? = null

      private val viewModel: MyViewModel by activityViewModels { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSigninBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = view.findViewById<TextView>(R.id.button)
        activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)?.isVisible = false
        viewModel.getAll()
        login?.setOnClickListener {
            registerUser(view)
        }
    }

    private fun registerUser(view: View) {
        val firstName = _binding?.firstName?.text.toString()
        val lastName = _binding?.lastName?.text.toString()
        val email = _binding?.email?.text.toString()
        viewModel.fiendItem(firstName)
        viewModel.users.subscribe(lifecycleScope) {
            if (isEmailValid(email) && firstName.isNotEmpty()) {
                if (it.isEmpty()) {
                    viewModel.insert(User(firstName, lastName, email, ""))
                    view.findNavController().navigate(R.id.homeFragment)
                } else {
                    Toast.makeText(context, "already exists", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }
    }

    fun <T> kotlinx.coroutines.flow.Flow<T>.subscribe(
        scope: LifecycleCoroutineScope,
        action: suspend (T) -> Unit
    ) = onEach(action).launchIn(scope)
