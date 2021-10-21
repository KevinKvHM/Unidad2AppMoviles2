package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    //private val quoteDAO: QuoteDAO,
    private val quoteRepository: QuoteRepositoryImpl) {

    //private val quoteRepository = QuoteRepositoryImpl(quoteDAO)

    suspend fun getQuotes(): Flow<List<QuoteModel>> = quoteRepository.getQuotes()

}