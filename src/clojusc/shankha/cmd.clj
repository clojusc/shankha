(ns clojusc.shankha.cmd
  (:require [clojure.java.shell :as shell]
            [clojure.string :as string]
            [clojusc.shankha.util :as util]))

(defn parse-args
  ""
  [args]
  )

(defn get-cmd
  ""
  [command args]
  (util/get-output
    (apply
      shell/sh
      (conj args command))))

(defn cmd
  "Run the given command, an executables available in $PATH."
  [command & args]
  (print
    (get-cmd command (or args []))))

(defn get-bi
  ""
  [command]
  (util/get-output
    (shell/sh "bash" :in command)))

(defn bi
  "Run the given shell built-in."
  [command & args]
  (let [command (string/join \space (conj args command))]
    (print
      (get-bi command))))

(defn get-all-commands []
  "Gets all executables available in $PATH."
  (sort
    (util/split-output
      (get-bi "compgen -c"))))

(defn get-all-builtins []
  "Get all bash builtins availale."
  (sort
    (util/split-output
      (get-bi "compgen -b"))))

(defn install-cmds
  [names & exclusions]
  (letfn [(placeholder [cmd-name]
            (fn [& args]
              (apply
                cmd
                (conj
                  (util/check-args args)
                  cmd-name))))]
    (doseq [cmd-name names
            :when (util/not-in? (first exclusions) cmd-name)]
      (intern
        *ns*
        (symbol cmd-name)
        (placeholder cmd-name)))))
