(ns clojure_noob.core_test
  (:require [clojure.test :refer :all]
            [clojure_noob.common_problems :refer :all]
            [clojure_noob.core :refer :all]))

(deftest a-test-avarage
  (testing "Average function works just fine"
    (is (= (avarage [1 2 3 4 -1 3]) 2))))

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