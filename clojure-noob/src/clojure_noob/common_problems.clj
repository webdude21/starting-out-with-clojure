(ns clojure_noob.common_problems)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(def fibonacci
  (memoize
    (fn [n]
      (if (< n 2)
        n
        (+' (fibonacci (dec n)) (fibonacci (- n 2)))))))

(defn divisableOf? [n]
  (fn [divisor] (= (rem n divisor) 0)))

(defn prime? [n]
  (not-any? (divisableOf? n) (range 2 (inc (int (Math/sqrt n))))))