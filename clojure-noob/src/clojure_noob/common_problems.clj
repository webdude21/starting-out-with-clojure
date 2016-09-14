(ns clojure_noob.common_problems)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(defn fibonacci [n]
  (take n
    (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))