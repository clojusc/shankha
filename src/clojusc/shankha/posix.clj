(ns clojusc.shankha.posix
  (:import [jnr.posix JavaPOSIX POSIXFactory]))

(defn new []
  (-> (POSIXFactory.)
      (JavaPOSIX.)))

(defn cd
  ([dir]
    (cd (new) dir))
  ([posix dir]
    (.chdir posix)
    (System/setProperty "user.dir" dir)))
