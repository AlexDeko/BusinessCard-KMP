package ktor.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensionProvider
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ktor.HttpEngineFactory
import org.koin.dsl.module

internal val ktorModule = module {
    single<HttpClient> {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(DefaultRequest)

            install(ContentNegotiation) {
                register(ContentType.Text.Plain, KotlinxSerializationConverter( Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    prettyPrint = true
                }))
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                        prettyPrint = true
                    }
                )
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 15_000
                requestTimeoutMillis = 30_000
            }

            /*defaultRequest {
                header("Content-Type", "application/json; charset=UTF-8")
            }*/
        }
    }
}