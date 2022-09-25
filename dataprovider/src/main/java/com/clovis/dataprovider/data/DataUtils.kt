package com.clovis.dataprovider.data

import android.content.Context
import android.util.Log
import com.clovis.dataprovider.data.models.PopulationContentType
import com.clovis.dataprovider.data.models.PopulationType
import com.clovis.dataprovider.data.storage.AppDatabase
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.lang.ref.WeakReference

object DataUtils {

    //url could have been split in base and end point.
    private const val POPULATION_URL =
        "https://datausa.io/api/data?drilldowns=Nation&measures=Population"
    private const val DATA = "data"
    private const val ID = "ID Nation"
    private const val YEAR = "Year"
    private const val NATION = "Nation"

    fun getPopulationUrl() = POPULATION_URL

    fun convertToPopulationList(
        jsonString: String,
        mWeakContext: WeakReference<Context>
    ): List<PopulationType> {

        Log.d("population", jsonString)

        val populationTypeList: MutableList<PopulationType> = mutableListOf()
        val jsonObject = JSONTokener(jsonString).nextValue() as JSONObject
        val jsonArrayData = jsonObject.getString(DATA)
        val jsonArray = JSONTokener(jsonArrayData).nextValue() as JSONArray

        for (i in 0 until jsonArray.length()) {
            val id = jsonArray.getJSONObject(i).getString(ID)

            val nation = jsonArray.getJSONObject(i).getString(NATION)

            val year = jsonArray.getJSONObject(i).getString(YEAR)

            val serialNumber = if (year.toInt() < 2015) 1 else 2

            val populationType = PopulationType(
                name = nation + " " + (i + 1) * 2,
                PopulationContentType.PERSON,
                serialNumber
            )

            populationTypeList.add(populationType)

            mWeakContext.get()?.let { context ->
                AppDatabase.getDataBaseObject(context)
                    .populationDao()
                    .savePopulationType(populationType)

            }
        }

        // Just added below to make the headers and Footer since the data do not provide these

        PopulationType(
            "The Guests Have Reservations",
            PopulationContentType.SECTION,
            1
        ).let {
            populationTypeList.add(it)
            mWeakContext.get()?.let { context ->
                AppDatabase.getDataBaseObject(context)
                    .populationDao()
                    .savePopulationType(it)

            }
        }

        PopulationType(
            "At least one Guest in the party must have a reservation.Guests" +
                    "without reservations must remain in the same booking party in order to enter.",
            PopulationContentType.FOOTER,
            3
        ).let {
            populationTypeList.add(it)
            mWeakContext.get()?.let { context ->
                AppDatabase.getDataBaseObject(context)
                    .populationDao()
                    .savePopulationType(it)

            }
        }

        PopulationType(
            "The Guests Need Reservations",
            PopulationContentType.SECTION,
            2
        ).let {
            populationTypeList.add(it)
            mWeakContext.get()?.let { context ->
                AppDatabase.getDataBaseObject(context)
                    .populationDao()
                    .savePopulationType(it)

            }
        }

        return populationTypeList
    }
}