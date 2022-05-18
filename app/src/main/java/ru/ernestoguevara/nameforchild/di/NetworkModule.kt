package ru.ernestoguevara.nameforchild.di

import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ernestoguevara.nameforchild.data.DataConfig
import ru.ernestoguevara.nameforchild.data.repositories.remote.NamePopularApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DataConfig.NAME_POPULAR_PATH)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create()
    }

    @Provides
    fun provideNamePopularApi(retrofit: Retrofit) : NamePopularApi {
        return retrofit.create(NamePopularApi::class.java)
    }
}