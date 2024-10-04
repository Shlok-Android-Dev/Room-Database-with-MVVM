package com.example.shayariappmvvmarchitecture.domain

import com.example.shayariappmvvmarchitecture.data.DataEntity
import java.util.ArrayList
import java.util.Date
import java.util.GregorianCalendar

object SampleData {

    fun getDate(diff: Int):Date{

        val calendar = GregorianCalendar()
        calendar.add(calendar.minimalDaysInFirstWeek, diff)

        return calendar.time

    }

    /*val data:List<DataEntity>
        get() {
            val tempList: MutableList<DataEntity> = ArrayList()
            tempList.add(DataEntity(1, getDate(44), "Sample 1","SAyari 1"))
            tempList.add(DataEntity(2, getDate(43), "Sample 2","Sayari 2"))

            return tempList
        }*/
}