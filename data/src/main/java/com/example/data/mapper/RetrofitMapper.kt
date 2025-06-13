package com.example.data.mapper

import com.example.data.model.RetrofitDto
import com.example.domain.repository.RetrofitData

fun RetrofitDto.toDomain(): RetrofitData =
    RetrofitData(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )


fun RetrofitData.toDto(): RetrofitDto =
    RetrofitDto(
        userId = this.userId,
        id = this.id,
        title = this.title,
        completed = this.completed
    )
