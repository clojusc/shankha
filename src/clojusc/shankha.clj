(ns clojusc.shankha
  (:require [clojure.java.shell :as shell]
            [clojure.set :as set]
            [clojusc.shankha.cmd :as cmd]
            [clojusc.shankha.posix :as posix]
            [clojusc.shankha.util :as util])
  (:gen-class))

(defn install-custom
  ""
  []
  (intern
    *ns*
    (symbol "cd")
    posix/cd))

(defn get-excludes
  ""
  []
  (map
    str
    (set/union
      (util/get-char-range 0 65)
      (util/get-char-range (+ 65 26) 97)
      (util/get-ns-keywords *ns*)
      (util/get-ns-keywords 'clojure.core)
      (util/get-ns-keywords 'clojure.repl))))

(defn -main
  ""
  [& args]
  ;(install-cmds (get-all-commands) (get-excludes)))
  (cmd/install-cmds ["pwd" "cd" "ls" "dir" "touch" "mkdir"] ["dir"])
  #_(let [excludes (get-excludes)]
    (doseq [command (cmd/get-all-commands)]
      (println (str "Installing '" command "' ..."))
      (cmd/install-cmds [command] excludes)))
  (install-custom))
