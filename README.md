# Rijksmuseum API Java Client

A Java 21-based small test framework [Rijksmuseum Collection API](https://data.rijksmuseum.nl/docs/api/collection), using OkHttp for HTTP requests and Jackson for JSON (de)serialization. Includes JUnit 5 with Allure reporting and a GitHub Actions CI workflow.

---

## 🛠️ Tech Stack

- Java 21
- Maven
- OkHttp
- Jackson
- SLF4J + Logback
- JUnit 5
- Allure Reporting
- GitHub Actions CI

---

## ✅ Prerequisites

Before you run this project, make sure you have:

- **Java 21** installed
- **Maven 3** installed (`mvn -v` should show version 3.8 or higher)


- **Allure CLI** installed for local report generation (optional)

  -or-
- **IntelliJ IDEA** or other IDE (Maven will pick up an Allure plugin)
  ```bash
  brew install allure   # macOS
  scoop install allure  # Windows (Scoop)

---

## 🔐 API Key
This project uses the [Rijksmuseum legacy API](https://data.rijksmuseum.nl/object-metadata/api/) which requires an API key.

### 🔑 Set up the API Key
Get your API key from [Rijksmuseum API registration](https://data.rijksmuseum.nl/object-metadata/api/).

```export RIJKSMUSEUM_API_KEY=your_api_key_here```

-or- add it to Windows environment variables (shell restart required)

-or- add it to your IDE's run configuration.

---

## 🚀 Run the Project

1. Building the project

`mvn clean compile exec:java`

2. Running the tests

`mvn clean test
`

3. Generate the report

When running from IDE, run the maven plugin `allure:serve` goal

When running locally, make sure Allure executable is in PATH, then

```
mvn allure:report
allure serve target/allure-results
```

Alternatively, check the GitHub actions tab

---

## 📋 License
This project is open source and free to use under the MIT License. Enjoy!