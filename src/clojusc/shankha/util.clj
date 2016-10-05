(ns clojusc.shankha.util
  (:require [clojure.java.shell :as shell]
            [clojure.set :as set]
            [clojure.string :as string]))

(defn cd [dir]
  (System/setProperty "user.dir" dir))

(defn in?
  "Given a sequence and a potential element of that sequence, determine if it
  is, in fact, part of that sequence."
  [sequence item]
  (if (empty? sequence)
    false
    (reduce
      #(or %1 %2)
      (map
        #(= %1 item)
        sequence))))

(defn not-in?
  ""
  [sequence item]
  (not (in? sequence item)))

(defn get-output [result]
  (result :out))

(defn split-output [result]
  (string/split result #"\n"))

(defn get-ns-keywords
  ""
  [name-space]
  (into
    #{}
    (keys
      (ns-map name-space))))

(defn get-char-range
  ""
  [start stop]
  (into
    #{}
    (map
      (comp str char)
      (range start stop))))

(defn check-arg [arg]
  "Let's support using keywords for flags."
  ;; For example, the following are equivalent:
  ;;   $ ls -alrth
  ;; and:
  ;;   => (ls "-alrth")
  ;; and:
  ;;   => (ls :alrth)
  (cond
    (keyword? arg) (str "-" (name arg))
    :else arg))

(defn check-args [args]
  (map check-arg args))
