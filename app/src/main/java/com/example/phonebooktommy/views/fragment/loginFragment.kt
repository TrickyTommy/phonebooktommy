package com.example.phonebooktommy.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.phonebooktommy.R
import com.example.phonebooktommy.databinding.FragmentLoginBinding
import com.example.phonebooktommy.repository.utils.SessionUtil
import com.example.phonebooktommy.viewmodels.LoginState
import com.example.phonebooktommy.viewmodels.LoginViewModel

class loginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private val session by lazy { SessionUtil(requireContext()) }
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false).apply {
            if (session.token.isNotEmpty()) {
                findNavController().navigate(R.id.action_loginFragment_to_contactFragment)
            }

            btnLogin.setOnClickListener {
                if (tieEmail.text.toString().isNotEmpty() && tiePassword.text.toString()
                        .isNotEmpty()
                ) {
                    loginViewModel.login(tieEmail.text.toString(), tiePassword.text.toString())
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Email dan password tidak boleh kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            loginViewModel.state.observe(viewLifecycleOwner){
                when(it){
                    is LoginState.Login -> {
                        btnLogin.visibility =View.VISIBLE

                        session.token = it.data.token

                        findNavController().navigate(R.id.action_loginFragment_to_contactFragment)
                    }
                    is LoginState.Loading -> btnLogin.visibility=View.GONE
                    is LoginState.Error -> {
                        btnLogin.visibility= View.VISIBLE

                        Toast.makeText(requireContext(), it.exception.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        return binding.root
    }


}