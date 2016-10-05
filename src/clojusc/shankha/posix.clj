(ns clojusc.shankha.posix
  (:import [jnr.posix.POSIXFactory]))

(defn new-posix []
  (jnr.posix.POSIXFactory/getJavaPOSIX))

(defn cd
  ([dir]
    (cd (new-posix) dir))
  ([posix dir]
    (.chdir posix dir)
    (System/setProperty "user.dir" dir)))
