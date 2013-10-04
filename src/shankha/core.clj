(ns shankha.core
  (:require [clojure.java.shell :as shell])
  (:gen-class))


(defn sh
  [command & args]
  (print
    ((apply
       shell/sh
       (conj args command))
     :out)))

(defn -main
  ""
  [& args]
  (println "Wee!!!"))
