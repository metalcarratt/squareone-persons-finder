# Set up test data
# Lat = 1, long = 2
curl --location --request PUT 'localhost:8080/api/v1/persons/1/location' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1.009, long = 2
# Should return `[1]` (found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.009&longitude=2.0&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1.010, long = 2
# Should return `[]` (not found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.010&longitude=2.0&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1, long = 2.009
# Should return `[1]` (found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.00&longitude=2.009&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1, long = 2.010
# Should return `[]` (not found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.00&longitude=2.010&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1.007, long = 2.007
# Should return `[]` (not found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.007&longitude=2.007&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'

# lat = 1.006, long = 2.006
# Should return `[1]` (found)
curl --location --request GET 'localhost:8080/api/v1/persons/location?latitude=1.006&longitude=2.006&distance=1.0' \
--header 'Content-Type: application/json' \
--data '{
    "latitude": 1.0,
    "longitude": 2.0
}'