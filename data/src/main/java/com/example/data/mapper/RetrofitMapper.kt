package com.example.data.mapper

import com.example.data.model.RetrofitDataDto
import com.example.domain.repository.RetrofitData

fun RetrofitDataDto.toDomain(): RetrofitData {
    return RetrofitData(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )
}

fun RetrofitData.toDto(): RetrofitDataDto {
    return RetrofitDataDto(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )
}