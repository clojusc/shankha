(defproject shankha "0.1.0-SNAPSHOT"
  :description "A Divine Shell"
  :url "https://github.com/oubiwann/shankha"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.sun.jna/jna "3.0.9"]
                 [org.jruby.ext.posix/jna-posix "1.0.3"]]
  :aot [shankha.core]
  :main shankha.core
  :repl-options
    {:welcome (println "Welcome to Shankha, a Clojure shell.")
     :init (shankha.core/-main)
     :prompt (fn [ns]
               (let [light-green "\33[1;32;40m"
                     dark-green "\33[0;32;40m"
                     red "\33[0;31;40m"
                     blue "\33[1;34;40m"
                     dark-yellow "\33[0;33;40m"
                     end-color "\33[m"]
                 (str light-green
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
                      dark-green
                      (clojure.string/trim-newline
                        ((clojure.java.shell/sh "date" "+%a %d %b %H:%M:%S ") :out))
                      end-color
                      blue
                      "(" ns ")"
                      end-color
                      dark-yellow
                      " => "
                      end-color)))}
  :profiles
    {:testing
      {:dependencies [[ring-mock "0.1.5"]
                      [clj-http-fake "0.4.1"]
                      [midje "1.5.1"]]}})
