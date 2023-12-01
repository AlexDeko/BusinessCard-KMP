Business card Kotlin Multiplatform
==================

**Business card Kotlin Multiplatform** это проект для демонстрации kmp с использвонием Kotlin и Compose.
Оно соответствует лучшим практикам проектирования и разработки

# 🛠 Технический стек и библиотеки с открытым исходным кодом
- Таргеты:
  - iOS последние две версии
  - Android minSdk 28, он же Android 9.
- 100% [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization): Мультиплатформенная / многоформатная сериализация без отражения на Kotlin.
- [ksp](https://github.com/google/ksp): API обработки символов Kotlin.
- [SQLDelight](https://github.com/cashapp/sqldelight): генерирует типизированные API-интерфейсы Kotlin из ваших инструкций SQL. Имеет проверки во время компиляции и поддержку мультиплатформы.
- Baseline Profiles: Повышает производительность Android приложения через включение в APK-файл список спецификаций классов и методов, которые могут использоваться Android Runtime.
- TODO("Скоро здесь появятся ещё библиотеки")

# Среда разработки

Используйте плагин для Андроид студии
[Kotlin Multiplatform Mobile]([https://developer.android.com/series/now-in-android](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)). 

Измените конфигурацию запуска для переключения между таргетами iOS и Android.

# Правила работы в проекте

Придерживаемя минимальных требований работы с Git.
1) Не пушим правки напрямую в master
2) Отпачковываем ветки от develop
3) Мерджим в дев через Pull Request в GitHub
4) Перед мерджем в develop запускаем вливаему ветку на всех таргетах
5) Делаем Pull request в master, создавая релизную ветку от develop, когда будет промежуточный стабильный результат
