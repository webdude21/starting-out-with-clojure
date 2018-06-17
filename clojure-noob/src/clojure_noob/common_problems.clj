(ns clojure_noob.common_problems
  (:require [clojure.set :as set]
            [clojure.string :as str]))

(defn merge-parts [left right]
  (loop [left-ind 0 right-ind 0 result []]
    (if (>= (count result) (+ (count left) (count right)))
      result
      (let [left-in-bounds (< left-ind (count left))
            right-in-bounds (< right-ind (count right))]
        (if (and left-in-bounds right-in-bounds)
          (if (< (compare (left left-ind) (right right-ind)) 0)
            (recur (inc left-ind) right-ind (conj result (left left-ind)))
            (recur left-ind (inc right-ind) (conj result (right right-ind))))
          (if left-in-bounds
            (recur (inc left-ind) right-ind (conj result (left left-ind)))
            (recur left-ind (inc right-ind) (conj result (right right-ind)))
            ))))))

(defn merge-sort [coll]
  (if (<= (count coll) 1)
    coll
    (let [end (count coll)
          mid (/ end 2)
          left (merge-sort (subvec coll 0 mid))
          right (merge-sort (subvec coll mid))]
      (merge-parts left right))))

(defn factorial [n]
  (reduce * (range 1 (inc n))))

(def fibonacci
  (memoize
    (fn [n]
      (if (< n 2)
        n
        (+' (fibonacci (dec n)) (fibonacci (- n 2)))))))

(defn fizz-buzz []
  (let [fizzes (cycle ["" "" "fizz"])
        buzzes (cycle ["" "" "" "" "buzz"])]
    (map str fizzes buzzes)))

(defn fibonacci-seq []
  (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))

(defn factorial-loop-recur [n]
  (loop [i 1 res 1]
    (if (> i n)
      res
      (recur (inc i) (* res i)))))

(defn divisible-of? [n]
  (fn [divisor] (zero? (rem n divisor))))

(defn prime? [n]
  (not-any? (divisible-of? n) (range 2 (inc (int (Math/sqrt n))))))

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
       (str/reverse coll)
       (reverse coll)) coll))

(defn my-flatten
  [coll]
  (remove sequential? (rest (tree-seq sequential? seq coll))))

(defn filter-caps-chars [chrs]
  (apply str (filter (fn [x] (Character/isUpperCase x)) chrs)))

(defn compress [coll]
  (if (string? coll)
    (apply str (dedupe coll))
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
  (rest (mapcat (partial vector sep) coll)))

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
  (let [partitions (partition-all split-point seq)]
    (vector (first partitions) (apply concat (rest partitions)))))

(defn split-by-type [seq]
  (vals (group-by type seq)))

(defn count-occurrences [coll]
  (into {} (map #(vector (key %) (count (val %))) (group-by identity coll))))

(defn my-distinct [coll]
  (sort-by #(.indexOf coll %)
           (keys (group-by identity coll))))

(defn gcd [a b]
  (if (zero? b) a (recur b (mod a b))))

(defn lazy-primes []
  (iterate #(.nextProbablePrime (BigInteger/valueOf %)) 2))

(defn primes [n]
  (take n (lazy-primes)))

(defn primes-alternative [n]
  (take n (filter prime? (iterate inc 2))))

(defn set-intersection [set-a set-b]
  (set (filter set-a set-b)))

(defn re-iterate [func initial]
  (cons initial (lazy-seq (re-iterate func (func initial)))))

(fn [op a b]
  (cond
    (op a b) :lt
    (op b a) :gt
    :else :eq))

(defn split-and-sort [x]
  (sort String/CASE_INSENSITIVE_ORDER (str/split x #"\W")))

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

; alternatively concat also works instead of set/union
(defn symetric-difference [a b]
  (set (remove #(and (a %) (b %)) (set/union a b))))

(defn dot-product [a b]
  (reduce + (map * a b)))

(defn to-decimal [s]
  (Integer/parseInt s 2))

(defn infix-calc [first & rest]
  (reduce (fn [a [op b]] (op a b)) first (partition 2 rest)))

(defn only-perfect-squares [s]
  (let [parsedInts (map #(Integer/parseInt %) (.split s \,))
        perfect-square? (fn [i]
                          (let [sqr (Math/sqrt i)]
                            (= (Math/floor sqr) sqr)))]
    (str/join \, (filter perfect-square? parsedInts))))

(defn sum-of-square-digits [coll]
  (letfn [(smaller-than-digits-squared? [d]
            (let [digits (map #(Character/getNumericValue %) (String/valueOf d))]
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

(defn anagram-finder [coll]
  (->> coll
       (group-by sort)
       (map val)
       (remove #(<= (count %) 1))
       (map set)
       set))

(defn black-box-testing [coll]
  (let [empty-coll (empty coll)]
    (cond
      (= empty-coll {}) :map
      (= empty-coll #{}) :set
      (reversible? coll) :vector
      :else :list)))

(defn convert-to-camel-case [s]
  (let [words (.split s "-")]
    (apply str
           (concat (first words) (map str/capitalize (rest words))))))

(defn partition-seq [n seq]
  (if (>= (count seq) n)
    (cons (take n seq) (partition-seq n (drop n seq)))))

(defn perfect-number [n]
  (=
    (apply +
           (filter (comp zero? (partial rem n)) (range 1 n))) n))

(defn lcm [& args]
  (letfn [(lcm-for-two-args [a b] (/ (* a b) (gcd a b)))]
    (reduce lcm-for-two-args args)))

(defn happy-numbers
  ([n] (happy-numbers n 0))
  ([n iteration-count]
   (let [digits (map #(Character/getNumericValue %) (str n))
         squares-sum (reduce + (map #(* % %) digits))]
     (cond
       (= n 1) true
       (= n squares-sum) false
       (> iteration-count 100) false
       :else (recur squares-sum (inc iteration-count))))))

(defn balance-of [n]
  (let [digits (map #(Character/getNumericValue %) (str n))
        mid-point (quot (count digits) 2)
        left-digits (take mid-point digits)
        right-digits (take-last mid-point digits)
        sum-digits (partial apply +)]
    (= (sum-digits left-digits) (sum-digits right-digits))))

(defn digit-bases [n base]
  (if (< n base)
    [n]
    (concat (digit-bases (int (/ n base)) base) [(mod n base)])))

(defn my-reductions
  ([f coll]
   (lazy-seq
     (if-let [s (seq coll)]
       (my-reductions f (first s) (rest s))
       (list (f)))))
  ([f init coll]
   (cons init
         (lazy-seq
           (when-let [s (seq coll)]
             (my-reductions f (f init (first s)) (rest s)))))))

(defn find-distinct-el [coll]
  (->> coll
       (partition-by identity)
       (remove #(> (count %) 1))
       first
       first))

(defn find-distinct-el-numbers-only [coll]
  (reduce bit-xor coll))

(defn power-set [coll]
  (set (reduce #(concat %1 (map (fn [i] (set (conj i %2))) %1)) #{#{}} coll)))

(defn my-trampoline
  ([f & args]
   (my-trampoline (apply f args)))
  ([f]
   (let [ret (f)]
     (if (fn? ret) (recur ret) ret))))

(defn is-tree? [root]
  (or (nil? root)
      (and (sequential? root)
           (= 3 (count root))
           (every? is-tree? (rest root)))))

(defn symetric? [[_ left right]]
  (let [has-more-branches (and (coll? left) (coll? right))]
    (if has-more-branches
      (let [[LV LL LR] left
            [RV RL RR] right]
        (and (= LV RV)
             (symetric? [nil LL RR])
             (symetric? [nil RL LR])))
      (= left right))))