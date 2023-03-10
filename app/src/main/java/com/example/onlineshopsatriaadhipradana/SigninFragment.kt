package com.example.onlineshopsatriaadhipradana

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.onlineshopsatriaadhipradana.databinding.FragmentSigninBinding
import com.example.onlineshopsatriaadhipradana.localdatabase.MyViewModel
import com.example.onlineshopsatriaadhipradana.localdatabase.User
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.regex.Matcher
import java.util.regex.Pattern

class SigninFragment : Fragment() {

    private var _binding: FragmentSigninBinding? = null

    private val viewModel by lazy { ViewModelProvider(this)[MyViewModel::class.java] }
    private val databaseModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
        viewModel.getAll()

        login?.setOnClickListener {
//            registerUser()

            val firstName = _binding?.firstName?.text.toString()
            val lastName = _binding?.lastName?.text.toString()
            val email = _binding?.email?.text.toString()
            viewModel.fiendItem(firstName)
            viewModel.users.subscribe(lifecycleScope){
                if (it.isEmpty()){
                    viewModel.insert(User(firstName,lastName,email,""))
                } else {
                    Toast.makeText(context,":already exists", Toast.LENGTH_SHORT).show()
                }
            }
//            view.findNavController().navigate(R.id.homeFragment)
        }
    }

    private fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun registerUser() {
        val firstName = _binding?.firstName?.text.toString()
        val lastName = _binding?.lastName?.text.toString()
        val email = _binding?.email?.text.toString()

        }
    }

    fun <T> kotlinx.coroutines.flow.Flow<T>.subscribe(
        scope: LifecycleCoroutineScope,
        action: suspend (T) -> Unit
    ) = onEach(action).launchIn(scope)
