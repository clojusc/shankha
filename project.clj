(defproject shankha "0.1.0-SNAPSHOT"
  :description "A Divine Shell"
  :url "https://github.com/oubiwann/shankha"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :main shankha.core
  :profiles
  {:testing
    {:dependencies [[ring-mock "0.1.5"]
                    [clj-http-fake "0.4.1"]
                    [midje "1.5.1"]]}})
