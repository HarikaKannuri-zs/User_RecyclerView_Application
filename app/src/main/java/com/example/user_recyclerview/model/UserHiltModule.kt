package com.example.user_recyclerview.model

import android.content.Context
import androidx.room.Room
import com.example.user_recyclerview.model.local.UserDatabase
import com.example.user_recyclerview.model.local.userdata.UserDao
import com.example.user_recyclerview.model.local.userposts.PostDao
import com.example.user_recyclerview.model.remote.ApiService
import com.example.user_recyclerview.model.remote.RetrofitImplementation
import com.example.user_recyclerview.model.repository.PostRepository
import com.example.user_recyclerview.model.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserHiltModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context) : UserDatabase{
        return Room.databaseBuilder(context,UserDatabase::class.java,"user_database").build()
    }
    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase) : UserDao = userDatabase.userDao()
    @Provides
    @Singleton
    fun provideApiService() : ApiService = RetrofitImplementation().retroObj()
    @Provides
    @Singleton
    fun providePostDao(userDatabase: UserDatabase) : PostDao = userDatabase.postDao()
    @Provides
    @Singleton
    fun providePostRepository(apiService: ApiService , postDao: PostDao) : PostRepository = PostRepository(apiService,postDao)
    @Provides
    @Singleton
    fun provideUserRepository(userDao : UserDao) : UserRepository = UserRepository(userDao)

}