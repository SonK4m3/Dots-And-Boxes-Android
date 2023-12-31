package com.mobile.g5.dotsnboxes.di

import com.mobile.g5.dotsnboxes.data.KtorRealtimeMessagingClient
import com.mobile.g5.dotsnboxes.data.RealtimeMessagingClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.websocket.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets)
        }
    }

   @Singleton
   @Provides
    fun provideRealtimeMessagingClient(httpClient: HttpClient): RealtimeMessagingClient {
        return KtorRealtimeMessagingClient(httpClient)
    }
}