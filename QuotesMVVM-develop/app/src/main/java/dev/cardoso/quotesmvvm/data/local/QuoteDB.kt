package dev.cardoso.quotesmvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.local.entities.QuoteEntity


@Database(entities = [QuoteEntity::class, ], version = 1)
abstract class QuoteDB : RoomDatabase() {
    abstract fun quoteDao(): QuoteDAO
}

/*
    abstract fun quoteDao(): QuoteDAO

    class Callback @Inject constructor(
    private val scope: CoroutineScope,
        private var INSTANCE: Provider<QuoteDB>
    //private val dataBase: Provider<QuoteDB>
    ) : RoomDatabase.Callback() {
        /**
         * Override the onCreate method to populate the database.
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //--- Si se desea conservar los datos mediante reinicios de la aplicación,
            //--- comentar las siguientes líneas.

            /*dataBase?.let {scope.launch(Dispatchers.IO){
                populate()
            } }*/

            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populate(database.get().quoteDao())

                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more elements
         */
        suspend fun populate(quoteDao: QuoteDAO) {

            quoteDao.deleteAll()

            val quote = QuoteEntity(
                id = 1,
                quote = "Solo se que no se nada",
                author = "Sócrates"
            )

            quoteDao.insert(quote)

        }
    }



}*/

//--------------------------------
/*
abstract fun quoteDao(): QuoteDAO

companion object {
    @Volatile
    private var INSTANCE: QuoteDB? = null

    fun getDatabase(
        context: Context,
        scope: CoroutineScope
    ): QuoteDB {
        //--- Ejecutar si la instancia no es nulo y devolver la instancia,
        //--- sino crear la base de datos
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                QuoteDB::class.java,
                "quotes.dbf"
            )
                //--- Limpia y reconstruye en lugar de migrar si no hay un objeto de migración
                //--- Aqui no se revisa el tema de migración
                .fallbackToDestructiveMigration()
                .addCallback(QuoteDBCallback(scope))
                .build()
            INSTANCE = instance
            //-- Devolver la instancia
            instance
        }
    }

    private class QuoteDBCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        /**
         * Override the onCreate method to populate the database.
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //--- Si se desea conservar los datos mediante reinicios de la aplicación,
            //--- comentar las siguientes líneas.
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populate(database.quoteDao())
                }
            }
        }
    }

    /**
     * Populate the database in a new coroutine.
     * If you want to start with more elements
     */
    suspend fun populate(quoteDao: QuoteDAO) {

        quoteDao.deleteAll()

        val quote = QuoteEntity(
            id = 1,
            quote = "Solo se que no se nada",
            author = "Sócrates"
        )

        quoteDao.insert(quote)

        }
    }
}*/



