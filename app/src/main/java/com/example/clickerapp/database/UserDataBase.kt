package com.example.clickerapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clickerapp.model.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

/*
@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
public abstract class UserDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.userDao())
                }
            }
        }

        suspend fun populateDatabase(userDao: UserDao) {
            // Delete all content here.
            */
/*orderDao.deleteAll()

            // Add sample words.
            var word = Order("ffff", "ffff", 2, 2)
            orderDao.insert(word)
            word = Order("ffff", "ffff", 2, 2)
            orderDao.insert(word)*//*


            // TODO: Add your own words!
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_database"
                )
                    .addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}*/
