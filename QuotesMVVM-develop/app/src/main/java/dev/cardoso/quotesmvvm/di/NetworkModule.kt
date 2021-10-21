package dev.cardoso.quotesmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.core.BASE_URL
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import dev.cardoso.quotesmvvm.data.local.QuoteLocalDataSource
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.remote.QuoteApi
import dev.cardoso.quotesmvvm.data.remote.QuoteRemoteDataSource
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

@Singleton
@Provides
fun providerRetrofit():Retrofit{
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
   /* @Singleton
    @Provides
    fun providerQuoteRepository(retrofit: Retrofit):QuoteRepository{
        return retrofit.create(QuoteRepository::class.java)
    }*/

    @Singleton
    @Provides
    fun providerQuoteApi(retrofit: Retrofit):QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }
    /*
    @Singleton
    @Provides
    fun providerDAO(retrofit: Retrofit): QuoteDAO{
        return retrofit.create(QuoteDAO::class.java)
    }
    @Singleton
    @Provides
    fun providerQuoteLocalDataSource(retrofit: Retrofit): QuoteLocalDataSource {
        return retrofit.create(QuoteLocalDataSource::class.java)
    }

    @Singleton
    @Provides
    fun providerQuoteRemoteDataSourceImpl(retrofit: Retrofit): QuoteRemoteDataSource {
        return retrofit.create(QuoteRemoteDataSource::class.java)
    }
    @Singleton
    /*@Provides
    fun provideDataBase(app:Application,
        callback: QuoteDB.Callback
                        )=Room.databaseBuilder(
        app,QuoteDB::class.java,"quotes.dbf"
    ).fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()*/
    @Provides
    fun provideQuoteDB(db: QuoteDB)=db.quoteDao()

    @ApplicationScope
    @Provides
    @Singleton

    fun providesApplicationScope()= CoroutineScope(SupervisorJob())

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope*/
}