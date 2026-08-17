# Проект по автоматизации тестирования для [СВЯЗНОЙ](https://svyaznoy.instavktok.ru/)

UI-автотесты для демо-сайта Svyaznoy: главная страница, категории, поиск, избранное, сравнение и переход в маркетплейс.

## Стек технологий

- **Java 17**, **Gradle**, **JUnit 5**
- **Selenide** — UI-тесты
- **Allure** — отчёты
- **Selenoid** — удалённый запуск браузеров (опционально)

## Быстрый старт

### Требования

- JDK 17
- Google Chrome (для локального запуска)

### Локальный запуск

```bash
# Все тесты
./gradlew test

# Только smoke
./gradlew smoke_test
```

По умолчанию тесты идут **локально** в Chrome. Конфигурация — в `src/test/resources/config.properties`.

### Удалённый запуск через Selenoid

1. Скопируйте `config.properties.example` → `config.properties`
2. Укажите `remoteUrl` (не коммитьте файл с паролем):

```properties
remoteUrl=https://USER:PASSWORD@selenoid.autotests.cloud/wd/hub
```

Или передайте через переменную окружения:

```bash
set REMOTE_URL=https://USER:PASSWORD@selenoid.autotests.cloud/wd/hub
./gradlew smoke_test
```

### Allure-отчёт

```bash
./gradlew test allureReport
# Открыть: build/reports/allure-report/index.html
```

## Структура проекта

```
src/test/java/
  config/     — TestConfig, TestData
  helpers/    — Attach (скриншоты, видео, логи)
  pages/      — Page Object (HomePage)
  tests/      — TestBase, HomeTests
```

## Теги и Gradle-задачи

| Задача | Тег JUnit | Описание |
|--------|-----------|----------|
| `test` | все | Полный прогон |
| `smoke_test` | `smoke` | Smoke-набор |
| `regression_test` | `regression` | Регресс (добавляйте тесты с этим тегом) |

## CI

GitHub Actions workflow: `.github/workflows/tests.yml` — запускает `smoke_test` on push/PR.

Для удалённого прогона в CI добавьте секрет `REMOTE_URL` в настройках репозитория.

## Конфигурация

Приоритет настроек: `-DsystemProperty` → переменная окружения → `config.properties` → значения по умолчанию.

| Ключ | По умолчанию | Описание |
|------|--------------|----------|
| `baseUrl` | `https://svyaznoy.instavktok.ru/` | Базовый URL |
| `remoteUrl` | пусто | URL Selenoid (если пусто — локальный Chrome) |
| `browser` | `chrome` | Браузер |
| `browserSize` | `1920x1080` | Размер окна |
| `timeout` | `10000` | Таймаут Selenide, мс |
| `selenoidVideoUrl` | `https://selenoid.autotests.cloud/video/` | База URL для видео |

## Smoke-тесты

1. Элементы главной страницы
2. Навигация по категориям (параметризованный тест)
3. Поиск товара
4. Переход в маркетплейс
5. Добавление в избранное
6. Добавление в сравнение
