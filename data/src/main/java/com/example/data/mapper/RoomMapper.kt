package com.example.data.mapper

import com.example.data.model.RoomEntity
import com.example.domain.model.RoomData

fun RoomEntity.toDomain(): RoomData {
    return RoomData(id = id, name = name, age = age)
}

fun RoomData.toRoom(): RoomEntity {
    return RoomEntity(id = id, name = name, age = age)
}