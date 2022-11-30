package com.example.communicate_activity_fragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SendDataViewModel : ViewModel() {
    private var mutableCalendar: MutableLiveData<String> = MutableLiveData()
    val selectedData: LiveData<String> = mutableCalendar
    fun selectData(data: String) {
        mutableCalendar.postValue(data)
    }
}
