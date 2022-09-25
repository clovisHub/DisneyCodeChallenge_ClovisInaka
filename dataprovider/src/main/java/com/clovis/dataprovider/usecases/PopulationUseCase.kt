package com.clovis.dataprovider.usecases

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.clovis.dataprovider.data.DataUtils
import com.clovis.dataprovider.data.models.PopulationType
import com.clovis.dataprovider.data.repo.Repository
import com.clovis.dataprovider.data.storage.AppDatabase
import java.lang.ref.WeakReference

class PopulationUseCase(private val context: Context) : PopulationListener {

    private val mPopulationObservable: MutableLiveData<List<PopulationType>> = MutableLiveData()

    fun requestPopulationDataUseCase() {
        Repository().makeHttpRequest(DataUtils.getPopulationUrl(), "")
        mPopulationObservable.postValue(
            DataUtils
                .convertToPopulationList(Repository().getResponse(), WeakReference(context))
        )
    }

    suspend fun coroutineRequestPopulationDataUseCase(): List<PopulationType> {
        val response = DataUtils.convertToPopulationList(
            Repository()
                .makeCoroutineHttpRequest(DataUtils.getPopulationUrl()), WeakReference(context)
        )
        mPopulationObservable.postValue(response)
        return response.ifEmpty {
            AppDatabase
                .getDataBaseObject(context)
                .populationDao()
                .getAllPopulation() ?: listOf()
        }
    }

    suspend fun updateObservable(populations: List<PopulationType>) {
        mPopulationObservable.postValue(populations)
    }

    fun refreshPopulationDatUseCase() {
        Repository().refreshHttpRequest(DataUtils.getPopulationUrl(), "")
        mPopulationObservable.postValue(
            DataUtils
                .convertToPopulationList(Repository().getResponse(), WeakReference(context))
        )
    }

    fun getPopulationList() = mPopulationObservable

    override fun getPopulationResponse(response: String) {
        mPopulationObservable.postValue(
            DataUtils
                .convertToPopulationList(response, WeakReference(context))
        )
    }
}

interface PopulationListener {
    fun getPopulationResponse(response: String)
}