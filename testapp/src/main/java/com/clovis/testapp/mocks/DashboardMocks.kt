package com.clovis.testapp.mocks


fun getDashBoardFakeData(): List<DashBoardContent> {

    val dashboardFakeData: MutableList<DashBoardContent> = mutableListOf()

    dashboardFakeData.add(
        DashBoardContent(
            "The Guests Have Reservations",
            ContentType.SECTION,
            1
        )
    )

    dashboardFakeData.add(DashBoardContent("john doe", ContentType.PERSON, 1))
    dashboardFakeData.add(DashBoardContent("Micheal Jordan", ContentType.PERSON, 2))

    dashboardFakeData.add(
        DashBoardContent(
            "The Guests need Reservations",
            ContentType.SECTION,
            2
        )
    )

    dashboardFakeData.add(DashBoardContent("Stanley Jobs",
        ContentType.PERSON,
        1,
        false)
    )

    dashboardFakeData.add(DashBoardContent("Guy Hustler", ContentType.PERSON, 2))
    dashboardFakeData.add(DashBoardContent("Zlatan Ibrahamovic", ContentType.PERSON, 2))
    dashboardFakeData.add(DashBoardContent("Steve Harvey", ContentType.PERSON, 2))
    dashboardFakeData.add(DashBoardContent("Cristiano Ronaldo", ContentType.PERSON, 2))
    dashboardFakeData.add(DashBoardContent("Leonel Messi",
        ContentType.PERSON,
        2,
          false
         )
    )
    dashboardFakeData.add(DashBoardContent("Steve Harvey", ContentType.PERSON, 2))
    dashboardFakeData.add(
        DashBoardContent(
            "At least one Guest in the party must have a reservation.Guests" +
                    "without reservations must remain in the same booking party in order toenter.",
            ContentType.FOOTER,
            3
        )
    )
    dashboardFakeData.add(DashBoardContent("Roger Federer", ContentType.PERSON, 2))
    dashboardFakeData.add(DashBoardContent("Junior Thomas", ContentType.PERSON, 2))


    return dashboardFakeData
}

private fun sortList(list: List<DashBoardContent>): List<DashBoardContent> {

    val sortedList: MutableList<DashBoardContent> = mutableListOf()

    // Sort to get a Sublist of the first section
    val firstSection = list.filter { it.sectionNumber == 1 }
        .sortedByDescending { it.contentType }
        .toList()

    // Sort to get a Sublist of the second section
    val secondSection = list.filter { it.sectionNumber == 2 }
        .sortedByDescending { it.contentType }
        .toList()

    // Sort to get a Sublist of the third section
    val thirdSection = list.filter { it.sectionNumber == 3 }
        .sortedByDescending { it.contentType }
        .toList()

    //Add all
    sortedList.addAll(firstSection)
    sortedList.addAll(secondSection)
    sortedList.addAll(thirdSection)

    return sortedList
}

data class DashBoardContent(
    val name: String = "No Name",
    val contentType: ContentType,
    val sectionNumber: Int,
    var isCheck : Boolean = false
)

enum class ContentType { PERSON, SECTION, FOOTER }