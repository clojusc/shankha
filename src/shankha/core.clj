(ns shankha.core
  (:require [clojure.java.shell :as shell]
            [clojure.string :as string])
  (:gen-class))


(defn cmd
  "Executables available in $PATH."
  [command & args]
  (print
    ((apply
       shell/sh
       (conj args command))
     :out)))

(defn bi
  "Built-in available shell commands."
  [command & args]
  (let [command (string/join \space (conj args command))]
    (print
      ((shell/sh "bash" :in command) :out))))

(defn get-output [result]
  (sort
    (result :out)))

(defn split-output [result]
  (string/split (get-output result) #"\n"))

(defn get-commands []
  (split-output (bi "compgen -c")))

(defn get-builtins []
  (split-output (bi "compgen -b")))

(defn -main
  ""
  [& args]
  (println "Wee!!!"))