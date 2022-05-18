package com.ejemplito.mercaaqui

import org.json.JSONArray

import org.json.JSONException




class ArrayUtil {
    fun convert(jArr: JSONArray): ArrayList<Any>? {
        val list = ArrayList<Any>()
        try {
            var i = 0
            val l = jArr.length()
            while (i < l) {
                list.add(jArr[i])
                i++
            }
        } catch (e: JSONException) {
        }
        return list
    }

    fun convert(list: Collection<Any?>?): JSONArray? {
        return JSONArray(list)
    }
}