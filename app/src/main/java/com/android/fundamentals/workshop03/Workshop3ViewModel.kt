package com.android.fundamentals.workshop03

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.fundamentals.domain.location.Location
import com.android.fundamentals.domain.location.LocationGenerator
import kotlinx.coroutines.launch

class Workshop3ViewModel(
    private val generator: LocationGenerator
) : ViewModel() {

    private val _state = MutableLiveData(false)
    val state: LiveData<Boolean> get() = _state

    private val _list = MutableLiveData<List<Location>>(emptyList())
    val list: LiveData<List<Location>> get() = _list

    fun addNew() {
        viewModelScope.launch {
            _state.value = true

            val newLocation = generator.generateNewLocation()
            val updateLocation = _list.value?.plus(newLocation).orEmpty()
            _list.value = updateLocation

            _state.value = false
        }
    }
}