package com.example.materialdesigncomponentbasic

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {

    lateinit var password: TextInputEditText
    lateinit var username: TextInputEditText

    lateinit var buttonNext: MaterialButton
    lateinit var buttonCancel: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById<TextInputEditText>(R.id.password_edit_text)
        password = view.findViewById<TextInputEditText>(R.id.password_edit_text)

        buttonNext = view.findViewById(R.id.shr_button_next)
        buttonCancel = view.findViewById(R.id.shr_cancel_button)

        buttonNext.setOnClickListener {
            if(!isPasswordValid(password.text)) {
                password.error = getString(R.string.shr_error_password)
            } else {
                password.error = null

                (activity as MainActivity).navigateTo(ProductGridFragment(), false)
            }
        }

        buttonNext.setOnKeyListener( { _, _, _ ->
            if(isPasswordValid(password.text)) {
                password.error = null
            }
            false
        })


        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}