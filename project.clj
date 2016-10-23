(defproject clojusc/shankha "0.2.0-SNAPSHOT"
  :description "A Divine Shell"
  :url "https://github.com/clojusc/shankha"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.github.jnr/jnr-posix "3.0.31"]]
  :aot [clojusc.shankha]
  :main clojusc.shankha
  :repl-options
    {:welcome (println "\nWelcome to Shankha, a Clojure shell.\n")
     :init (clojusc.shankha/-main)
     :prompt clojusc.shankha/-main}
  :profiles {
    :uber {
      :aot :all}
    :test {
      :plugins [
        [jonase/eastwood "0.2.3" :exclusions [org.clojure/clojure]]
        [lein-kibit "0.1.2" :exclusions [org.clojure/clojure]]]
      :test-selectors {
      :default :unit
      :unit :unit
      :system :system
      :integration :integration}}
    :dev {
      :dependencies [[org.clojure/tools.namespace "0.2.11"]]
      :source-paths ["dev-resources/src"]}})
