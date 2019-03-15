# browser-testing
Playing with selenium, java, docker and standalone selenium docker images

![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `! Prerequisites` 
- [x] [docker](https://docs.docker.com/engine/installation/)
- [x] [docker-compose](https://docs.docker.com/compose/)
- [x] Unix/Windows OS
- [ ] (optional) read [this blog](https://paulbrodner.github.io/2018/webbrowser-testing-using-standalone-docker-images/)
## Usage
a) git clone https://github.com/paulbrodner/headless-browser-testing
b) start Selenium Grid with Firefox in a docker container 
```ruby
$ cd headless-browser-testing
$ ./start-selenium.sh #this will run in the background the selenium grid
```
You can see the grid running in background
```ruby
$ docker ps
```
c) run the test
```ruby
$ mvn test
```
This will run the JUnit test that will
* open (remotely in the container) the Google page
* takes a screenshots and saves it in `target` folder
* assert the title of the page is correct
