package com.example.loginscreenkt.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginscreenkt.data.model.User
import com.example.loginscreenkt.data.repository.UserRepository
import com.example.loginscreenkt.databinding.ActivityMainBinding
import com.example.loginscreenkt.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userRepository = UserRepository()
        userViewModel = UserViewModel(userRepository)

        initListeners()
        initObservers()
    }

    private fun initObservers(){
        userViewModel.createUserIsSuccessfull.observe(this){ isCreated ->
            if(isCreated){
                Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Erro ao cadastrar usuario", Toast.LENGTH_SHORT).show()
            }
        }

        userViewModel.signInIsSuccessfull.observe(this){ isSignedIn ->
            if(isSignedIn){
                Toast.makeText(this, "Login realizado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Erro ao realizar login", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initListeners(){
        binding.buttonSignIn.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val user = User(email, password)
            userViewModel.signIn(user)
        }

        binding.buttonCreateUser.setOnClickListener{
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            val user = User(email, password)
            userViewModel.createUser(user)
        }
    }
}

