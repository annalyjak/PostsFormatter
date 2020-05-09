# Posts Formatter
Simple spring boot app, which communicates with JSONPlaceholder to get all published posts and store it in separated json files.

## How to build/run project
Clone project (f.e. using git or download zip file at GitHub and extract it).
To run the application, run the following command in a terminal window (in the complete) directory:

```ruby
./gradlew bootRun
```

Now run the service with curl (in a separate terminal window), by running the following command (shown with its output):

```ruby
$ curl localhost:8080
Success
```

Or just call localhost:8080 at your browser/Postman.

Correct program json's you will find in created "data" project directory and print in terminal:

```ruby
Hello! This project will transform and store posts downloaded from JSONPlaceholder. Let's start...
URL : https://jsonplaceholder.typicode.com/posts
Response Code : 200
Number of downloaded posts : 100
Files created successful
Success
Bye!
```