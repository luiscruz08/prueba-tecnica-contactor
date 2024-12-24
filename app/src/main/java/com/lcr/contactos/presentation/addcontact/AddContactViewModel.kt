package com.lcr.contactos.presentation.addcontact

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf("")

    val state: State<String> = _state

    init {
        Log.i("AddContactViewModel", "AddContactViewModel created!")
    }

}