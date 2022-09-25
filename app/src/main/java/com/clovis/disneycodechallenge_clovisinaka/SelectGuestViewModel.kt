package com.clovis.disneycodechallenge_clovisinaka

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.clovis.dataprovider.data.models.PopulationType
import com.clovis.dataprovider.data.storage.AppDatabase
import com.clovis.dataprovider.usecases.PopulationUseCase
import kotlinx.coroutines.*

class SelectGuestViewModel(private val mApplication: Application) : AndroidViewModel(mApplication) {

    companion object {
        var mUpdatableSampleList: MutableList<PopulationType> = mutableListOf()
    }

    init {
        //PopulationUseCase().requestPopulationDataUseCase()
        makePopulationCoroutineCall()
        AppDatabase.getDataBaseObject(mApplication)
    }

    fun refreshPopulationList() = PopulationUseCase(mApplication).refreshPopulationDatUseCase()

    fun shouldEnableContinueButton(): Boolean {
        return mUpdatableSampleList.filter { it.isCheck }
            .filter { it.sectionNumber == 1 }
            .toList()
            .isNotEmpty()
    }

    fun getPopulationList(): List<PopulationType> = mUpdatableSampleList

    fun getPopulationListCoroutines(): List<PopulationType> = runBlocking {
        val list = async(Dispatchers.IO) {
            PopulationUseCase(mApplication).coroutineRequestPopulationDataUseCase()
        }
        delay(500L)
        list.await()
    }


    fun updateItemSelectionState(populationType: PopulationType) {
        mUpdatableSampleList?.forEach {
            if (populationType.sectionNumber == it.sectionNumber
                && populationType.name.equals(it.name, true)
            ) {
                it.isCheck = populationType.isCheck
            }
        }
        shouldEnableContinueButton()
    }

    private fun makePopulationCoroutineCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = PopulationUseCase(mApplication)
                .coroutineRequestPopulationDataUseCase()

            withContext(Dispatchers.IO) {
                mUpdatableSampleList = response as MutableList<PopulationType>
            }
        }
    }

    fun shouldDisplayBottomError(): Boolean {
        return mUpdatableSampleList.filter { it.isCheck }
            .filter { it.sectionNumber == 2 }
            .toList()
            .isNotEmpty()
    }
}