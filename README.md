# CSV to JSON Converter (Spring Boot)

## Description

This Spring Boot project is a RESTful API that takes a CSV file as input and converts it into JSON format. It reads the CSV data and generates a JSON object for each row in the CSV file. This project is designed to provide a simple and efficient way to perform this conversion.

## Features

- Converts CSV data to JSON format.
- Supports large CSV files with efficient memory management.
- Provides a user-friendly RESTful API.
- Easily deployable as a Spring Boot application.

## Getting Started

### Prerequisites

- Java 8 or higher
- Apache Maven
- A CSV file to convert

### Installation

1. Clone the repository to your local machine:

   ```bash
   git clone [repository_url]
   ```

2. Navigate to the project directory:

   ```bash
   cd csv-to-json-converter-spring
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:

   ```bash
   java -jar target/csv-to-json-converter-spring-1.0.0.jar
   ```

### Usage

1. Ensure that the Spring Boot application is running.

2. Use a REST client (e.g., Postman or cURL) to send a POST request to the following endpoint to perform the conversion:

   ```
   POST http://localhost:8080/convert
   ```

   Include your CSV file as a multipart/form-data file in the request.

3. The response will contain the converted JSON data.

### CSV Input Format

The input CSV file should have a header row with column names and one or more data rows. Each column should have a unique name.

Example CSV file:

```csv
Name,Address,Age
John,New York USA,27
Alice,Los Angeles USA,34
```

### JSON Output Format

The converter will generate a JSON object for each row in the CSV file. Each object will have a unique key (numeric index starting from 1) and contain the data as key-value pairs.

Example JSON output:

```json
{
  "1": {
    "Name": "John",
    "Address": "New York USA",
    "Age": 27
  },
  "2": {
    "Name": "Alice",
    "Address": "Los Angeles USA",
    "Age": 34
  }
}
```

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your fork.
5. Create a pull request to the original repository.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions or need assistance, please contact [Your Name] at [your@email.com].
```

Remember to replace `[repository_url]`, `[Your Name]`, and `[your@email.com]` with the actual details for your project. This README file provides basic information about the Spring Boot project, how to use it, and how to contribute. You can add more details or sections as needed.
