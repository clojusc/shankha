(ns shankha.core
  (:require [clojure.java.shell :as shell]
            [clojure.set :as set]
            [clojure.string :as string])
  (:gen-class))


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

(defn parse-args
  ""
  [args]
  )

(defn cmd
  "Run the given command, an executables available in $PATH."
  [command & args]
  (print
    (get-output
      (apply
        shell/sh
        (conj args command)))))

(defn get-bi
  ""
  [command]
  (get-output
    (shell/sh "bash" :in command)))

(defn bi
  "Run the given shell built-in."
  [command & args]
  (let [command (string/join \space (conj args command))]
    (print
      (get-bi command))))

(defn split-output [result]
  (string/split result #"\n"))

(defn get-commands []
  "Gets all executables available in $PATH."
  (sort
    (split-output
      (get-bi "compgen -c"))))

(defn get-builtins []
  "Get all bash builtins availale."
  (sort
    (split-output
      (get-bi "compgen -b"))))

(defn install-cmds
  [names & exclusions]
  (letfn [(placeholder [cmd-name]
            (fn [& args]
              (apply cmd (conj args cmd-name))))]
    (doseq [cmd-name names
            :when (not-in? (first exclusions) cmd-name)]
      (intern
        *ns*
        (symbol cmd-name)
        (placeholder cmd-name)))))

(defn get-ns-keywords
  ""
  [name-space]
  (into
    #{}
    (keys
      (ns-map name-space))))

(defn get-excludes
  ""
  []
  (map
    str
    (set/union
      (get-ns-keywords *ns*)
      (get-ns-keywords 'clojure.core)
      (get-ns-keywords 'clojure.repl))))

(defn -main
  ""
  [& args]
  (install-cmds (get-commands) (get-excludes)))
  ;(install-cmds ["ls" "dir" "touch" "mkdir"]))