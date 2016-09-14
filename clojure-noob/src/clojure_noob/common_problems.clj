(ns clojure_noob.common_problems)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn fibonacci [n]
  (if (< n 2) n
    (+ (fibonacci (dec n)) (fibonacci(- n 2)))))