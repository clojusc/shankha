# शंख Śaṇkha
[![Build Status][travis-badge]][travis]
[![Dependencies Status][deps-badge]][deps]
[![Clojars Project][clojars-badge]][clojars]
[![Clojure version][clojure-v]](project.clj)

*A Divine Shell*

[![][logo]][logo-large]

#### Contents

* [About](#about-)
* [Dependencies](#dependencies-)
* [Usage](#usage-)
* [Documentation](#documentation-)
* [License](#license-)


## About [&#x219F;](#contents)

Wouldn't it be nice to replace bash with a Clojure shell?


## Dependencies [&#x219F;](#contents)

TBD


## Usage [&#x219F;](#contents)

Start up the REPL:

```
$ lein repl
nREPL server started on port 33812 on host 127.0.0.1 - nrepl://127.0.0.1:33812
REPL-y 0.3.7, nREPL 0.2.12
Clojure 1.8.0
OpenJDK 64-Bit Server VM 1.8.0_45-internal-b14

Welcome to Shankha, a Clojure shell.

oubiwann@mndltl01 /home/oubiwann/lab/clojure/clojusc/shankha
clojusc.shankha =>
```

Next list all the files in reverse modified-time order with human-readable
sizes:

```clj
oubiwann@mndltl01 /home/oubiwann/lab/clojure/clojusc/shankha
clojusc.shankha => (ls :alrth)
```
```
total 80K
-rw-rw-r--  1 oubiwann oubiwann  128 Oct  5 09:38 .gitignore
drwxrwxr-x  2 oubiwann oubiwann 4.0K Oct  5 09:38 resources
drwxrwxr-x 13 oubiwann oubiwann 4.0K Oct  5 09:39 ..
-rw-rw-r--  1 oubiwann oubiwann  211 Oct  5 12:11 .travis.yml
drwxrwxr-x  3 oubiwann oubiwann 4.0K Oct  5 18:01 test
drwxrwxr-x  3 oubiwann oubiwann 4.0K Oct  5 18:01 src
-rw-rw-r--  1 oubiwann oubiwann 1.8K Oct  5 21:55 project.clj
-rw-rw-r--  1 oubiwann oubiwann   85 Oct  5 21:56 Makefile
-rw-rw-r--  1 oubiwann oubiwann  12K Oct  5 21:56 LICENSE
drwxrwxr-x  4 oubiwann oubiwann 4.0K Oct  5 21:56 dev-resources
drwxrwxr-x  8 oubiwann oubiwann 4.0K Oct  5 21:57 .git
-rw-rw-r--  1 oubiwann oubiwann 2.0K Oct  5 21:58 README.md
drwxrwxr-x  9 oubiwann oubiwann 4.0K Oct  5 21:58 .
nil
```

## Documentation [&#x219F;](#contents)

Meson API Reference docs are available here:
 * [http://clojusc.github.io/shankha/](http://clojusc.github.io/shankha/)


## License [&#x219F;](#contents)

Copyright © 2013, Duncan McGreggor

Copyright © 2016, Clojure-Aided Enrichment Center

Apache License, Version 2.0.

<!-- Named page links below: /-->
[travis]: https://travis-ci.org/clojusc/shankha
[travis-badge]: https://travis-ci.org/clojusc/shankha.png?branch=master
[deps]: http://jarkeeper.com/clojusc/shankha
[deps-badge]: http://jarkeeper.com/clojusc/shankha/status.svg
[tag-badge]: https://img.shields.io/github/tag/clojusc/shankha.svg?maxAge=2592000
[tag]: https://github.com/clojusc/shankha/tags
[clojure-v]: https://img.shields.io/badge/clojure-1.8.0-blue.svg
[clojars]: https://clojars.org/clojusc/shankha
[clojars-badge]: https://img.shields.io/clojars/v/clojusc/shankha.svg
[logo]: resources/shankha-lambda-2-x256.jpg
[logo-large]: resources/shankha-lambda-2-x2048.jpg
