(ns clojusc.shankha.prompt
  (:require [clojure.java.shell :as shell]
            [clojure.string :as string]
            [clojusc.shankha.util :as util]))

(def light-green "\33[1;32m")
(def dark-green "\33[0;32m")
(def red "\33[0;31m")
(def blue "\33[1;34m")
(def dark-yellow "\33[0;33m")
(def lambda-char "\u03bb")

(defn start-color
  ""
  [color-name]
  (case color-name
    :light-green light-green
    :dark-green dark-green
    :red red
    :blue blue
    :dark-yellow dark-yellow))

(defn end-color
  ""
  []
  "\33[m")

(defn wrap-color
  ""
  [color-name & text]
  (str
    (start-color color-name)
    (reduce str text)
    (end-color)))

(defn get-prompt
  ""
  [ns]
  (str (wrap-color
         :dark-green
         (string/trim-newline ((shell/sh "bash" :in "echo $USER") :out))
         "@")
       (wrap-color
         :red
         (string/trim-newline ((shell/sh "hostname" "-s") :out)))
       " "
       (wrap-color :blue (util/get-cwd))
       "\n"
       (wrap-color :blue ns)
       (wrap-color :dark-yellow " " lambda-char ">")
       " "))

