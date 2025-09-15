package com.example.data.repositoryImpl.api

import com.example.data.api.UserApi
import com.example.domain.repository.api.AccountApiRepository
import javax.inject.Inject

class AccountApiRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : AccountApiRepository {

}