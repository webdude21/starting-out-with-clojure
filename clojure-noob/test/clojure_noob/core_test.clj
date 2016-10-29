(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.common_problems :refer :all]))

(deftest a-test-common-problems-factorial
  (testing "Factorial function works just fine"
    (are [input expected]
      (= expected (factorial input))
      1 1
      5 120
      15 1307674368000)))

(deftest a-test-common-problems-fibonacci
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= expected (fibonacci input))
      0 0
      1 1
      2 1
      7 13
      10 55
      18 2584
      26 121393
      150 9969216677189303386214405760200N)))

(deftest a-test-common-problems-fibonacci-seq
  (testing "Fibonacci-seq function works just fine"
    (are [input expected]
      (= expected (take input (fibonacci-seq)))
      0 '()
      1 '(0)
      2 '(0 1)
      7 '(0 1 1 2 3 5 8)
      10 '(0 1 1 2 3 5 8 13 21 34)
      18 '(0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597))))

(deftest a-test-common-problems-prime-numbers
  (testing "prime? function works just fine"
    (are [input expected]
      (= expected (prime? input))
      2 true
      5 true
      8 false
      4 false
      73 true
      75 false)))

(deftest a-length-for-sequence
  (testing "length works for various types of sequence"
    (are [input expected]
      (= expected (length input))
      '(1 2 3 4 5 6) 6
      #{"aas" "fas" "msas"} 3
      {:foo "bar" :buzz "bar"} 2
      "four" 4
      [1 2 3] 3)))


(deftest a-reverse-for-sequence
  (testing "reverse works for various types of sequence"
    (are [input expected]
      (= expected (my-reverse input))
      '(1 2 3 4 5 6) '(6 5 4 3 2 1)
      (sorted-set 1 2 3 4 5 6) '(6 5 4 3 2 1)
      [1 2 3] [3 2 1])))

(deftest a-test-common-problems-fibonacci-range
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= expected (fibonacci-range input))
      3 '(1 1 2)
      6 '(1 1 2 3 5 8)
      8 '(1 1 2 3 5 8 13 21))))

(deftest a-test-common-problems-fibonacci-range
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= expected (palindrome? input))
      '(1 2 3 4 5) false
      "racecar" true
      [:foo :bar :foo] true
      '(1 1 3 3 1 1) true)))

(deftest a-test-common-problems-my-flatten
  (testing "my-flatten function works just fine"
    (are [input expected]
      (= expected (my-flatten input))
      '((1 2) 3 [4 [5 6]]) '(1 2 3 4 5 6)
      ["a" ["b"] "c"] '("a" "b" "c")
      '((((:a)))) '(:a))))

(deftest a-test-filter-caps-chars
  (testing "filter-caps-chars works just fine"
    (are [input expected]
      (= expected (filter-caps-chars input))
      "aCsFasfasFFASFA" "CFFFASFA"
      "HeLlO, WoRlD!" "HLOWRD"
      "nothing" ""
      "$#A(*&987Zf" "AZ")))

(deftest a-test-common-problems-compress-sequence
  (testing "compress function works just fine"
    (are [input expected]
      (= expected (compress input))
      "Leeeeeerrroyyy" "Leroy"
      [1 1 2 3 3 2 2 3] '(1 2 3 2 3)
      [[1 2] [1 2] [3 4] [1 2]] '([1 2] [3 4] [1 2]))))

(deftest a-test-common-problems-pack-sequence
  (testing "seq-pack function works just fine"
    (are [input expected]
      (= expected (seq-pack input))
      [1 1 2 1 1 1 3 3] '((1 1) (2) (1 1 1) (3 3))
      [:a :a :b :b :c] '((:a :a) (:b :b) (:c))
      [[1 2] [1 2] [3 4]] '(([1 2] [1 2]) ([3 4])))))

(deftest a-test-common-problems-duplicate-each-element-of-a-seq
  (testing "seq-duplicate function works just fine"
    (are [input expected]
      (= expected (seq-duplicate input))
      [1 2 3] '(1 1 2 2 3 3)
      [:a :a :b :b] '(:a :a :a :a :b :b :b :b)
      [[1 2] [3 4]] '([1 2] [1 2] [3 4] [3 4]))))

(deftest a-test-common-problems-replicate-seq-n-times
  (testing "seq-replicate function works just fine"
    (are [input times expected]
      (= expected (seq-replicate input times))
      [1 2 3] 2 '(1 1 2 2 3 3)
      [:a :b] 4 '(:a :a :a :a :b :b :b :b)
      [4 5 6] 1 '(4 5 6)
      [[1 2] [3 4]] 2 '([1 2] [1 2] [3 4] [3 4])
      [44 33] 2 [44 44 33 33])))

(deftest a-test-common-problem-implement-own-range
  (testing "my-range function works just fine"
    (are [start end expected]
      (= expected (my-range start end))
      1 4 '(1 2 3)
      -2 2 '(-2 -1 0 1)
      5 8 '(5 6 7)
      1 11 '(1 2 3 4 5 6 7 8 9 10))))

(deftest a-test-common-problem-implement-own-max-key
  (testing "my-max-key function works just fine"
    (are [input expected]
      (= expected (apply my-max-key input))
      [1 8 3 4] 8
      [30 20] 30
      [45 67 11] 67)))

(deftest a-test-common-problem-implement-own-interpose
  (testing "my-interpose function works just fine"
    (are [item-to-interpose coll expected]
      (= (my-interpose item-to-interpose coll) expected)
      0 [1 2 3] [1 0 2 0 3]
      :z [:a :b :c :d] [:a :z :b :z :c :z :d])))

(deftest a-test-common-problem-implement-drop-n-th-element
  (testing "drop-n-th-element function works jut fine"
    (are [input times expected]
      (= expected (drop-every-nth-element input times))
      [1 2 3 4 5 6 7 8] 3 [1 2 4 5 7 8]
      [:a :b :c :d :e :f] 2 [:a :c :e]
      [1 2 3 4 5 6] 4 [1 2 3 5 6])))

(deftest a-test-common-problem-implement-own-reverse-interleave
  (testing "my-interpose function works just fine"
    (are [seq el expected]
      (= expected (reverse-interleave seq el))
      [1 2 3 4 5 6] 2 '((1 3 5) (2 4 6))
      (range 9) 3 '((0 3 6) (1 4 7) (2 5 8))
      (range 10) 5 '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(deftest a-test-common-problem-implement-rotate
  (testing "rotate function works just fine"
    (are [offset seq expected]
      (= expected (rotate offset seq))
      2 [1 2 3 4 5] '(3 4 5 1 2)
      -2 [1 2 3 4 5] '(4 5 1 2 3)
      6 [1 2 3 4 5] '(2 3 4 5 1)
      1 '(:a :b :c) '(:b :c :a)
      -4 '(:a :b :c) '(:c :a :b))))

(deftest a-test-common-problem-split-a-sequence
  (testing "split-a-sequence function works just fine"
    (are [split-point seq expected]
      (= expected (split-a-sequence split-point seq))
      3 [1 2 3 4 5 6] [[1 2 3] [4 5 6]]
      1 [:a :b :c :d] [[:a] [:b :c :d]]
      2 [[1 2] [3 4] [5 6]] [[[1 2] [3 4]] [[5 6]]])))

(deftest a-test-common-problem-count-occurance
  (testing "count-occurance function works just fine"
    (are [input expected]
      (= expected (count-occurances input))
      [1 1 2 3 2 1 1] {1 4, 2 2, 3 1}
      [:b :a :b :a :b] {:a 2, :b 3}
      '([1 2] [1 3] [1 3]) {[1 2] 1, [1 3] 2})))

(deftest a-test-common-problem-my-distinct
  (testing "my-distinct function works just fine"
    (are [input expected]
      (= expected (my-distinct input))
      [1 2 1 3 1 2 4] [1 2 3 4]
      [:a :a :b :b :c :c] [:a :b :c]
      '([2 4] [1 2] [1 3] [1 3]) '([2 4] [1 2] [1 3])
      (range 50) (range 50))))

(deftest a-test-common-problem-count-occurance
  (testing "split-a-sequence function works just fine"
    (are [input expected]
      (= expected (count-occurances input))
      [1 1 2 3 2 1 1] {1 4, 2 2, 3 1}
      [:b :a :b :a :b] {:a 2, :b 3}
      '([1 2] [1 3] [1 3]) {[1 2] 1, [1 3] 2})))

(deftest a-test-common-problem-generate-prime-seq
  (testing "primes function works just fine"
    (are [input expected]
      (= expected (primes input))
      2 [2 3]
      5 [2 3 5 7 11])))

(deftest a-test-common-set-intersection
  (testing "set-intersection function works just fine"
    (are [a b expected]
      (= expected (set-intersection a b))
      #{:a :b :c :d} #{:c :e :a :f :d} #{:a :c :d}
      #{0 1 2} #{3 4 5} #{}
      #{0 1 2 3} #{2 3 4 5} #{2 3})))

(deftest a-test-common-problem-re-implement-iterate
  (testing "re-implement-iterate function works just fine"
    (are [size-to-take inc-fn start-el expected]
      (= expected (take size-to-take (re-iterate inc-fn start-el)))
      5 #(* 2 %) 1 [1 2 4 8 16]
      100 inc 0 (take 100 (range))
      9 #(inc (mod % 3)) 1 (take 9 (cycle [1 2 3])))))

(deftest a-test-common-symmetric-difference
  (testing "implement-symmetric-difference"
    (are [a b expected]
      (= expected (symetric-difference a b))
      #{1 2 3 4 5 6} #{1 3 5 7} #{2 4 6 7}
      #{} #{4 5 6} #{4 5 6}
      #{[1 2] [2 3]} #{[2 3] [3 4]} #{[1 2] [3 4]})))

(deftest a-test-common-dot-product
  (testing "implement-dot-product"
    (are [expected a b]
      (= expected (dot-product a b))
      0 [0 1 0] [1 0 0]
      3 [1 1 1] [1 1 1]
      32 [1 2 3] [4 5 6]
      256 [2 5 6] [100 10 1])))