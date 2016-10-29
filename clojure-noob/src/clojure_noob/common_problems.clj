(ns clojure_noob.common_problems
  (:require [clojure.set :as set]))

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(def fibonacci
  (memoize
    (fn [n]
      (if (< n 2)
        n
        (+' (fibonacci (dec n)) (fibonacci (- n 2)))))))

(defn fibonacci-seq []
  (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))

(defn divisable-of? [n]
  (fn [divisor] (zero? (rem n divisor))))

(defn prime? [n]
  (not-any? (divisable-of? n) (range 2 (inc (int (Math/sqrt n))))))

(defn length [lst]
  (loop [i lst cnt 0]
    (if (empty? i)
      cnt
      (recur (rest i) (inc cnt)))))

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
       (clojure.string/reverse coll)
       (reverse coll)) coll))

(defn my-flatten
  [coll]
  (remove sequential? (rest (tree-seq sequential? seq coll))))

(defn filter-caps-chars [chrs]
  (clojure.string/join (filter (fn [x] (Character/isUpperCase x)) chrs)))

(defn compress [coll]
  (if (string? coll)
    (clojure.string/join (dedupe coll))
    (dedupe coll)))

(defn seq-pack [coll]
  (partition-by identity coll))

(defn seq-duplicate [coll]
  (reduce #(conj %1 %2 %2) [] coll))

(defn seq-replicate [coll n-times]
  (reduce (fn [prev curr] (concat prev (repeat n-times curr))) [] coll))

(defn my-range [start end]
  (loop [i start acc []]
    (if (< i end)
      (recur (inc i) (conj acc i)) acc)))

(defn my-max-key [& args]
  (last (sort args)))

(defn my-interpose [sep coll]
  (rest (mapcat #(vector sep %) coll)))

(defn drop-every-nth-element [coll el]
  (apply concat (partition-all (dec el) el coll)))

(defn reverse-interleave [seq el]
  (apply map list (partition el seq)))

(defn rotate [offset coll]
  (let [coll-size (count coll)]
    (take coll-size (drop (mod offset coll-size) (cycle coll)))))

(defn split-a-sequence [split-point seq]
  (vector (take split-point seq) (drop split-point seq)))

(defn split-a-sequence-alternative [split-point seq]
  (let [splited (partition-all split-point seq)]
    (vector (first splited) (apply concat (rest splited)))))

(defn split-by-type [seq]
  (vals (group-by type seq)))

(defn count-occurances [coll]
  (into {} (map #(vector (key %) (count (val %))) (group-by identity coll))))

(defn my-distinct [coll]
  (sort-by #(.indexOf coll %)
           (keys (group-by identity coll))))

(defn gdc [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn primes [n]
  (take n (filter #(.isProbablePrime (BigInteger/valueOf %) 5) (iterate inc 2))))

(defn primes-alternative [n]
  (take n (filter prime? (iterate inc 2))))

(defn set-intersection [set-a set-b]
  (set (filter #(set-a %) set-b)))

(defn re-iterate [func initial]
  (cons initial (lazy-seq (re-iterate func (func initial)))))

(fn [op a b]
  (cond
    (op a b) :lt
    (op b a) :gt
    :else :eq))

(defn split-and-sort [x]
  (sort String/CASE_INSENSITIVE_ORDER (clojure.string/split x #"\W")))

(defn map-defaults [def-val coll]
  (into {} (map #(vector % def-val) coll)))

(defn map-with-indexes [coll]
  (map-indexed #(vector %2 %1) coll))

(defn pow [x]
  (fn [n]
    (reduce * (repeat x n))))

(defn cartesian-product [x s]
  (set (for [a x b s] [a b])))

(defn product-digits [a b]
  (map #(Character/digit % 10) (seq (str (* a b)))))

; alternativly concat also works instead of set/union
(defn symetric-difference [a b]
  (set (remove #(and (a %) (b %)) (set/union a b))))

(defn dot-product [a b]
  (reduce + (map * a b)))

(defn to-decimal [s]
  (Integer/parseInt s 2))

(defn infix-calc [first & rest]
  (reduce (fn [a [op b]] (op a b)) first (partition 2 rest)))

(defn only-perfect-squares [s]
  (let [parsedInts (map #(Integer/parseInt %) (.split s ","))
        perfect-square? (fn [i]
                          (let [sqr (Math/sqrt i)]
                            (= (Math/floor sqr) sqr)))]
    (clojure.string/join \, (filter perfect-square? parsedInts))))

(defn sum-of-square-digits [coll]
  (let [smaller-than-digits-squared?
        (fn [d] (let [digits (map #(Character/getNumericValue %) (String/valueOf d))]
                  (< d (reduce + (map #(* % %) digits)))))]
    (count (filter smaller-than-digits-squared? coll))))

(defn juxtaposition [& funcs]
  (fn [& args]
    (map #(apply % args) funcs)))

(defn my-map [f coll]
  (if (not-empty coll)
    (lazy-seq (cons (f (first coll)) (my-map f (rest coll))))))

(defn pascal-triangle [n]
  (nth
    (iterate
      #(vec (map + (concat % [0]) (concat [0] %))) [1]) (dec n)))

(defn recoginze-playing-cards [str]
  (let [suits {\H :heart \C :club \D :diamond \S :spades}
        ranks {\2 0, \3 1, \4 2, \5 3, \6 4, \7 5,
               \8 6, \9 7, \T 8, \J 9, \Q 10, \K 11, \A 12}]
    {:suit (suits (first str)) :rank (ranks (last str))}))