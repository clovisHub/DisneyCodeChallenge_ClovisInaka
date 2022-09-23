package com.clovis.disneycodechallenge_clovisinaka.ui

import androidx.lifecycle.ViewModel

class SelectGuestViewModel : ViewModel() {

    companion object {
        private var mUpdatableSampleList : MutableList<DashBoardContent> = mutableListOf()
    }

    init {
        mUpdatableSampleList = getDashBoardFakeData().toMutableList()
    }

    fun shouldEnableContinueButton() : Boolean {
        return mUpdatableSampleList.filter { it.isCheck }
            .filter { it.sectionNumber == 1 }
            .toList()
            .isNotEmpty()
    }

    fun getDashBoardMocks() : List<DashBoardContent> = mUpdatableSampleList

    fun updateItemSelectionState(dashBoardContent: DashBoardContent) {
        mUpdatableSampleList.forEach {
            if(dashBoardContent.sectionNumber == it.sectionNumber
                && dashBoardContent.name.equals(it.name, true)) {
                it.isCheck = dashBoardContent.isCheck
            }
        }
        shouldEnableContinueButton()
    }
}