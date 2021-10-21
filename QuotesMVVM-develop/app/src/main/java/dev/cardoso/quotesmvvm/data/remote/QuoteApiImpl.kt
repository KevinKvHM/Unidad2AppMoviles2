package dev.cardoso.quotesmvvm.data.remote

import dev.cardoso.quotesmvvm.core.RetrofitHelper
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import javax.inject.Inject

class QuoteApiImpl @Inject constructor(
    private val apiService: QuoteApi
    ){
    //private val apiService: QuoteApi = RetrofitHelper.getRetrofit().create(QuoteApi::class.java)
    //override suspend fun getQuotes(): Response<List<QuoteModel>> {
    suspend fun getQuotes(): Response<List<QuoteModel>>{
        return apiService.getQuotes()
    }
}