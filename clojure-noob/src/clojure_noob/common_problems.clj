(ns clojure_noob.common_problems)

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

(defn length
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
       (clojure.string/reverse coll)
       (reverse coll)) coll))

(defn my-flatten
  [coll]
  (filter (complement sequential?)
          (rest (tree-seq sequential? seq coll))))

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