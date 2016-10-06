(ns clojusc.shankha.util
  (:require [clojure.java.shell :as shell]
            [clojure.set :as set]
            [clojure.string :as string]))

(defn cd
  ""
  [dir]
  (System/setProperty "user.dir" dir))

(defn in?
  "This function returns true if the provided seqenuce contains the given
  elment."
  [seq elm]
  (some #(= elm %) seq))

(defn not-in?
  ""
  [sequence item]
  (not (in? sequence item)))

(defn get-output
  ""
  [result]
  (result :out))

(defn split-output
  ""
  [result]
  (string/split result #"\n"))

(defn get-ns-keywords
  ""
  [name-space]
  (-> name-space
      (ns-map)
      (keys)
      (set)))

(defn get-char-range
  ""
  [start stop]
  (->> (range start stop)
       (map (comp str char))
       (set)))

(defn check-arg
  "Let's support using keywords for flags."
  [arg]
  ;; For example, the following are equivalent:
  ;;   $ ls -alrth
  ;; and:
  ;;   => (ls "-alrth")
  ;; and:
  ;;   => (ls :alrth)
  (cond
    (keyword? arg) (str "-" (name arg))
    :else arg))

(defn check-args
  ""
  [args]
  (map check-arg args))
