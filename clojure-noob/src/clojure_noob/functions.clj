(ns clojure-noob.functions)

; Variadic functions
(defn sum [& args]
  (reduce + args))

; Multi-arity functions
(defn say-name
  ([] (say-name "Ivan"))
  ([name] (println name))
  ([name family-name] (println name family-name)))