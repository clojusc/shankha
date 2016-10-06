(ns clojusc.shankha.posix
  (:require [clojusc.shankha.util :as util])
  (:import [jnr.posix.POSIXFactory]))

(defn new-posix []
  (jnr.posix.POSIXFactory/getNativePOSIX))

(defn cd
  ([dir]
    (->> dir
         (util/get-abs-path)
         (cd (new-posix))))
  ([posix dir]
    (.chdir posix dir)
    (System/setProperty "user.dir" dir)))
