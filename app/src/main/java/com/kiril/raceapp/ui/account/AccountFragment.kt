package com.kiril.raceapp.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.kiril.raceapp.R
import com.kiril.raceapp.ui.auth.AuthActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.launch
import kotlinx.serialization.json.jsonPrimitive
import javax.inject.Inject

@AndroidEntryPoint
class AccountFragment : Fragment() {
    @Inject
    lateinit var supabaseClient: SupabaseClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = supabaseClient.auth.currentUserOrNull()

        val accountNameTextView: TextView = view.findViewById(R.id.account_name)
        val logOutButton: Button = view.findViewById(R.id.log_out_button)

        // Set the account name
        accountNameTextView.text =
            user?.email

        logOutButton.setOnClickListener {
            // Handle log out logic here
            logOut()
        }
    }

    private fun logOut() {
        lifecycleScope.launch {
            supabaseClient.auth.signOut()
            startActivity(Intent(context, AuthActivity::class.java))
        }
    }
}
