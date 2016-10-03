(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.common_problems :refer :all]))

(deftest a-test-common-problems-factorial
  (testing "Factorial function works just fine"
    (are [input expected]
      (= (factorial input) expected)
      1 1
      5 120
      15 1307674368000
      )))

(deftest a-test-common-problems-fibonacci
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= (fibonacci input) expected)
      0 0
      1 1
      2 1
      7 13
      10 55
      18 2584
      26 121393
      150 9969216677189303386214405760200N
      )))

(deftest a-test-common-problems-prime-numbers
  (testing "prime? function works just fine"
    (are [input expected]
      (= (prime? input) expected)
      2 true
      5 true
      8 false
      4 false
      73 true
      75 false
      )))

(deftest a-length-for-sequence
  (testing "length works for various types of sequence"
    (are [input expected]
      (= (length input) expected)
      '(1 2 3 4 5 6) 6
      #{"aas" "fas" "msas"} 3
      {:foo "bar" :buzz "bar"} 2
      "four" 4
      [1 2 3] 3
      )))

(deftest a-reverse-for-sequence
  (testing "reverse works for various types of sequence"
    (are [input expected]
      (= (my-reverse input) expected)
      '(1 2 3 4 5 6) '(6 5 4 3 2 1)
      (sorted-set 1 2 3 4 5 6) '(6 5 4 3 2 1)
      [1 2 3] [3 2 1]
      )))

(deftest a-test-common-problems-fibonacci-range
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= (fibonacci-range input) expected)
      3 '(1 1 2)
      6 '(1 1 2 3 5 8)
      8 '(1 1 2 3 5 8 13 21)
      )))

(deftest a-test-common-problems-fibonacci-range
  (testing "Fibonacci function works just fine"
    (are [input expected]
      (= (palindrome? input) expected)
      '(1 2 3 4 5) false
      "racecar" true
      [:foo :bar :foo] true
      '(1 1 3 3 1 1) true)))

(deftest a-test-common-problems-my-flatten
  (testing "my-flatten function works just fine"
    (are [input expected]
      (= (my-flatten input) expected)
      '((1 2) 3 [4 [5 6]]) '(1 2 3 4 5 6)
      ["a" ["b"] "c"] '("a" "b" "c")
      '((((:a)))) '(:a)
      )))

(deftest a-test-filter-caps-chars
  (testing "filter-caps-chars works just fine"
    (are [input expected]
      (= (filter-caps-chars input) expected)
      "aCsFasfasFFASFA" "CFFFASFA"
      "HeLlO, WoRlD!" "HLOWRD"
      "nothing" ""
      "$#A(*&987Zf" "AZ"
      )))

(deftest a-test-common-problems-compress-sequence
  (testing "compress function works just fine"
    (are [input expected]
      (= (compress input) expected)
      "Leeeeeerrroyyy" "Leroy"
      [1 1 2 3 3 2 2 3] '(1 2 3 2 3)
      [[1 2] [1 2] [3 4] [1 2]] '([1 2] [3 4] [1 2])
      )))

(deftest a-test-common-problems-pack-sequence
  (testing "seq-pack function works just fine"
    (are [input expected]
      (= (seq-pack input) expected)
      [1 1 2 1 1 1 3 3] '((1 1) (2) (1 1 1) (3 3))
      [:a :a :b :b :c] '((:a :a) (:b :b) (:c))
      [[1 2] [1 2] [3 4]] '(([1 2] [1 2]) ([3 4]))
      )))

(deftest a-test-common-problems-duplicate-each-element-of-a-seq
  (testing "seq-duplicate function works just fine"
    (are [input expected]
      (= (seq-duplicate input) expected)
      [1 2 3] '(1 1 2 2 3 3)
      [:a :a :b :b] '(:a :a :a :a :b :b :b :b)
      [[1 2] [3 4]] '([1 2] [1 2] [3 4] [3 4])
      )))

(deftest a-test-common-problems-replicate-seq-n-times
  (testing "seq-replicate function works just fine"
    (are [input times expected]
      (= (seq-replicate input times) expected)
      [1 2 3] 2 '(1 1 2 2 3 3)
      [:a :b] 4 '(:a :a :a :a :b :b :b :b)
      [4 5 6] 1 '(4 5 6)
      [[1 2] [3 4]] 2 '([1 2] [1 2] [3 4] [3 4])
      [44 33] 2 [44 44 33 33]
      )))

(deftest a-test-common-problem-implement-own-range
  (testing "my-range function works just fine"
    (are [start end expected]
      (= (my-range start end) expected)
      1 4 '(1 2 3)
      -2 2 '(-2 -1 0 1)
      5 8 '(5 6 7)
      1 11 '(1 2 3 4 5 6 7 8 9 10)
      )))

(deftest a-test-common-problem-implement-own-max-key
  (testing "my-max-key function works just fine"
    (are [input expected]
      (= (apply my-max-key input) expected)
      [1 8 3 4] 8
      [30 20] 30
      [45 67 11] 67
      )))


(deftest a-test-common-problem-implement-own-interpose
  (testing "my-interpose function works just fine"
    (are [item-to-interpose coll expected]
      (= (my-interpose item-to-interpose coll) expected)
      0 [1 2 3] [1 0 2 0 3]
      :z [:a :b :c :d] [:a :z :b :z :c :z :d]
      )))