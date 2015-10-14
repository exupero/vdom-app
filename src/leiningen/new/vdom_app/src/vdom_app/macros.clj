(ns {{name}}.macros)

(defmacro spy [x]
  `(let [x# ~x]
     (println '~x " => " x#)
     x#))
