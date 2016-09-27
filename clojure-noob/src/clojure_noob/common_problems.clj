(ns clojure_noob.common_problems)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(def fibonacci
  (memoize
    (fn [n]
      (if (< n 2)
        n
        (+' (fibonacci (dec n)) (fibonacci (- n 2)))))))

(defn divisable-of? [n]
  (fn [divisor] (zero? (rem n divisor))))

(defn prime? [n]
  (not-any? (divisable-of? n) (range 2 (inc (int (Math/sqrt n))))))

(defn length
  "Returns the length of any sequence (strings, maps, sets, vectors, lists) are all welcome"
  [lst]
  (loop [i lst cnt 0]
    (cond (empty? i) cnt
          :t (recur (rest i) (inc cnt)))))

(defn my-reverse
  [coll]
  (if (empty? coll)
    []
    (conj (my-reverse (rest coll)) (first coll))))

(defn fibonacci-range
  [n]
  (take n (map first (iterate (fn [[a b]] [b (+' a b)]) [1 1]))))

(defn palindrome?
  [coll]
  (= (if (string? coll)
       (apply str (reverse coll))
       (reverse coll)) coll))

(defn my-flatten
  [coll]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq coll))))