(defproject clojusc/shankha "0.2.0-SNAPSHOT"
  :description "A Divine Shell"
  :url "https://github.com/clojusc/shankha"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :aot [clojusc.shankha]
  :main clojusc.shankha
  :repl-options
    {:welcome (println "\nWelcome to Shankha, a Clojure shell.\n")
     :init (clojusc.shankha/-main)
     :prompt (fn [ns]
               (let [light-green "\33[1;32m"
                     dark-green "\33[0;32m"
                     red "\33[0;31m"
                     blue "\33[1;34m"
                     dark-yellow "\33[0;33m"
                     end-color "\33[m"]
                 (str dark-green
                      (clojure.string/trim-newline
                        ((clojure.java.shell/sh "bash" :in "echo $USER") :out))
                      "@"
                      end-color
                      red
                      (clojure.string/trim-newline
                        ((clojure.java.shell/sh "hostname" "-s") :out))
                      end-color
                      " "
                      blue
                      ((clojure.java.shell/sh "pwd") :out)
                      end-color
                      blue
                      ns
                      end-color
                      dark-yellow
                      " => "
                      end-color)))}
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
