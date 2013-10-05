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

(defn- clojurize
  [s]
  (->> s
       (map #(if (Character/isUpperCase %) (str "-" %) %))
       (apply str)
       lower-case))

(defn- fn-impls
  "Returns a list of function implementations corresponding to all
methods and their arities on klass, excluding any methods in
exclude-names."
  [exclude-names klass]
  (for [[name arities] (names-arities (methods-in klass))
        :when (not (exclude-names name))]
    (let [args (map #(vec (take % (repeatedly gensym))) arities)
          clj-name (clojurize name)]
      `(defn ~(symbol clj-name)
         ~@(map (fn [argv] (list argv (list* '. klass (symbol name) argv)))
                args)))))

(defn- install-fns
  "Generates proxy functions for klass and installs them in this namespace."
  [klass]
  (eval (cons 'do (fn-impls exclusions klass))))

(defn -main
  ""
  [& args]
  (println "Wee!!!"))