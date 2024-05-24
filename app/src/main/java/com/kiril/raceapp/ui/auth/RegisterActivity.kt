package com.kiril.raceapp.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.kiril.raceapp.R
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    @Inject
    lateinit var supabaseClient: SupabaseClient

    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var registerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        registerButton = findViewById(R.id.register_button)

        registerButton.setOnClickListener {
            register()
        }
    }

    private fun register() {
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        lifecycleScope.launch {
            supabaseClient.auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
        }
    }
}