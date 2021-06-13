package com.example.fragmentviewmodelupdate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val message : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val message2 : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val count : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val share_data : MutableLiveData<ShareData> by lazy {
        MutableLiveData<ShareData>()
    }

    init {
        message.value = "This is first Message"
        message2.value = "This is Second Message"
        count.value = 0
        share_data.value = ShareData
    }

    fun count() {
        count.value = count.value!! + 1
    }


    object ShareData {
        val share_message : MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }

        val share_count : MutableLiveData<Int> by lazy {
            MutableLiveData<Int>()
        }

        init {
            share_message.value = "Share message!"
            share_count.value = 0
        }

        fun count() {
            share_count.value = share_count.value!! + 1
        }
    }
}